package HomeWork3.Problem3;

public class DLinkedListStack {
    DLinkedListNode top;
    DLinkedListStack dList;


    public void push(int value){
        DLinkedListNode node = new DLinkedListNode(value);
        node.prev = top;
        top = node;

    }

    public int pop(){
        int value = top.value;
        top = top.prev;
        return value;
    }

    boolean isEmpty() {
        return top == null;
    }

    public void reverse(DLinkedListStack dList) {
        if (dList.isEmpty()) {
            return;
        }

        int value = dList.pop();
        reverse(dList);
        insertAtBottom(dList,value);
    }

    public void insertAtBottom(DLinkedListStack dlist, int
            value) {
        if (dlist.isEmpty()) {
            dlist.push(value);
            return;
        }

        int topValue = dlist.pop();
        insertAtBottom(dlist, value);
        dlist.push(topValue);
    }

    public void print() {
        DLinkedListNode curr = top;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
