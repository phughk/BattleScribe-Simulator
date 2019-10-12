package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import lombok.Data;

@Data
public class CategoryLink {
  private String id;
  private String name;
  private Boolean hidden;
  private String targetId;
  private Boolean primary;
}
