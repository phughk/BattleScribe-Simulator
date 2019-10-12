package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class CategoryEntry {
  private String id;
  private String name;
  private Boolean hidden;
  private String publicationId;
  private String page;
  private List<Modifier> modifiers;
  private List<Constraint> constraints;
  private List<InfoLink> infoLinks;
}
