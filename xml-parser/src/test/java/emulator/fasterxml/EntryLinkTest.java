package emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntryLinkTest {
  @Test
  void canReadProperties() throws IOException {
    String xml = "<entryLink id=\"123-456\" name=\"Gargoyles\" hidden=\"true\" collective=\"true\" " +
        "import=\"true\" targetId=\"135-246\" type=\"selectionEntry\"/>";

    XmlMapper xmlMapper = new XmlMapper();
    EntryLink entryLink = xmlMapper.readValue( xml, EntryLink.class );

    assertEquals( "123-456", entryLink.getId() );
    assertEquals( "Gargoyles", entryLink.getName() );
    assertEquals( true, entryLink.getHidden() );
    assertEquals( true, entryLink.getCollective() );
    assertEquals( true, entryLink.get_import() );
    assertEquals( "135-246", entryLink.getTargetId() );
    assertEquals( "selectionEntry", entryLink.getType() );
  }

  @Test
  void canReadCategoryLinks() throws IOException {
    String xml = "<entryLink>" + "<categoryLinks>" +
        "<categoryLink id=\"5e82-5890-d2e2-602c\" name=\"New CategoryLink\" hidden=\"false\" targetId=\"e888-1504-aa61-95ff\" primary=\"true\"/>" +
        "</categoryLinks>" + "</entryLink>";

    XmlMapper xmlMapper = new XmlMapper(  );
    EntryLink entryLink = xmlMapper.readValue( xml, EntryLink.class );

    assertEquals( 1, entryLink.getCategoryLinks().size() );
  }
}
