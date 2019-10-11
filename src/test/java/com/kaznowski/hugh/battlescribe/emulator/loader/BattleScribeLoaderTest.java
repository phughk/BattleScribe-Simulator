package com.kaznowski.hugh.battlescribe.emulator.loader;

import com.kaznowski.hugh.battlescribe.emulator.fixture.RealDatasetFixture;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.kaznowski.hugh.battlescribe.emulator.matcher.UnitMatcher.unitWithName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsIterableContaining.hasItem;

class BattleScribeLoaderTest {

  @Test
  void datasetContainsUnits() {
    File datasetSource = RealDatasetFixture.tyranidDataset();

    BattleScribeLoader battleScribeLoader = new BattleScribeLoader();
    Dataset dataset = battleScribeLoader.load( datasetSource );

    assertThat( dataset.getUnits(), hasItem( unitWithName( equalTo( "Broodlord" ) ) ) );
  }
}
