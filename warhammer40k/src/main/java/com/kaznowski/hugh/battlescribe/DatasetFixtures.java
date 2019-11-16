package com.kaznowski.hugh.battlescribe;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatasetFixtures {

  public static File greyKnightsDataset() {
    return new File( "../wh40k/Imperium - Grey Knights.cat" );
  }

  public static List<File> allDatasets() {
    return
        Stream.of( Objects.requireNonNull( new File( "../wh40k" ).listFiles() ) )
              .filter( file -> file.getName().endsWith( ".cat" ) )
              .collect( Collectors.toList() );
  }
}
