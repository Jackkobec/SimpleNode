package SimpleNode;

/**
 * Created by serhii on 05.09.16.
 */
public class Node {
    public final transient String testText = "NODE";

    private Object value;
    private Node next;


    public Node() {
    }

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "testText='" + testText + '\'' +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
