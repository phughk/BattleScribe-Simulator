package emulator.loader;

import emulator.game.Unit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.function.Predicate;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static java.lang.String.format;

public class BattleScribeLoader {

  private final DocumentBuilder documentBuilder;

  BattleScribeLoader() {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    try {
      this.documentBuilder = documentBuilderFactory.newDocumentBuilder();
    }
    catch ( ParserConfigurationException e ) {
      throw new RuntimeException( e );
    }
  }

  public Dataset load( File datasetSource ) {
    Document document;
    try {
      document = documentBuilder.parse( datasetSource );
    }
    catch ( SAXException | IOException e ) {
      throw new RuntimeException( e );
    }
    Dataset dataset = new Dataset();
    NodeList nodeList = document.getElementsByTagName( "entryLink" );
    for ( Element element : asElerator( nodeList ) ) {
      dataset.addUnit( readUnit( document, element ) );
    }
    return dataset;
  }

  private Unit readUnit( Document document, Element unitElement ) {
    String name = unitElement.getAttribute( "name" );
    String targetId = unitElement.getAttribute( "targetId" );
    NodeList selectionEntries = document.getElementsByTagName( "selectionEntry" );
    Element element = null;
    for ( Element contender : asElerator( selectionEntries ) ) {
      if ( targetId.equals( contender.getAttribute( "id" ) ) ) {
        element = contender;
        break;
      }
    }
    if ( element == null ) {
      throw new RuntimeException( "Not able to find targetId " + targetId );
    }
    // find profileId==unit
    NodeList profiles = element.getElementsByTagName( "profile" );
    Element profileElement = null;
    for ( Element profile : asElerator( profiles ) ) {
      if ( profile.getAttribute( "profileId" ).equals( "Unit" ) ) {
        String weaponSkill = findElementWithPropertyMatching( profileElement, "characteristic",
            el -> el.getAttribute( "name" ).equals( "M" ) ).getTextContent();
        return new Unit( name, weaponSkill );
      }
    }
    throw new RuntimeException( format( "Failed to read unit %s with targetId=%s", name, targetId ) );
  }

  private Element findElementWithPropertyMatching( Element parent, String childTag, Predicate<Element> propertyCheck ) {
    for ( Element child : asElerator( parent.getElementsByTagName( childTag ) ) ) {
      if ( propertyCheck.test( child ) ) {
        return child;
      }
    }
    throw new RuntimeException( "Unable to find child matching property" );
  }

  private static Iterable<Element> asElerator( NodeList nodeList ) {
    return () -> new Iterator<Element>() {
      private int index = 0;

      @Override
      public boolean hasNext() {
        return index < nodeList.getLength();
      }

      @Override
      public Element next() {
        return (Element) nodeList.item( index++ );
      }
    };
  }
}
