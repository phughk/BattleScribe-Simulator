package com.kaznowski.hugh.battlescribe.warhammer40k;

import com.kaznowski.hugh.battlescribe.DatasetFixtures;
import com.kaznowski.hugh.battlescribe.domain.FilterList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import static java.lang.String.format;

public class W40kCharacteristicTypeTest {
  @ParameterizedTest
  @MethodSource( "files" )
  void allCharacteristicsKnown( File file ) throws Exception {
    // Given a 40k xml file is parsed
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    Document document = documentBuilder.parse( file );

    // and all the profiles are found
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPathExpression xpathQuery = xPathFactory.newXPath().compile( "//characteristic" );
    NodeList nodeList = (NodeList) xpathQuery.evaluate( document, XPathConstants.NODESET );

    // then all profiles are matched with a type
    for ( int profileIt = 0; profileIt < nodeList.getLength(); profileIt++ ) {
      Node profile = nodeList.item( profileIt );
      String typeId = profile.getAttributes().getNamedItem( "typeId" ).getNodeValue();
      String name = profile.getAttributes().getNamedItem( "name" ).getNodeValue();
      String assertMessage = format( "Should be able to process typeId=%s, name=%s", typeId, name );
      try {
        W40kCharacteristicType.getById( typeId );
      }
      catch ( Exception e ) {
        Assertions.fail( assertMessage, e );
      }
    }
  }

  @Test
  void noDuplicateTypeIds() {
    FilterList<W40kCharacteristicType> values = new FilterList<>( W40kCharacteristicType.values() );
    for ( W40kCharacteristicType checked : values ) {
      Assertions.assertEquals( 1, values.getMany( t -> t.typeId.equals( checked.typeId ) ).size(), "More than one " +
          "type for " + checked.typeId );
    }
  }

  static File[] files() {
    return DatasetFixtures.allDatasets().toArray( new File[0] );
  }
}
