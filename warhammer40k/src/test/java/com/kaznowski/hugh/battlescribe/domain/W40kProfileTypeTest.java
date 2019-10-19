package com.kaznowski.hugh.battlescribe.domain;

import com.kaznowski.hugh.battlescribe.App;
import com.kaznowski.hugh.battlescribe.warhammer40k.W40kProfileType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import static java.lang.String.format;

public class W40kProfileTypeTest {
  @ParameterizedTest
  @MethodSource( "files" )
  void canProcessAllProfileTypes( File file ) throws Exception {
    // Given a 40k xml file is parsed
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse( file );

    // and all the profiles are found
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPathExpression xpathQuery = xPathFactory.newXPath().compile( "//profile" );
    NodeList nodeList = (NodeList) xpathQuery.evaluate( document, XPathConstants.NODESET );

    // then all profiles are matched with a type
    for ( int profileIt = 0; profileIt < nodeList.getLength(); profileIt++ ) {
      Node profile = nodeList.item( profileIt );
      String typeId = profile.getAttributes().getNamedItem( "typeId" ).getNodeValue();
      String typeName = profile.getAttributes().getNamedItem( "typeName" ).getNodeValue();
      String name = profile.getAttributes().getNamedItem( "name" ).getNodeValue();
      String assertMessage = format( "Should be able to process typeId=%s, typeName=%s, name=%s",
          typeId, typeName, name );
      try {
        W40kProfileType.getById( typeId );
      }
      catch ( Exception e ) {
        Assertions.fail( assertMessage, e );
      }
    }
  }

  @Test
  void noDuplicateTypeIds() {
    // Given all the type ids
    List<String> typeIds = Arrays.stream( W40kProfileType.values() )
                                 .map( p -> p.typeId )
                                 .collect( Collectors.toList() );

    // then there are no duplicates
    for (String typeId:typeIds) {
      Assertions.assertEquals( 1, typeIds.stream().filter( typeId::equals ).count() );
    }
  }

  private static File[] files() {
    List<File> files = App.allDatasets();
    File[] fileArray = new File[files.size()];
    return files.toArray( fileArray );
  }
}
