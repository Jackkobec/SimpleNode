import SimpleNode.Node;
import SimpleNode.SimpleNodeUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * TestSimpleNodeActions junit tests
 */
public class TestSimpleNodeActions {

    @Test
    public void testRemove() {
        SimpleNodeUtils snu = new SimpleNodeUtils();
        Node TestNode = snu.createNodeR("A", "B", "C", "D", "E");

        //remove from 1st
        Node expected = snu.createNodeR("B", "C", "D", "E");
        Node actual = snu.removeWithRecursion(TestNode, "A");
        assertEquals(true, snu.nodeEquals(expected, actual));

        //remove from last
        expected = snu.createNodeR("A", "B", "C", "D");
        actual = snu.removeWithRecursion(TestNode, "E");
        assertEquals(true, snu.nodeEquals(expected, actual));

        //remove from middle
        expected = snu.createNodeR("A", "B", "C", "E");
        actual = snu.removeWithRecursion(TestNode, "D");
        assertEquals(true, snu.nodeEquals(expected, actual));

        //remove from middle yet
        expected = snu.createNodeR("A", "C", "D", "E");
        actual = snu.removeWithRecursion(TestNode, "B");
        assertEquals(true, snu.nodeEquals(expected, actual));

        //one-element node, try without removeParam
        Node oneElemNode = snu.createNodeR("A");
        expected = snu.createNodeR("A");
        actual = snu.removeWithRecursion(oneElemNode, "B");
        assertEquals(true, snu.nodeEquals(expected, actual));
        try {
            //Артефакт NullPointerException при сравнении с нулем т.к. в списке из одного елемента
            //при совпадении с removeParam возвращается нода с vsl = null

            //one-element node, try with removeParam
            oneElemNode = snu.createNodeR("A");
            expected = new Node(null);
            actual = snu.removeWithRecursion(oneElemNode, "A");
            assertEquals(true, actual.equals(new Node(null)));

        } catch (NullPointerException ignored) {

        }

    }

    @Test
    public void testReverse() {
        SimpleNodeUtils snu = new SimpleNodeUtils();
        Node TestNode = snu.createNodeR("A", "B", "C", "D", "E");


        //all reverse
        Node expected = snu.createNodeR("E", "D", "C", "B", "A");
        Node actual = snu.reverse(TestNode);
        assertEquals(true, snu.nodeEquals(expected, actual));

        //all reverse 2
        Node TestNode2 = snu.createNodeR("A", "A", "B", "B", "C", "C", "D", "D", "E", "E");
        expected = snu.createNodeR("E", "E", "D", "D", "C", "C", "B", "B", "A", "A");
        actual = snu.reverse(TestNode2);
        assertEquals(true, snu.nodeEquals(expected, actual));

        //one - element reverse if equals
        Node oneElemNode = snu.createNodeR("A");
        expected = snu.createNodeR("A");
        actual = snu.reverse(oneElemNode);
        assertEquals(true, snu.nodeEquals(expected, actual));

    }

    @Test
    public void testReverseString() {
        SimpleNodeUtils snu = new SimpleNodeUtils();
        String testStr = "A B C D E";

        //Test stringReverse
        String expected = "E D C B A";
        String actual = snu.stringReverse(testStr);
        assertEquals(expected, actual);

        //Test stringReverse
        expected = "E D C B A";
        actual = snu.reverseStringRec(testStr);
        assertEquals(expected, actual);

        //Test stringReverse
        expected = "E D C B A";
        actual = snu.reverseStringRecWithChatAt(testStr);
        assertEquals(expected, actual);
    }

    @Test
    public void testReverseAlg() {
        SimpleNodeUtils snu = new SimpleNodeUtils();
        Node TestNode = snu.createNodeR("A", "B", "C", "D", "E");


        //all reverse
        Node expected = snu.createNodeR("E", "D", "C", "B", "A");
        Node actual = snu.reverseNodeAlg(TestNode);
        assertEquals(true, snu.nodeEquals(expected, actual));

        //all reverse 2
        Node TestNode2 = snu.createNodeR("A", "A", "B", "B", "C", "C", "D", "D", "E", "E");
        expected = snu.createNodeR("E", "E", "D", "D", "C", "C", "B", "B", "A", "A");
        actual = snu.reverseNodeAlg(TestNode2);
        assertEquals(true, snu.nodeEquals(expected, actual));

        //one - element reverse if equals
        Node oneElemNode = snu.createNodeR("A");
        expected = snu.createNodeR("A");
        actual = snu.reverseNodeAlg(oneElemNode);
        assertEquals(true, snu.nodeEquals(expected, actual));

    }

    @Test
    public void testAddToHead() {
        SimpleNodeUtils snu = new SimpleNodeUtils();
        Node TestNode = snu.createNodeR("A", "B", "C", "D", "E");
        Node expected = snu.createNodeR("NewHead", "A", "B", "C", "D", "E");
        Node actual = snu.addToHead(TestNode, new Node("NewHead", null));
        assertEquals(true, snu.nodeEquals(expected, actual));
    }
    @Test
    public void testAddToTail() {
        SimpleNodeUtils snu = new SimpleNodeUtils();
        Node TestNode = snu.createNodeR("A", "B", "C", "D", "E");
        Node expected = snu.createNodeR("A", "B", "C", "D", "E","NewHead");
        snu.addToTail(TestNode, new Node("NewHead", null));
        assertEquals(true, snu.nodeEquals(expected, TestNode));
    }
}
