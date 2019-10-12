package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class CategoryLink {
  private String id;
  private String name;
  private Boolean hidden;
  private String targetId;
  private Boolean primary;
  private String publicationId;
  private List<Constraint> constraints;
  private List<Modifier> modifiers;

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
}
