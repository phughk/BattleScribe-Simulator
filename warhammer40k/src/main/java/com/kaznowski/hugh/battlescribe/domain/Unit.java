package com.kaznowski.hugh.battlescribe.domain;

import com.kaznowski.hugh.battlescribe.fasterxml.Characteristic;
import com.kaznowski.hugh.battlescribe.fasterxml.Profile;
import lombok.Data;

import java.util.List;

@Data
public class Unit {
  private String name;
  private String movement;
  private String weaponSkill;
  private String ballisticSkill;
  private String strength;
  private String toughness;
  private String wounds;
  private String attacks;
  private String leadership;
  private String saves;

  public Unit( List<Profile> profile ) {

    processCharacteristics( profile.get( 0 ) );
  }

  private void processCharacteristics( Profile profile ) {
    try {
      List<Characteristic> properties = profile.getCharacteristics();
      CharacteristicList characteristicList = new CharacteristicList( properties );
      movement = characteristicList.getByName( "M" ).getValue();
      weaponSkill = characteristicList.getByName( "WS" ).getValue();
      ballisticSkill = characteristicList.getByName( "BS" ).getValue();
      strength = characteristicList.getByName( "S" ).getValue();
      toughness = characteristicList.getByName( "T" ).getValue();
      wounds = characteristicList.getByName( "W" ).getValue();
      attacks = characteristicList.getByName( "A" ).getValue();
      leadership = characteristicList.getByName( "Ld" ).getValue();
      saves = characteristicList.getByName( "Save" ).getValue();
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
