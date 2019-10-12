package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class Modifier {
  private Type type;
  private String field;
  private String value;
  private List<Condition> conditions;
  private List<Repeat> repeats;
  private List<ConditionGroup> conditionGroups;

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public void setField( String field ) {
    IdTracker.INSTANCE.register( field );
    this.field = field;
  }

  public void setValue( String value ) {
    IdTracker.INSTANCE.register( value );
    this.value = value;
  }

  public static enum Type {
    add,
    set,
    decrement,
    increment,
    append,
    remove
  }
}
