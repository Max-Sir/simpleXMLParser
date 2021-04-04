package us.google.max.sir.epamtasks.third.xml.factory;

import us.google.max.sir.epamtasks.third.xml.entity.Attribute;
import us.google.max.sir.epamtasks.third.xml.entity.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NodeFactory {
    private NodeFactory(){}
    private static NodeFactory nodeFactory;

    public static NodeFactory getInstance(){
        if(nodeFactory == null){
            nodeFactory = new NodeFactory();
        }
        return nodeFactory;
    }

    public String getTagName(String str){
        Pattern pattern = Pattern.compile("<([A-Za-z-]+\\b)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            return matcher.group(1).trim();
        }
        return null;
    }

    public List<Attribute> getAttributes(String str){
        List<Attribute> attributes = new ArrayList<>();
        Pattern pattern = Pattern.compile("(([a-z]+)=\"(\\S+)\")");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            String nameAttribute = matcher.group(2);
            String value = matcher.group(3);
            attributes.add(new Attribute(nameAttribute, value));
        }
        return attributes;
    }

    public String getContent(String line){
        Pattern pattern = Pattern.compile("(>|^)([A-Za-z-\\s$.0-9]+)(<|$)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            return matcher.group(2).trim();
        }
        return null;
    }

    public Node createNode(String line){
        Node node = new Node();
        node.setChildes(new ArrayList<>());

        String tagName = getTagName(line);
        node.setName(tagName);

        List<Attribute> attributes = getAttributes(line);
        node.setAttributes(attributes);

        String content = getContent(line);
        node.setContent(content);
        return node;
    }
}
