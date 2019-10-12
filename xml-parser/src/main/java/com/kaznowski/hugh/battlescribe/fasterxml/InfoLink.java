package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class InfoLink {
  private String id;
  private String name;
  private Boolean hidden;
  private String targetId;
  private Type type;
  private List<Modifier> modifiers;
  private String page;
  private String publicationId;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setName( String name ) {
    IdTracker.INSTANCE.register( name );
    this.name = name;
  }

  public void setTargetId( String targetId ) {
    IdTracker.INSTANCE.register( targetId );
    this.targetId = targetId;
  }

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public void setPublicationId( String publicationId ) {
    IdTracker.INSTANCE.register( publicationId );
    this.publicationId = publicationId;
  }

  public enum Type {
    profile,
    infoGroup,
    rule
  }
}
