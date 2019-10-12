package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

@Data
public class Condition {
  private String field;
  private String scope;
  private String value;
  private Boolean percentValue;
  private String shared;
  private Boolean includeChildSelections;
  private Boolean includeChildForces;
  private String childId;
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

  public void setShared( String shared ) {
    IdTracker.INSTANCE.register( shared );
    this.shared = shared;
  }

  public void setChildId( String childId ) {
    IdTracker.INSTANCE.register( childId );
    this.childId = childId;
  }

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public enum Type {
    notInstanceOf,
    lessThan,
    equalTo,
    atLeast,
    atMost,
    greaterThan,
    instanceOf,
    notEqualTo
  }
}
