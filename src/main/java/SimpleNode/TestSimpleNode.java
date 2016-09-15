package SimpleNode;

/**
 * Main TestSimpleNode
 */
public class TestSimpleNode {
    public static void main(String[] args) {


        User user1 = new User("22", "Vasa#1");
        User user2 = new User("23", "Peta#2");
        User user3 = new User("24", "Kola#3");

        SimpleNodeUtils snu = new SimpleNodeUtils();

        Node testnode = snu.createNodeR("A", "B", "C", "D", "E");
        System.out.println(snu.toStringN(testnode));
        System.out.println("=============================");
        System.out.println("Тест прробежка циклом: ");
        testnode = snu.createNodeR("A", "B", "C", "D", "E");
        snu.testCicleMove(testnode);
        System.out.println("=============================");

        testnode = snu.createNodeR("A", "B", "C", "D", "E");
        System.out.println(snu.toStringN(testnode));
        testnode = snu.remove(testnode, "B");
        System.out.println(snu.toStringN(testnode));

        System.out.println("=============================");
        System.out.println("Рекурсивное удаление: ");
        testnode = snu.createNodeR("A", "B", "C", "D", "E");
        System.out.println(snu.toStringN(testnode));
        testnode = snu.remove2(testnode, "C");
        System.out.println(snu.toStringN(testnode));

        System.out.println("=============================");
        testnode = snu.createNodeR("A", "B", "C", "D", "E");
        System.out.println(snu.toStringN(testnode));
        testnode = snu.remove3(testnode, "A");
        System.out.println(snu.toStringN(testnode));

        System.out.println("=============================");
        System.out.println("=============================");

        testnode = snu.createNodeR("A", "B", "C", "D", "E");
        System.out.println(snu.toStringN(testnode));

        testnode = snu.reverse(testnode);
        System.out.println(snu.toStringN(testnode));

        Node TestNode2 = snu.createNodeR("A", "A", "B", "B", "C", "C", "D", "D", "E", "E");
        testnode = snu.reverse(TestNode2);
        System.out.println(snu.toStringN(testnode));
    }
}