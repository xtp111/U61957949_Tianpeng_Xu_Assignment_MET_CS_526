package HomeWork3.Problem3;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("=== Array Stack ===");
        ArrayStack arrayStack = new ArrayStack(10);
        for (int i = 1; i <= 10; i++) arrayStack.push(i);
        System.out.print("Before reverse: ");
        arrayStack.print();
        arrayStack.reverse();
        System.out.print("After reverse:  ");
        arrayStack.print();

        System.out.println("=== Linked List Stack ===");
        LinkedListStack linkedStack = new LinkedListStack
                ();
        for (int i = 1; i <= 10; i++) linkedStack.push(i);
        System.out.print("Before reverse: ");
        linkedStack.print();
        linkedStack.reverse();
        System.out.print("After reverse:  ");
        linkedStack.print();

        System.out.println("=== Doubly Linked List Stack ===");
        DLinkedListStack doublyStack = new DLinkedListStack();
        for (int i = 1; i <= 10; i++) doublyStack.push(i);
        System.out.print("Before reverse: ");
        doublyStack.print();
        doublyStack.reverse(doublyStack.dList);
        System.out.print("After reverse:  ");
        doublyStack.print();
    }
}
