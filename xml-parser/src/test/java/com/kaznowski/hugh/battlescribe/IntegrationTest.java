package com.kaznowski.hugh.battlescribe;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kaznowski.hugh.battlescribe.fasterxml.Catalogue;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class IntegrationTest {
  // Integration tests because I dont want to set up *IT
  @Test
  void canParseAll40kFiles() throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    List<File> files = Arrays.asList( new File( "../wh40k/Tyranids.cat" ) );
    for ( File dataset : files ) {
      try {
        xmlMapper.readValue( new FileReader( dataset ), Catalogue.class );
      }
      catch ( Exception e ) {
        throw new RuntimeException( "Failed to parse " + dataset, e );
      }
    }
    IdTracker.INSTANCE.save( new File( "Dump.txt" ) );
  }

  public static List<File> allDatasets() {
    return
        Stream.of( Objects.requireNonNull( new File( "../wh40k" ).listFiles() ) )
              .filter( file -> file.getName().endsWith( ".cat" ) )
              .collect( Collectors.toList() );
  }
}
