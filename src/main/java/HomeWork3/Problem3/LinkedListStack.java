package HomeWork3.Problem3;

import java.util.ArrayList;
import java.util.List;

public class LinkedListStack {
    private LinkedListNode top;

    public void push(int value){
       LinkedListNode node = new LinkedListNode(value);
       node.next = top;
       top = node;
    }

    public int pop(){
        int value = top.value;
        top = top.next;
        return value;
    }

    public boolean isEmpty(){
        return(top == null);
    }


    //This recursive method reverses a stack by popping all elements and then inserting them back at the bottom one by one. The reverse() function removes the top element and calls itself until the stack is empty. Then, insertAtBottom() puts each element back at the bottom of the stack, using recursion again.
    //This approach doesn’t use extra stacks—it relies on recursion to handle both removal and reinsertion. Although it works well, the logic is less intuitive than using two stacks, because it involves two layers of recursion and delayed operations.
    public void reverse(){
        if(isEmpty() == true)
            return;;
        int value = pop();
        reverse();
        insertAtBottom(value);
    }

    private void insertAtBottom(int value) {
        if (isEmpty() == true) {
            push(value);
            return;
        }else {
            int temp = pop();
            insertAtBottom(value);
            push(temp);
        }
    }

    public void print() {
        LinkedListNode curr = top;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    }

