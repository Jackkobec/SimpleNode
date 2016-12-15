package SimpleNode;

/**
 * Created by Jack on 15.12.2016.
 */
public interface ISimpleNodeUtils {
    String toStringN(Node head);

    String toStringN2(Node head);

    Node addToHead(Node head, Node newHead);

    void addToTail(Node head, Node newTail);

    Node createNodeR(Object... mas);

    Node testCicleMove(Node head);

    @Deprecated
    @SuppressWarnings("Method compare two chain of Nodes")
    boolean nodeEquals(Node node1, Node node2);

    /**
     * !Метод remove ВОЗВРАЩАЕТ ЦЕПОЧКУ без удаленного элемента!
     * Правильным подходом было бы вообще делать метод boolean и возвращать true / false по результатам удаления
     *
     * @param head
     * @param removeParam
     * @return
     */
    @Deprecated
    Node remove(Node head, Object removeParam);

    @Deprecated
    Node remove2(Node head, Object removeParam);

    /**
     * Recursive remove method
     * !Метод remove ВОЗВРАЩАЕТ ЦЕПОЧКУ без удаленного элемента!
     * Правильным подходом было бы вообще делать метод boolean и возвращать true / false по результатам удаления
     *
     * @param head
     * @param removeParam
     * @return
     */
    Node removeWithRecursion(Node head, Object removeParam);

    Node reverse(Node head);

    /**
     * stringReverse with classes StringBuffer,
     * StringBuilder usage possible too
     *
     * @param str
     * @return
     */
    String stringReverse(String str);

    /**
     * reverseStringRec with recursion
     * <p>
     * Last elem from input string add recursive call this method
     *
     * @param str
     * @return
     */
    String reverseStringRec(String str);

    /**
     * reverseStringRecWithChatAt
     *
     * @param str
     * @return
     */
    String reverseStringRecWithChatAt(String str);

    Node reverseNode(Node head);

    /**
     * public Node reverseNodeAlg(Node head)
     * Алгоритм реверса односвязного списка от Ани.
     * <p>
     * Я не буду расказывать, что делать если на вход придет список из 1 Ноды или она будет равна null. Смотрите проверки.
     * <p>
     * <p>
     * 1.Создаем две дополнительные Ноды:
     * - nextCicleElement = null - дополнительная Нода, для хранения следующего элемента в цикла, изначально null
     * - newHead = null - дополнительная Нода, куда будет форсмироваться новая реверсивная цепочка и мы ёё будем возвращать
     * 2.Проход циклом по списку начинаем с первого элемента = head. И будем идти пока он не станет равным null, что будет означать конец.
     * while(head != null)
     * 3.После входа в цикл с первую очередь необходимо запомнить следующий елемент цикла nextCicleElement
     * т.к. он нам пригодится для итерации цикла. Значение этой переменной - это head.getNext()
     * nextCicleElement = head.getNext();
     * 4.Далее логика такова, что мы должны взять наш текущий элемент цикла - тоесть head и сделать чтобы он ссылался на null,
     * тоесть его next = null. Но после такого действия мы потеряем всю цепочку т.к A смотрит на null (A -> null).
     * Вот для этого нам и понадобится вторая дополнительная переменная newHead, которой мы присвоим значение head = A,
     * (у которой при первой итераии значение равно null),
     * у коготорого next null ( newHead = head  = (A -> null), смотри пункт 5
     * 5.Формируем новую цепочку с newHead во главе. Записываем в newHead значение head из 4 пункта
     * newHead = head  ( == A -> null)
     * Теперь у нас в newHead новый список, в котором ( newHead = A -> null); Cюда и будет формироваться реверсивный список.
     * 6. Оталось сделать итерацию цикла для перехода к следующему элементу. Текущий у нас head, но мы его обнуилили в пункте 4
     * Поэтому берем head и делаем его равным nextCicleElement(помните мы его запомнили в 3 пункте сразу после начала цикла)
     * head = nextCicleElement ( == head.getNext() , но head из начала цикла)
     * <p>
     * После чего за циклом возвращаем newHead, в котором сформируется реверсивная цепочка.
     * <p>
     * <p>
     * <p>
     * <p>
     * Список для примера A -> B -> C -> D ,  тут исходными данными при первой итерации цикла будут:
     * -head = A
     * -head.getNext() = B
     * -nextCicleElement = head.getNext() = B
     * -newHead = A (A -> null)
     *
     * @param head
     * @return
     */
    Node reverseNodeAlg(Node head);

    Node reverseNodeWithRecursion(Node head);

    Node reverseWithRecursionAlt(Node curr, Node next, Node prev);
}
