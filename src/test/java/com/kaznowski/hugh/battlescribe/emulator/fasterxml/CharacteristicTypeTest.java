package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacteristicTypeTest {
  @Test
  void loads() throws IOException {
    String xml = "<publication id=\"7150-5917-pubN65537\" name=\"Codex: Tyranids\"/>";

    XmlMapper xmlMapper = new XmlMapper();
    CharacteristicType characteristicType = xmlMapper.readValue( xml, CharacteristicType.class );

    assertEquals( "7150-5917-pubN65537", characteristicType.getId() );
    assertEquals( "Codex: Tyranids", characteristicType.getName() );
  }
}
