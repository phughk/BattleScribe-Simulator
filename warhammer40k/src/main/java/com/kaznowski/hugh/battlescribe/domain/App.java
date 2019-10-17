package com.kaznowski.hugh.battlescribe.domain;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kaznowski.hugh.battlescribe.fasterxml.Catalogue;
import com.kaznowski.hugh.battlescribe.fasterxml.InfoLink;
import com.kaznowski.hugh.battlescribe.fasterxml.Profile;
import com.kaznowski.hugh.battlescribe.fasterxml.SelectionEntry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
  public static void main( String[] args ) throws IOException {
    File file = new File( "../wh40k/Tyranids.cat" );
    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( file, Catalogue.class );

    // Schema description
    // https://github.com/BSData/catalogue-development/wiki/Data-structure-overview

    List<Unit> units = catalogue.getSharedSelectionEntries()
                                .stream()
                                .filter( notUpgrades() )
                                .peek( App::debugPrintSelectionEntry )
                                .map( findUnitCharacteristicProfiles( catalogue ) )
                                .map( selectionEntry -> new Unit( selectionEntry ) )
                                .peek( unit -> System.out.printf( "Completed unit %s\n", unit ) )
                                .collect( Collectors.toList() );
    System.out.println( units );
  }

  private static void debugPrintSelectionEntry( SelectionEntry selectionEntry ) {
    System.out.printf( "SelectionId %s with name %s\n", selectionEntry.getId(), selectionEntry.getName() );
  }

  private static Function<SelectionEntry,List<Profile>> findUnitCharacteristicProfiles( Catalogue catalogue ) {
    return selectionEntry -> {
      List<Profile> profiles = new ArrayList<>();
      selectionEntry
          .getProfiles()
          .stream()
          .filter( profile -> profile.getTypeName().equals( "Unit" ) )
          .forEach( profiles::add );
      if ( profiles.size() > 0 ) {
        return profiles;
      }
      selectionEntry
          .getSelectionEntries()
          .stream()
          .map( SelectionEntry::getProfiles )
          .flatMap( Collection::stream )
          .filter( profile -> profile.getTypeName().equals( "Unit" ) )
          .forEach( profiles::add );
      if ( profiles.size() > 0 ) {
        return profiles;
      }
      // It's possible that a unit will share data. In that situation it should have an info link to a
      // profile with a characteristic
      selectionEntry
          .getSelectionEntries()
          .stream()
          .map( SelectionEntry::getInfoLinks )
          .peek( infoLinks -> System.out.printf( "Got info links %s\n", infoLinks ) )
          .filter( notEmpty() )
          .map( findSourceProfile( catalogue ) )
          .forEach( profiles::addAll );
      if ( profiles.size() > 0 ) {
        return profiles;
      }

      throw new IllegalStateException( "No characteristic profiles for " + selectionEntry );
    };
  }

  private static Predicate<? super List<InfoLink>> notEmpty() {
    return list -> (list != null) && (list.size() > 0);
  }

  private static Function<List<InfoLink>,List<Profile>> findSourceProfile( Catalogue catalogue ) {
    return infoLinks -> {
      List<String> infoLinkTargets = infoLinks
          .stream()
          .map( InfoLink::getTargetId )
          .collect( Collectors.toList() );
      return catalogue.getSharedProfiles()
                      .stream()
                      .filter( hasIdMatching( infoLinkTargets ) )
                      .collect( Collectors.toList() );
    };
  }

  private static Predicate<Profile> hasIdMatching( List<String> targetIds ) {
    return profile -> targetIds.contains( profile.getId() );
  }

  private static Predicate<SelectionEntry> notUpgrades() {
    return selectionEntry -> selectionEntry.getType() != SelectionEntry.Type.upgrade;
  }
}
