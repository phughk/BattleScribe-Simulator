package com.kaznowski.hugh.battlescribe.emulator.fixture;

import java.io.File;

public class RealDatasetFixture {
  public static File tyranidDataset() {
    return new File( "wh40k/Tyranids.cat" );
  }

  public static File drukhariDataset() {
    return new File( "wh40k/Aeldari - Drukhari.cat" );
  }

  public static File deathGuardDataset() {
    return new File( "wh40k/Chaos - Death Guard.cat" );
  }
}
