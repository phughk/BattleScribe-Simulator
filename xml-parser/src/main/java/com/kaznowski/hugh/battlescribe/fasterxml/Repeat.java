package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

@Data
public class Repeat {
  private String field;
  private String scope;
  private String value;
  private String percentValue;
  private Boolean shared;
  private Boolean includeChildSelections;
  private Boolean includeChildForces;
  private String childId;
  private Integer repeats;
  private Boolean roundUp;

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

  public void setPercentValue( String percentValue ) {
    IdTracker.INSTANCE.register( percentValue );
    this.percentValue = percentValue;
  }

  public void setChildId( String childId ) {
    IdTracker.INSTANCE.register( childId );
    this.childId = childId;
  }
}
