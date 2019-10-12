package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class Rule {
  private String id;
  private String name;
  private String publicationId;
  private String page;
  private Boolean hidden;
  private String description;
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
}
