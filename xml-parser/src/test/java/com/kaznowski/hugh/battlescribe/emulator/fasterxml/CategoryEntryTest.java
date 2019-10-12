package com.kaznowski.hugh.battlescribe.emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryEntryTest {
  @Test
  void parsesFields() throws IOException {
    String xml = "<categoryEntry id=\"123\" name=\"Test\" hidden=\"true\"/>";

    XmlMapper xmlMapper = new XmlMapper();
    CategoryEntry categoryEntry = xmlMapper.readValue( xml, CategoryEntry.class );

    assertEquals( "123", categoryEntry.getId() );
    assertEquals( "Test", categoryEntry.getName() );
    assertEquals( true, categoryEntry.getHidden() );
  }
}
