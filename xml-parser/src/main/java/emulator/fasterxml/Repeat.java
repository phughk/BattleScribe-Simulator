package emulator.fasterxml;

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
}
