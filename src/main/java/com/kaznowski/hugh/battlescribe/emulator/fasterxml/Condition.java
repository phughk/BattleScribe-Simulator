package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

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
  private String type;
}
