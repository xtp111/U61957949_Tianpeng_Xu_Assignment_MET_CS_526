package Assigment;

public class QuestionThree {
    public static int doltTwo(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return doltTwo(n - 1) + doltTwo(n - 2) - doltTwo(n - 3);
        }
    }
}
