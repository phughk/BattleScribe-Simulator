package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import lombok.Data;

import java.util.List;

@Data
public class Catalogue {
  private List<Publication> publications;
  private List<ProfileType> profileTypes;
}
