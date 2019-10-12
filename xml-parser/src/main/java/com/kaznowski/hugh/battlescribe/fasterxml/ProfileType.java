package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class ProfileType {
  private List<CharacteristicType> characteristicTypes;
  private String id;
  private String name;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }
}
