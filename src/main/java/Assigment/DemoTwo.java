package AssignmentOne;

import java.util.LinkedList;

public class DemoTwo {
    public static void doIt(Node node) {
        if (node == null) return;
        doIt(node.next);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);

        doIt(head);

        //Dolt function will recurse the list start from the first node until node == null when reach the end of the list

        System.out.println("doItTwo(1) = " + QuestionThree.doltTwo(1));
        System.out.println("doItTwo(3) = " + QuestionThree.doltTwo(3));
        System.out.println("doItTwo(6) = " + QuestionThree.doltTwo(6));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(10);
        linkedList.add(15);
        linkedList.add(29);
        linkedList.add(41);

        System.out.println("Sum of three middle nodes: " + QuestionFour.findSum(linkedList));

    }



}

