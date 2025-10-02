package Assignment;

import java.util.LinkedList;

public class QuestionFour {

    public static int findSum(LinkedList<Integer> linkedList){

        if (linkedList.size() < 3) {
            throw new IllegalArgumentException("List must contain at least 3 elements.");
        }

        int mid= (linkedList.size() - 1)/2;
        return linkedList.get(mid - 1) + linkedList.get(mid) + linkedList.get(mid+1);
    }

}

