package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

@Data
public class CatalogueLink {
  private String id;
  private String name;
  private String targetId;
  private Type type;
  private String importRootEntries;

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public void setTargetId( String targetId ) {
    IdTracker.INSTANCE.register( targetId );
    this.targetId = targetId;
  }

  public enum Type {
    catalogue
  }
}
