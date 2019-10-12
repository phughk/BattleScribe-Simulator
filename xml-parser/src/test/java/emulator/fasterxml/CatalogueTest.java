package emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import emulator.helper.StringHelper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatalogueTest {
  @Test
  void processListPublication() throws IOException {
    String xml = StringHelper.multiLine( "<catalogue>",
        " <publications>",
        "   <publication id=\"123\" name=\"First Book\"/>",
        "   <publication id=\"456\" name=\"Second Book\"/>",
        " </publications>",
        "</catalogue>" );

    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( xml, Catalogue.class );

    assertEquals( 2, catalogue.getPublications().size() );
    assertEquals( "123", catalogue.getPublications().get( 0 ).getId() );
    assertEquals( "Second Book", catalogue.getPublications().get( 1 ).getName() );
  }

  @Test
  void processProfileType() throws IOException {
    String xml = StringHelper.multiLine( "<catalogue>",
        " <profileTypes>",
        "  <profileType>",
        "  <characteristicTypes>",
        "    <characteristicType id=\"123\" name=\"First charcteristic\"/>",
        "    <characteristicType id=\"456\" name=\"Second characteristic\"/>", "  </characteristicTypes>",
        "  </profileType>",
        " </profileTypes>",
        "</catalogue>" );

    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( xml, Catalogue.class );

    List<CharacteristicType> characteristicTypes = catalogue.getProfileTypes().get( 0 ).getCharacteristicTypes();
    assertEquals( 2, characteristicTypes.size() );
    assertEquals( "123", characteristicTypes.get( 0 ).getId() );
    assertEquals( "Second characteristic", characteristicTypes.get( 1 ).getName() );
  }

  @Test
  void processCategoryEntries() throws IOException {
    String xml = StringHelper.multiLine( "<catalogue>",
        "<categoryEntries>",
        "<categoryEntry id=\"df7c-355d-38a6-261f\" name=\"Genestealer\" hidden=\"false\"/>",
        "</categoryEntries>",
        "</catalogue>" );

    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( xml, Catalogue.class );

    assertEquals( 1, catalogue.getCategoryEntries().size() );
  }

  @Test
  void processEntryLinks() throws IOException {
    String xml = StringHelper.multiLine( "<catalogue>",
        "<entryLinks>",
        "<entryLink id=\"123\"></entryLink>",
        "</entryLinks>",
        "</catalogue>" );

    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( xml, Catalogue.class );

    assertEquals( 1, catalogue.getEntryLinks().size() );
  }

  @Test
  void processSharedSelectionEntries() throws IOException {
    String xml = StringHelper.multiLine(
        "<catalogue>",
        "<sharedSelectionEntries>",
        "<selectionEntry id=\"123\"/>",
        "</sharedSelectionEntries>",
        "</catalogue>" );

    XmlMapper xmlMapper = new XmlMapper();
    Catalogue catalogue = xmlMapper.readValue( xml, Catalogue.class );

    assertEquals( 1, catalogue.getSharedSelectionEntries().size() );
  }
}
