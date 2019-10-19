package com.kaznowski.hugh.battlescribe.domain;

import com.kaznowski.hugh.battlescribe.domain.model.Unit;
import com.kaznowski.hugh.battlescribe.fasterxml.Characteristic;
import com.kaznowski.hugh.battlescribe.fasterxml.Profile;
import com.kaznowski.hugh.battlescribe.fasterxml.SelectionEntry;
import com.kaznowski.hugh.battlescribe.warhammer40k.W40kProfileType;

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
        try {
          List<Characteristic> properties = profile.getCharacteristics();
          CharacteristicList characteristicList = new CharacteristicList( properties );
          unit.setMovement( characteristicList.getByName( "M" ).getValue() );
          unit.setWeaponSkill( characteristicList.getByName( "WS" ).getValue() );
          unit.setBallisticSkill( characteristicList.getByName( "BS" ).getValue() );
          unit.setStrength( characteristicList.getByName( "S" ).getValue() );
          unit.setToughness( characteristicList.getByName( "T" ).getValue() );
          unit.setWounds( characteristicList.getByName( "W" ).getValue() );
          unit.setAttacks( characteristicList.getByName( "A" ).getValue() );
          unit.setLeadership( characteristicList.getByName( "Ld" ).getValue() );
          unit.setSaves( characteristicList.getByName( "Save" ).getValue() );
        }
        catch ( Exception e ) {
          throw new UnitException( "Failed to process profile " + profile.getId(), e );
        }
      }
    }
    return unit;
  }

  private class CharacteristicList extends FilterList<Characteristic> {

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
