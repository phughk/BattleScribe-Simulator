package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTypeTest {
  @Test
  void canLoadCharacteristics() throws IOException {
    String xml = "<profileType id=\"ecce-8736-aed9-0d2e\" name=\"Stat Damage - S &amp; A\">" + "<characteristicTypes>" +
        "  <characteristicType id=\"490c-1562-0502-ef6e\" name=\"Remaining W\"/>" +
        "  <characteristicType id=\"b619-f2d7-2354-c9da\" name=\"Strength\"/>" +
        "  <characteristicType id=\"b9cd-19c3-85b1-3963\" name=\"Attacks\"/>" + "</characteristicTypes>" +
        "</profileType>";

    XmlMapper xmlMapper = new XmlMapper();
    ProfileType profileType = xmlMapper.readValue( xml, ProfileType.class );

    assertEquals( 3, profileType.getCharacteristicTypes().size() );
    List<CharacteristicType> characteristicTypes = profileType.getCharacteristicTypes();
    assertEquals( "490c-1562-0502-ef6e", characteristicTypes.get( 0 ).getId() );
    assertEquals( "Strength", characteristicTypes.get( 1 ).getName() );
  }
}
