package emulator.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PublicationTest {
  @Test
  void publicationIsLoaded() throws IOException {
    String publicationSerialised = "<publication id=\"7150-5917-pubN65537\" name=\"Codex: Tyranids\"/>";

    XmlMapper xmlMapper = new XmlMapper();

    Publication publication = xmlMapper.readValue( publicationSerialised, Publication.class );

    assertEquals( "7150-5917-pubN65537", publication.getId() );
    assertEquals( "Codex: Tyranids", publication.getName() );
  }
}
