package HomeWork3;

import java.util.HashSet;
import java.util.Set;

public class SubString {

        // Set can be store unique substring because every string content is unique in set
        static Set<String> substrings = new HashSet<>();

        public static void generateSubstrings(String str, int start, int end) {
            //In this situation, only one character exists so directly return the string.
            if (start == str.length()) return;

            // Using recursive method to get substring from start to end
            if (end > str.length()) {
                generateSubstrings(str, start + 1, start + 1); //This operation will make sure start and end will always find the smallest substring, so we put start + 1 to the position of end.
                return;
            }

            // Put original string in set, so I find the longest string(itself) and every single character, they might be left by the fast and slow pointer which I was used below.
            String sub = str.substring(start, end);
            substrings.add(sub);

            generateSubstrings(str, start, end + 1);
        }

        public static void main(String[] args) {
            String input = "abcab";
            generateSubstrings(input, 0, 1);

            int count = substrings.size();
            System.out.println(String.join(", ", substrings) + " -> " + count);
        }
    }



