package com.kaznowski.hugh.battlescribe.emulator.loader;

import com.kaznowski.hugh.battlescribe.emulator.game.Unit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
    for ( int i = 0; i < nodeList.getLength(); i++ ) {
      Element element = (Element) nodeList.item( i );
      dataset.addUnit( new Unit( element.getAttribute( "name" ) ) );
    }
    return dataset;
  }
}
