package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

/**
 * Describes a book that was used to source the information.
 */
@Data
public class Publication {
  private String id;
  /**
   * This is the name of the games workshop book where the information is described
   */
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
