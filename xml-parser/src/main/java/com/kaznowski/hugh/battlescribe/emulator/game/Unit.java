package com.kaznowski.hugh.battlescribe.emulator.game;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Unit {
  private final String name;
  private final String weaponSkill;

  public Unit( String name, String weaponSkill ) {
    this.name = name;
    this.weaponSkill = weaponSkill;
  }

  public String getWeaponSkill() {
    return weaponSkill;
  }

}
