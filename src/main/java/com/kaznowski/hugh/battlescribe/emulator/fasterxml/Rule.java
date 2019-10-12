package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class Rule {
  private String id;
  private String name;
  private String publicationId;
  private String page;
  private Boolean hidden;
  private String description;
  private List<Modifier> modifiers;
}
