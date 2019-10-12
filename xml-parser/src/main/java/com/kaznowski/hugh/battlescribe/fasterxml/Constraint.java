package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

@Data
public class Constraint {
  private String field;
  private String scope;
  private String value;
  private Boolean percentValue;
  private Boolean shared;
  private Boolean includeChildSelections;
  private Boolean includeChildForces;
  private String id;
  private Type type;

  public void setField( String field ) {
    IdTracker.INSTANCE.register( field );
    this.field = field;
  }

  public void setScope( String scope ) {
    IdTracker.INSTANCE.register( scope );
    this.scope = scope;
  }

  public void setValue( String value ) {
    IdTracker.INSTANCE.register( value );
    this.value = value;
  }

  public void setId( String id ) {
    IdTracker.INSTANCE.register( id );
    this.id = id;
  }

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public enum Type {
    min,
    max
  }
}
