package com.kaznowski.hugh.battlescribe.domain;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kaznowski.hugh.battlescribe.DatasetFixtures;
import com.kaznowski.hugh.battlescribe.domain.model.Model;
import com.kaznowski.hugh.battlescribe.domain.model.Unit;
import com.kaznowski.hugh.battlescribe.fasterxml.Catalogue;
import com.kaznowski.hugh.battlescribe.fasterxml.SelectionEntry;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UnitFactoryTest {
  @Test
  void canLoadSimpleUnitStats() throws Exception {
    // given a unit that has it's profile character data attached in the shared entities tags
    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( new FileReader( DatasetFixtures.greyKnightsDataset() ),
        Catalogue.class );
    SearchableList<SelectionEntry> sharedSelectionEntries =
        new SearchableList<>( catalogue.getSharedSelectionEntries() );
    SelectionEntry simpleUnit = sharedSelectionEntries.exactlyOne( matchingName( "Paladin Ancient" ) );

    // when Unit data is processed
    UnitFactory unitFactory = new UnitFactory();
    Unit paladinAncientUnit = unitFactory.processUnit( simpleUnit );
    List<Model> paladinAncientModels = new ArrayList<>( paladinAncientUnit.getModels() );
    assertEquals( 1, paladinAncientModels.size() );
    Model paladinAncient = paladinAncientModels.get( 0 );

    // then the data is available
    assertEquals( "5\"", paladinAncient.getMovement() );
    assertEquals( "2+", paladinAncient.getWeaponSkill() );
    assertEquals( "3+", paladinAncient.getBallisticSkill() );
    assertEquals( "4", paladinAncient.getStrength() );
    assertEquals( "4", paladinAncient.getToughness() );
    assertEquals( "5", paladinAncient.getWounds() );
    assertEquals( "4", paladinAncient.getAttacks() );
    assertEquals( "8", paladinAncient.getLeadership() );
    assertEquals( "2+/5++", paladinAncient.getSaves() );
  }

  /**
   * Units that have only upgraded models are described in the selectionEntry's selectionEntryGroups
   * The number is described with the modifier condition linking to the selectionEntryGroups
   */
  @Test
  void canLoadLinkedProfileData() throws Exception { // TODO name change?
    // given a unit with linked data
    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue =
        xmlMapper.readValue( new FileReader( DatasetFixtures.greyKnightsDataset() ), Catalogue.class );
    SearchableList<SelectionEntry> allSelectionEntries = new SearchableList<>( catalogue.getSharedSelectionEntries() );
    SelectionEntry linkedUnit = allSelectionEntries.exactlyOne( matchingName( "Strike Squad" ) );

    // when Unit data is processed
    UnitFactory unitFactory = new UnitFactory();
    Unit strikeSquad = unitFactory.processUnit( linkedUnit );
    List<Model> models = new ArrayList<>( strikeSquad.getModels() );
    assertThat( models.size(), greaterThan( 0 ) );

    // then
    Model strikeSquadModel = models.get( 0 );
    assertNotNull( strikeSquadModel.getSaves() );
  }

  private static Predicate<SelectionEntry> matchingName( String name ) {
    return selectionEntry -> selectionEntry.getName().equals( name );
  }


  static class SearchableList<E> {
    private final List<E> list;

    public SearchableList( List<E> list ) {
      this.list = list;
    }

    public Stream<E> findMatching( Predicate<E> predicate ) {
      return list.stream().filter( predicate );
    }

    public E exactlyOne( Predicate<E> predicate ) {
      return findMatching( predicate ).findFirst().orElseThrow( () -> new RuntimeException( "Not exactly one" ) );
    }
  }
}
