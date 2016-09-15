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


}
