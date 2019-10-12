package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class InfoLink {
  private String id;
  private String name;
  private Boolean hidden;
  private String targetId;
  private String type;
  private List<Modifier> modifiers;
  private String page;
}
