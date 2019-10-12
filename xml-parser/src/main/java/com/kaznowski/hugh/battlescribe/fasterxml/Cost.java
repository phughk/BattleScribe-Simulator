package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

@Data
public class Cost {
  private String name;
  private String typeId;
  private String value;

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setTypeId( String typeId ) {
    IdTracker.INSTANCE.register( typeId );
    this.typeId = typeId;
  }

  public void setValue( String value ) {
    IdTracker.INSTANCE.register( value );
    this.value = value;
  }
}
