package emulator.fasterxml;

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
  private String type;
}
