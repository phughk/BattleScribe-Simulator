package com.kaznowski.hugh.battlescribe.domain;

import com.kaznowski.hugh.battlescribe.domain.model.Model;
import com.kaznowski.hugh.battlescribe.domain.model.Unit;
import com.kaznowski.hugh.battlescribe.fasterxml.Characteristic;
import com.kaznowski.hugh.battlescribe.fasterxml.Constraint;
import com.kaznowski.hugh.battlescribe.fasterxml.Profile;
import com.kaznowski.hugh.battlescribe.fasterxml.SelectionEntry;
import com.kaznowski.hugh.battlescribe.fasterxml.SelectionEntryGroup;
import com.kaznowski.hugh.battlescribe.warhammer40k.W40kProfileType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UnitFactory {
  public Unit processUnit( SelectionEntry selectionEntry ) {
    Unit unit = new Unit();
    unit.setName( selectionEntry.getName() );
    if ( selectionEntry.getProfiles() != null ) {
      Optional<Profile> profileOptional =
          selectionEntry.getProfiles()
                        .stream()
                        .filter( profile1 -> W40kProfileType.getById( profile1.getTypeId() ) == W40kProfileType.UNIT )
                        .findFirst();
      if ( profileOptional.isPresent() ) {
        Profile profile = profileOptional.get();
        unit.setModels( singleModelUnit( profile, unit.getName() ) );
      }
      else {
        List<SelectionEntryGroup> unitsSelectionEntryGroups = selectionEntry.getSelectionEntryGroups();
      }
    }
    return unit;
  }

  private static List<Model> multiModelUnit( SelectionEntryGroup unitsSelectionEntryGroup ) {
    // Based on Grey Knight Strike Squad, the unit has a justicar and several grey knights.
    // Each grey knight has a weapon choice
    // The grey knights are represented by a min/max constraint in the first selection entry group
    // The selection entry group has a default model selection property
    // The selection entries that follow are the models (not justicar)
    String defaultId = unitsSelectionEntryGroup.getDefaultSelectionEntryId();
    Integer[] minMax = minMaxConstraint( unitsSelectionEntryGroup.getConstraints() );
    Integer min = minMax[0];
    Integer max = minMax[1];
    // Fill the unit with minimum number of default models
    List<Model> models = new ArrayList<>();
    for (SelectionEntry selectionEntry: unitsSelectionEntryGroup.getSelectionEntries() ) {
      // has an info link that points to the profile contained in shared profiles of root that has characteristics
    }
  }

  private static Integer[] minMaxConstraint( List<Constraint> constraints ) {
    Integer[] minMax = new Integer[2];
    minMax[0] = 0;
    minMax[1] = 100;
    return minMax;
  }

  private static List<Model> singleModelUnit( Profile profile, String unitName ) {
    try {
      List<Characteristic> properties = profile.getCharacteristics();
      CharacteristicList characteristicList = new CharacteristicList( properties );
      Model model = new Model();
      model.setName( unitName );
      model.setMovement( characteristicList.getByName( "M" ).getValue() );
      model.setWeaponSkill( characteristicList.getByName( "WS" ).getValue() );
      model.setBallisticSkill( characteristicList.getByName( "BS" ).getValue() );
      model.setStrength( characteristicList.getByName( "S" ).getValue() );
      model.setToughness( characteristicList.getByName( "T" ).getValue() );
      model.setWounds( characteristicList.getByName( "W" ).getValue() );
      model.setAttacks( characteristicList.getByName( "A" ).getValue() );
      model.setLeadership( characteristicList.getByName( "Ld" ).getValue() );
      model.setSaves( characteristicList.getByName( "Save" ).getValue() );
      return Arrays.asList( model );
    }
    catch ( Exception e ) {
      throw new UnitException( "Failed to process profile " + profile.getId(), e );
    }
  }

  private static class CharacteristicList extends FilterList<Characteristic> {

    CharacteristicList( List<Characteristic> list ) {
      super( list );
    }

    Characteristic getByName( String name ) {
      try {
        return get( cha -> name.equals( cha.getName() ) );
      }
      catch ( NoMatchException e ) {
        throw new UnitException( "Failed match for " + name, e );
      }
    }
  }

  static class UnitException extends RuntimeException {
    UnitException( String message, Exception cause ) {
      super( message, cause );
    }
  }
}
