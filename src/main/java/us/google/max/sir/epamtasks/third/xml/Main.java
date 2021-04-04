package us.google.max.sir.epamtasks.third.xml;


import us.google.max.sir.epamtasks.third.xml.entity.Node;
import us.google.max.sir.epamtasks.third.xml.parser.XMLParser;
import us.google.max.sir.epamtasks.third.xml.parser.XMLParserException;

public class Main {
    public static void main(String[] args) throws XMLParserException {
        XMLParser xmlParser = new XMLParser();
        Node tree = xmlParser.parse("xml.xml");
        System.out.println(tree);
        XMLParser x=new XMLParser();
    }
}
