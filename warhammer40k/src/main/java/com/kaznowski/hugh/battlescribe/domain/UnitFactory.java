package com.kaznowski.hugh.battlescribe.domain;

import com.kaznowski.hugh.battlescribe.domain.model.Unit;
import com.kaznowski.hugh.battlescribe.fasterxml.Characteristic;
import com.kaznowski.hugh.battlescribe.fasterxml.Profile;

import java.util.List;

public class UnitFactory {
  public Unit processProfile( Profile profile ) {
    try {
      List<Characteristic> properties = profile.getCharacteristics();
      CharacteristicList characteristicList = new CharacteristicList( properties );
      Unit unit = new Unit();
      unit.setMovement( characteristicList.getByName( "M" ).getValue() );
      unit.setWeaponSkill( characteristicList.getByName( "WS" ).getValue() );
      unit.setBallisticSkill( characteristicList.getByName( "BS" ).getValue() );
      unit.setStrength( characteristicList.getByName( "S" ).getValue() );
      unit.setToughness( characteristicList.getByName( "T" ).getValue() );
      unit.setWounds( characteristicList.getByName( "W" ).getValue() );
      unit.setAttacks( characteristicList.getByName( "A" ).getValue() );
      unit.setLeadership( characteristicList.getByName( "Ld" ).getValue() );
      unit.setSaves( characteristicList.getByName( "Save" ).getValue() );
      return unit;
    }
    catch ( Exception e ) {
      throw new UnitException( "Failed to process profile " + profile.getId(), e );
    }
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
