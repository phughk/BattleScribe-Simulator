package emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class ConditionGroup {
  private String type;
  private List<Condition> conditions;
  private List<ConditionGroup> conditionGroups;
}
