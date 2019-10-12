package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.Data;

@Data
public class Characteristic {
  private String name;
  private String typeId;
  @JacksonXmlText
  private String value;
}
