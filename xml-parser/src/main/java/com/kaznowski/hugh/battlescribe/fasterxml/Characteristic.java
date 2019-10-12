package com.kaznowski.hugh.battlescribe.fasterxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

@Data
public class Characteristic {
  private String name;
  private String typeId;
  @JacksonXmlText
  private String value;

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setTypeId( String typeId ) {
    IdTracker.INSTANCE.register( typeId );
    this.typeId = typeId;
  }
}
