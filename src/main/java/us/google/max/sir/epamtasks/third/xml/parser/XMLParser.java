package us.google.max.sir.epamtasks.third.xml.parser;

import us.google.max.sir.epamtasks.third.xml.entity.Node;
import us.google.max.sir.epamtasks.third.xml.factory.NodeFactory;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//This parser is useful to parse xml files but such types of xml such as XSD are cannot be parsed


public class XMLParser{

    private final NodeFactory nodeCreator = NodeFactory.getInstance();

    public Node parse(String fileName) throws XMLParserException {
        Node rootNode = null;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));) {
            rootNode = createRootNode(bufferedReader);
        } catch (IOException e) {
            throw new XMLParserException("XMLParser exception!");
        }
        return rootNode;
    }


    private Node createRootNode(BufferedReader bufferedReader) throws IOException {
        Deque<Node> stack = new LinkedList();
        Node rootNode = null;
        Pattern openTagPattern = Pattern.compile("<[A-Za-z-]+\\b.*>");
        Pattern closeTagPattern = Pattern.compile("</[A-Za-z-]+>");
        String line = bufferedReader.readLine();
        while (line != null) {
            line = line.trim();

            Matcher openTagMatcher = openTagPattern.matcher(line);
            Matcher closeTagMatcher = closeTagPattern.matcher(line);

            boolean hasOpenTag = false;
            boolean hasCloseTag = false;

            if(openTagMatcher.find()){
                hasOpenTag = true;
                Node node = nodeCreator.createNode(line);
                stack.addFirst(node);
            }

            if(closeTagMatcher.find()){
                hasCloseTag = true;
                Node child = stack.pollFirst();

                if(!hasOpenTag){
                    String content = nodeCreator.getContent(line);
                    if(content!=null){
                        String fullChildContent = child.getContent()+" "+content;
                        child.setContent(fullChildContent);
                    }
                }

                if(stack.size()!=0){
                    Node parent = stack.peekFirst();
                    List<Node> childList = parent.getChildes();
                    childList.add(child);
                }
                rootNode = child;
            }

            if(!hasOpenTag && !hasCloseTag){
                if(stack.size()!=0 && line.length()!=0) {
                    Node child = stack.peekFirst();
                    String fullContent = child.getContent() + " " + line;
                    child.setContent(fullContent);
                }
            }
            line = bufferedReader.readLine();
        }
        return rootNode;
    }
}
