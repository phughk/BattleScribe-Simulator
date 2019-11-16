package com.kaznowski.hugh.battlescribe.domain.model;

import lombok.Data;

import java.util.Collection;

@Data
public class Unit {
  private String name;
  private Collection<Model> models;
}
