package com.kaznowski.hugh.battlescribe.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.kaznowski.hugh.battlescribe.domain.helper.StringHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelectionEntryTest {
  @Test
  void canReadProperties() throws IOException {
    String xml =
        "<selection id=\"123\" name=\"Biovores\" hidden=\"true\" collective=\"true\" import=\"true\" type=\"unit\"/>";

    XmlMapper xmlMapper = new XmlMapper();
    SelectionEntry selectionEntry = xmlMapper.readValue( xml, SelectionEntry.class );

    assertEquals( "123", selectionEntry.getId() );
    assertEquals( "Biovores", selectionEntry.getName() );
    assertEquals( true, selectionEntry.getHidden() );
    assertEquals( true, selectionEntry.getCollective() );
    assertEquals( true, selectionEntry.get_import() );
    assertEquals( SelectionEntry.Type.unit, selectionEntry.getType() );
  }

  @Test
  void canReadModifiers() throws IOException {
    String xml = StringHelper.multiLine( "<selection>",
        "<modifiers>",
        "<modifier type=\"increment\"/>",
        "</modifiers>",
        "</selection>" );

    XmlMapper xmlMapper = new XmlMapper();
    SelectionEntry selectionEntry = xmlMapper.readValue( xml, SelectionEntry.class );
    assertEquals( 1, selectionEntry.getModifiers().size() );
  }
}
