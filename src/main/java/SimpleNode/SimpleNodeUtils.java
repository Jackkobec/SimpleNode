package SimpleNode;

/**
 * SimpleNode Actions
 */
public class SimpleNodeUtils {
    public String toStringN(Node head) {
        System.out.print("Head is = ");
        StringBuilder sb = new StringBuilder();
        Node lastPointer = head;

        while (lastPointer != null) {
            sb.append(lastPointer.getValue() + "->");
            lastPointer = lastPointer.getNext();
        }
        sb.append(" null = Tail");
        return sb.toString();
    }

    public String toStringN2(Node head) {

        StringBuilder sb = new StringBuilder();
        Node lastPointer = head;

        while (lastPointer != null) {
            sb.append(lastPointer.getValue() + "->");
            lastPointer = lastPointer.getNext();
        }
        sb.append(" null");
        return sb.toString();
    }

    public Node createNodeR(Object... mas) {

        if (mas.length == 0) return null;
        // if mas consist of more then 1 Object we create new Array for the next operations
        Object[] masReduced = new Object[mas.length - 1];
        // copy source Array from position 1 to the created Array on first position and created Array length
        System.arraycopy(mas, 1, masReduced, 0, masReduced.length);
        // call recursion with reduced Array
        return new Node(mas[0], createNodeR(masReduced));
    }

    public Node testCicleMove(Node head) {
       /*   //человеческий последовательный перебор всех узлов циклом for
        for (Node start = head; start != null; start = start.getNext()) {
            System.out.println(toStringN(start));
        }
        */

        //человеческий последовательный перебор всех узлов циклом while
        //Делаем вспомогательную ноду start и делаем её равной head
        Node start = head;
        while (start != null) {
            System.out.println(toStringN(start));
            start = start.getNext();
        }
        return null;
    }

    @Deprecated
    @SuppressWarnings("Method compare two chain of Nodes")
    public boolean nodeEquals(Node node1, Node node2) {
        try {
            if (node1.getValue().equals(null) && node2.getValue().equals(null)) {
                return node1.getValue().equals(null) && node2.getValue().equals(null) ? true : false;
            }
            if (null == node1.getNext() || null == node2.getNext()) {
                return (node1.getValue().equals(node2.getValue())) ? true : false;
            }

            for (Node start1 = node1, start2 = node2; start1 != null
                    && start2 != null; start1 = start1.getNext(), start2 = start2.getNext()) {
                if (start1.getValue().equals(start2.getValue())
                        && start1.getNext().getValue().equals(start2.getNext().getValue())) {
                    return true;
                } else return false;

            }
        } catch (NullPointerException ignored) {

        }
        return false;

    }

    /**
     * !Метод remove ВОЗВРАЩАЕТ ЦЕПОЧКУ без удаленного элемента!
     * Правильным подходом было бы вообще делать метод boolean и возвращать true / false по результатам удаления
     *
     * @param head
     * @param removeParam
     * @return
     */
    @Deprecated
    public Node remove(Node head, Object removeParam) {
        //если список из одного елемента
        if (null == head.getNext()) {
            //проверим этот елемент на соовестие к removeParam, веренем null
            return head.getValue().equals(removeParam) ? null : head;

        } else if (head.getValue().equals(removeParam)) {
            return head.getNext();
        }

        Node finded = null;
        while (head.getNext() != null) {
            if (head.getNext().getValue().equals(removeParam)) {
                finded = head.getNext();
                head.setNext(head.getNext().getNext());
                return finded;
            } else {
                head = head.getNext();
            }
        }
        return finded;
    }

    @Deprecated
    public Node remove2(Node head, Object removeParam) {
        //если список из одного елемента
        if (null == head.getNext()) {
            //проверим этот елемент на соовестие к removeParam, веренем null
            return head.getValue().equals(removeParam) ? null : head;

        } else if (head.getValue().equals(removeParam)) {
            return head.getNext();
        }
        for (Node start = head.getNext(); start != null; start = start.getNext()) {
            System.out.print("По ком идет цикл: ");
            System.out.println(toStringN(start));

            if (start.getValue().equals(removeParam)) {
                return new Node(start.getValue(), start.getNext());

            }

        }

        return null;
    }

