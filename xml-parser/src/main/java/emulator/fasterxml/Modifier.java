package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class Modifier {
  private String type;
  private String field;
  private String value; // TODO int?
  private List<Condition> conditions;
  private List<Repeat> repeats;
  private List<ConditionGroup> conditionGroups;
}
