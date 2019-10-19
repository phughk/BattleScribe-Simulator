package com.kaznowski.hugh.battlescribe.domain.model;

import lombok.Data;

@Data
public class Unit {
  private String name;
  private String movement;
  private String weaponSkill;
  private String ballisticSkill;
  private String strength;
  private String toughness;
  private String wounds;
  private String attacks;
  private String leadership;
  private String saves;
}
