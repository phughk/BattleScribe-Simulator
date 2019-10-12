package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class Profile {
  private String id;
  private String name;
  private String publicationId;
  private String page;
  private Boolean hidden;
  private String typeId;
  private String typeName;
  private List<Characteristic> characteristics;
  private List<Modifier> modifiers;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setPublicationId( String publicationId ) {
    IdTracker.INSTANCE.register( publicationId );
    this.publicationId = publicationId;
  }

  public void setTypeId( String typeId ) {
    IdTracker.INSTANCE.register( typeId );
    this.typeId = typeId;
  }

  public void setTypeName( String typeName ) {
    IdTracker.INSTANCE.register( typeName );
    this.typeName = typeName;
  }
}
