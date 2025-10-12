package HomeWork3.Problem3;

public class ArrayStack {
    private static int[] arr;
    private static int top;

    public ArrayStack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }


    public static void push(int val){
        top++;
        arr[top] = val;
    }

    public static int pop(){
        int outcome = arr[top];
        top--;
        return outcome;
    }

    public boolean isEmpty() {
        return top == -1;
    }


    private void insertAtBottom(int val) {
        if (isEmpty()) {
            push(val);
            return;
        }
        int temp = pop();
        insertAtBottom(val);
        push(temp);
    }

    public void reverse() {
        if (isEmpty()) return;
        int temp = pop();
        reverse();
        insertAtBottom(temp);
    }

    public void print()
    {
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
