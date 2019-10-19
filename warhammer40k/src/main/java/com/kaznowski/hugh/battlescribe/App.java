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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
  public static void main( String[] args ) throws IOException {
//    File file = new File( "../wh40k/Imperium - Grey Knights.cat" );
//    File file = new File( "../wh40k/Tyranids.cat" );
//    File file = new File( "../wh40k/Orks.cat" );
    Map<File,Exception> failures = new HashMap<>();
    for ( File file : allDatasets() ) {
      try {
        mainFile( file );
      }
      catch ( Exception e ) {
        failures.put( file, e );
      }
    }
    for ( Map.Entry<File,Exception> entry : failures.entrySet() ) {
      System.err.println( "Failed for file " + entry.getKey() );
      entry.getValue().printStackTrace( System.err );
    }
  }

  private static void mainFile( File file ) throws IOException {
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

  public static List<File> allDatasets() {
    return
        Stream.of( Objects.requireNonNull( new File( "../wh40k" ).listFiles() ) )
              .filter( file -> file.getName().endsWith( ".cat" ) )
              .collect( Collectors.toList() );
  }
}
