package com.kaznowski.hugh.battlescribe.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class ModifierGroup {
  private List<ModifierGroup> modifierGroups;
  private List<Modifier> modifiers;
  private List<Condition> conditions;
}
