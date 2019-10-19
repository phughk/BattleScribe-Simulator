package com.kaznowski.hugh.battlescribe;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

public class XPathApp {
  public static void main( String[] args ) throws Exception {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    File file = new File( "../wh40k/Imperium - Grey Knights.cat" );
//    File file = new File( "../wh40k/Tyranids.cat" );
    Document document = documentBuilderFactory.newDocumentBuilder().parse( file );
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPathExpression xpathQuery = xPathFactory.newXPath().compile( "//profile" );
    NodeList result = (NodeList) xpathQuery.evaluate( document, XPathConstants.NODESET );
    System.out.println( "result.getLength() = " + result.getLength() );
    Set<String> types = new HashSet<>();
    for ( int i = 0; i < result.getLength(); i++ ) {
      Node node = result.item( i );
      String path = getXPath( node );
      String typeId = node.getAttributes().getNamedItem( "typeId" ).getNodeValue();
      types.add( typeId );
    }
    System.out.println( "types = " + types );
  }

  private static String getXPath( Node node ) {
    Node parent = node.getParentNode();
    if ( parent == null ) {
      return node.getNodeName();
    }
    return getXPath( parent ) + "/" + node.getNodeName();
  }
}
