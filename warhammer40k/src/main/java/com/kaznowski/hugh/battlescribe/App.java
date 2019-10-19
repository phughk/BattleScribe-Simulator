package com.kaznowski.hugh.battlescribe;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kaznowski.hugh.battlescribe.domain.UnitFactory;
import com.kaznowski.hugh.battlescribe.domain.model.Unit;
import com.kaznowski.hugh.battlescribe.fasterxml.Catalogue;
import com.kaznowski.hugh.battlescribe.fasterxml.SelectionEntry;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class App {
  public static void main( String[] args ) throws IOException {
    File file = new File( "../wh40k/Imperium - Grey Knights.cat" );
//    File file = new File( "../wh40k/Tyranids.cat" );
    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( file, Catalogue.class );

    // Schema description
    // https://github.com/BSData/catalogue-development/wiki/Data-structure-overview

    UnitFactory unitFactory = new UnitFactory();
    Collection<SelectionEntry> allSelectionEntries = new ArrayList<>();
    Optional.ofNullable( catalogue.getSelectionEntries() ).ifPresent( allSelectionEntries::addAll );
    Optional.ofNullable( catalogue.getSharedSelectionEntries() ).ifPresent( allSelectionEntries::addAll );
    for ( SelectionEntry selectionEntry : allSelectionEntries ) {
      if ( selectionEntry.getType() != SelectionEntry.Type.upgrade ) {
        Unit unit = unitFactory.processUnit( selectionEntry );
        System.out.println( "unit = " + unit );
      }
    }
  }

  private static Predicate<SelectionEntry> notUpgrades() {
    return selectionEntry -> selectionEntry.getType() != SelectionEntry.Type.upgrade;
  }
}
