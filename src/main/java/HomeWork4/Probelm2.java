package HomeWork4;

import java.util.Arrays;
import java.util.Scanner;

public class Probelm2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements (n): ");
        int n = sc.nextInt();

        System.out.print("Enter target (T): ");
        int target = sc.nextInt();

        System.out.print("Enter " + n + " array elements: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        reverse(arr);

        int sum = 0;
        int count = 0;

        for (int value : arr) {
            sum += value;
            count++;
            if (sum > target) break;
        }

        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Target: " + target);
        System.out.println("Answer: " + count);
    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1
             ; i < j; i++, j--) {
            int temp =
                    arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
