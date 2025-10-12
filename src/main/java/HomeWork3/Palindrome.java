package HomeWork3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while
        (i < j) {
            if
            (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        int palindromeCount = 0;

        try (Scanner scanner = new Scanner(new File("input.txt"))) { // assume input.txt
            while
            (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) continue; // 跳过空行

                boolean result = isPalindrome(line);
                System.out.println(result);

                if (result) {
                    palindromeCount++;
                }
            }
            System.out.println(palindromeCount);
        }
        catch
        ( FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }
}
