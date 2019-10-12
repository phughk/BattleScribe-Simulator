package com.kaznowski.hugh.battlescribe.emulator.loader;

import com.kaznowski.hugh.battlescribe.emulator.game.Unit;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.kaznowski.hugh.battlescribe.emulator.fixture.RealDatasetFixture.tyranidDataset;
import static com.kaznowski.hugh.battlescribe.emulator.matcher.UnitMatcher.unitWithName;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleScribeLoaderTest {

  @Test
  @Disabled( "Fix this after fasterxml serialisation done and fasterxml->domain" )
  void datasetContainsUnits() {
    File datasetSource = tyranidDataset();

    BattleScribeLoader battleScribeLoader = new BattleScribeLoader();
    Dataset dataset = battleScribeLoader.load( datasetSource );

    assertThat( dataset.getUnits(), hasItem( unitWithName( equalTo( "Broodlord" ) ) ) );
  }

  @Test
  @Disabled( "Fix this after fasterxml serialisation done and fasterxml->domain" )
  void statsAreLoaded() {
    File datasetSource = tyranidDataset();

    BattleScribeLoader battleScribeLoader = new BattleScribeLoader();
    Dataset dataset = battleScribeLoader.load( datasetSource );

    Unit broodlord = dataset
        .getUnits()
        .stream()
        .filter( unit -> unit.getName().equals( "Broodlord" ) )
        .findFirst()
        .orElseThrow( () -> new RuntimeException( format( "No unit Broodlord in %s", dataset.getUnits() ) ) );
    assertEquals( "2+", broodlord.getWeaponSkill() );
  }
}
