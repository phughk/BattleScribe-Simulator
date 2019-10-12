package com.kaznowski.hugh.battlescribe.fasterxml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryLinkTest {
  @Test
  void categoryLink() throws IOException {
    String xml =
        "<categoryLink id=\"123\" name=\"New CategoryLink\" hidden=\"true\" " + "targetId=\"95ff\" primary=\"true\"/>";

    XmlMapper xmlMapper = new XmlMapper();
    CategoryLink categoryLink = xmlMapper.readValue( xml, CategoryLink.class );

    assertEquals( "123", categoryLink.getId() );
    assertEquals( "New CategoryLink", categoryLink.getName() );
    assertEquals( true, categoryLink.getHidden() );
    assertEquals( "95ff", categoryLink.getTargetId() );
    assertEquals( true, categoryLink.getPrimary() );
  }
}
