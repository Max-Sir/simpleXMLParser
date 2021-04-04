package us.google.max.sir.epamtasks.third.xml.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Node implements Serializable {
    private String name;
    private List<Attribute> attributes;
    private List<Node> childes;
    private String content;

    public Node() {
    }

    public Node(String name, List<Attribute> attributes, List<Node> childes, String content) {
        this.name = name;
        this.attributes = attributes;
        this.childes = childes;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Node> getChildes() {
        return childes;
    }

    public void setChildes(List<Node> childes) {
        this.childes = childes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(attributes, node.attributes) &&
                Objects.equals(childes, node.childes) &&
                Objects.equals(content, node.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, attributes, childes, content);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", attributes=" + attributes +
                ", childes=" + childes +
                ", content='" + content + '\'' +
                '}';
    }
}
