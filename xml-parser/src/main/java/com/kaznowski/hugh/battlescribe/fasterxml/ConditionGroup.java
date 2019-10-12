package com.kaznowski.hugh.battlescribe.fasterxml;

import com.kaznowski.hugh.battlescribe.IdTracker;
import lombok.Data;

import java.util.List;

@Data
public class ConditionGroup {
  private Type type;
  private List<Condition> conditions;
  private List<ConditionGroup> conditionGroups;

  public void setType( String type ) {
    IdTracker.INSTANCE.register( type );
    this.type = Type.valueOf( type );
  }

  public enum Type {
    or,
    and
  }
}
