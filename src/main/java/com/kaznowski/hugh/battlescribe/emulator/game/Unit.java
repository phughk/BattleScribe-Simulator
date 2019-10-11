package com.kaznowski.hugh.battlescribe.emulator.game;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Unit {
  private final String name;

  public Unit( String name ) {
    this.name = name;
  }
}