    /**
     * Recursive remove method
     * !Метод remove ВОЗВРАЩАЕТ ЦЕПОЧКУ без удаленного элемента!
     * Правильным подходом было бы вообще делать метод boolean и возвращать true / false по результатам удаления
     *
     * @param head
     * @param removeParam
     * @return
     */
    public Node remove3(Node head, Object removeParam) {
        //if one - element node
        if (null == head.getNext()) {
            //проверим этот елемент на соовестие к removeParam, веренем null, если да
            return head.getValue().equals(removeParam) ? null : head;
        }
        //standard situation - more then one element
        if (head.getValue().equals(removeParam)) {
            return head.getNext();
        }
        //If in the first iteration we d'ont find the equals with removeParam - we build new Node where val = head.getValue()
        //end repeat this action recursive  until chain not finished
        return new Node(head.getValue(), remove3(head.getNext(), removeParam));
    }

    public Node reverse(Node head) {
        if (null == head) {
            return null;
        }
        if (null == head.getNext()) {
            return head;
        }
        Node start = head;
        Node forward = null;
        //Start chain A > B > C > D > E > null
        //head = A(next = B), start.getNext() = B(next = C) , forward = null
        while (head.getNext() != null) {
            /**
             *forward = head.getNext();
             head.setNext(forward.getNext());
             forward.setNext(start);
             start = forward;
             */
            System.out.print("Идем по циклу while: ");
            System.out.println(toStringN(head.getNext()));
            //Запомним в forward елемент начала цикла start.getNext() = B
            //head = A(next = B), start = A(next = B) , start.getNext() = B(next = C) , forward = B(next = C)
            forward = head.getNext();
            System.out.print("1. forward = head.getNext(): ");
            System.out.println(toStringN(forward));
            //Ставим next у head = forward.getNext() = С
            //head = A(next = C) , start = A(next = C), start.getNext() = B(next = C) , forward = B(next = C)
            head.setNext(forward.getNext());
            System.out.print("2. head.setNext(forward.getNext(): ");
            System.out.println(toStringN(head.getNext()));
            //Ставим next у forward = start = A
            //head = A(next = C) , start = A(next = C), start.getNext() = B(next = C) , forward = B(next start = A)
            forward.setNext(start);
            System.out.print("3. forward.setNext(start): ");
            System.out.println(toStringN(forward.getNext()));
            //Присваемаем start значение forward
            //head = A(next = C) , start = forward = B(next = A) , start.getNext() = B(next = C), forward = B(next = A)
            start = forward;
            System.out.print("4. start = forward: ");
            System.out.println(toStringN(start));
        }
        return start;
    }

