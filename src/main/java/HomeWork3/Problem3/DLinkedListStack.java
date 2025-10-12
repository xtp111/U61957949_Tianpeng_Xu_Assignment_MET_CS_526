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

    public void reverse(DLinkedListStack dlist) {
        if (dList.isEmpty()) {
            return;
        }

        int value = dlist.pop();
        insertAtBottom(dList,value);
        reverse(dlist);

    }

    public void insertAtBottom(DLinkedListStack dList, int value){
        if (dList.isEmpty()){
            dList.push(value);
    }
        int top = dList.pop();
        insertAtBottom(dList,top);
        dList.push(top);

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