    /**
     * stringReverse with classes StringBuffer,
     * StringBuilder usage possible too
     *
     * @param str
     * @return
     */
    public String stringReverse(String str) {
        if (str.isEmpty()) {
            return null;
        }
        //StringBuffer \ StringBuilder method reverse()
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * reverseStringRec with recursion
     * <p>
     * Last elem from input string add recursive call this method
     *
     * @param str
     * @return
     */
    public String reverseStringRec(String str) {
        //cant return null - its fail the result stuing
        if (str.isEmpty()) {
            return "";
        }
        //Last element from the input string str
        return str.substring(str.length() - 1)
                //append results from recursive call this method
                + reverseStringRec(str.substring(0, str.length() - 1));
    }

    /**
     * reverseStringRecWithChatAt
     *
     * @param str
     * @return
     */
    public String reverseStringRecWithChatAt(String str) {
        if (str.isEmpty()) {
            return "";
        }
        //Lasr elem from input string str
        return str.charAt(str.length() - 1)
                //append results from recursive call this method
                + reverseStringRecWithChatAt(str.substring(0, str.length() - 1));
    }


    public Node reverseNode(Node head) {
        if (head.getNext() == null && null == head.getValue()) {
            throw new NullPointerException("Bad Node");
        }
        if (head.getNext() == null && head.getValue() != null) {
            return head;
        }
        Node next = null;
        Node newHead = null;

        while (head != null) {
            next = head.getNext();
            System.out.println();
            System.out.println("next:    " + toStringN2(next));
            head.setNext(newHead);
            System.out.println("head:    " + toStringN2(head));
            newHead = head;
            System.out.println("newHead: " + toStringN2(newHead));
            head = next;

        }
        return newHead;
    }


/*    public Node reverseNode2(Node head) {
        if (head.getNext() == null && null == head.getValue()) {
            throw new IncorrectNodeExeption("Bad Node");
        }
        if (head.getNext() == null && head.getValue() != null) {
            return head;
        }
        Node next = null;
        Node newHead = null;

        while (head != null) {//move form A
            next = head.getNext(); // запомним в переменную next следущий heda т.к он затрется

            head.setNext(newHead); // поставим у head следующего равного null (это наш newHead, объявленный до цикла)

            newHead = head; //новая цепочка с newHead, которая возьмет значение head = A и его сысылка на следющий будет null т.к. в
            //в предыдущем шаге мы переставили у head ссылку на null
            //Чтобы не потерять исходную цепочку мы переприсваеваем head c ссылкой на след null -> в newHead и его будем возпращать
            //A head в следующем действии возьмет ранее запомненное зхначение next и кикл продолжится

            head = next;// это итерация цикла
        }
        return newHead;
    }*/

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
    public Node reverseNodeAlg(Node head) {
        if (null == head) {
            return null;
        }
        if (null == head.getValue() && null == head.getNext()) {
            throw new NullPointerException("Bad Node");
        }
        if (null == head.getNext() && null != head.getValue()) {
            return head;
        }
        Node nextCicleElement = null; //дополнительная переменная для хранения следующего елемента цикла пункт 1
        Node newHead = null;          //дополнительная переменная для хранения новой реверсивной цепочки пункт 1

        while (null != head) {
            nextCicleElement = head.getNext(); //запомнили следующее значение для последующее итерации пункт 3
            head.setNext(newHead);             //ставим чтобы head ссылался на null(т.к при первойитерации newHead = null) пункт 4
            newHead = head;           //присваиввем newHead значение head == A -> null при первой итерации, полученое из предыдущего дейстия

            head = nextCicleElement;           //итерация цикла, присваеваем head(а это текущий елемент цикла) nextCicleElement,
            //который мы запомнили в начале цикла пункт 6

        }
        return newHead; //возвращаем новую цепочку
    }


    public Node reverseNodeRec(Node head) {
        if (null == head) {
            return null;
        }

        return null;
    }
}








/**
 * Test area
 */
   /* public static class OneNodeList {
        OneNodeList next;
        Object val;
        public  OneNodeList(){

        }
        public  OneNodeList(Object val){
            this.val = val;
        }
        public  OneNodeList(Object val, OneNodeList next){
            this.val = val;
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }
        public OneNodeList createN(Object... mas) {

            if (mas.length == 0) return null;
            // if mas consist of more then 1 Object we create new Array for the next operations
            Object[] masReduced = new Object[mas.length - 1];
            // copy source Array from position 1 to the created Array on first position and created Array length
            System.arraycopy(mas, 1, masReduced, 0, masReduced.length);
            // call recursion with reduced Array
            return new OneNodeList(mas[0], createN(masReduced));
        }
        public String toStringOneNode(OneNodeList head) {

            StringBuilder sb = new StringBuilder();
            OneNodeList lastPointer = head;

            while (lastPointer != null) {
                sb.append(lastPointer.val + "->");
                lastPointer = lastPointer.next;
            }
            sb.append(" null");
            return sb.toString();
        }

        public void invertAll(OneNodeList previous) {
            if (this.hasNext()) {
                this.next.invertAll(this);
            }
            this.next = previous;
        }


    }*/
