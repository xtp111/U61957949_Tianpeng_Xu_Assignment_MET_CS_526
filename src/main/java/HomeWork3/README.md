# Homework 3

- Problem 1 answer is in Palindrome class.
- Problem 2 answer is in SubString class.
- Problem 3 answer is in Problem 3 package.
- Problem 4 answer is in Problem 4 package;

# Problem 1

- This program reads a text file named input.txt, where each line contains a string.
  It checks whether each string is a palindrome — a word or phrase that reads the same backward as forward.
  For each line, the program prints true or false, indicating whether it is a palindrome.
  Finally, it outputs the total number of palindromes found in the file.
- The program opens input.txt using a Scanner.
- It reads each line and removes leading/trailing spaces.
- For each non-empty line:
   • It calls isPalindrome() to check if the string is a palindrome.
   • It prints true if the string is a palindrome, otherwise false.
- After processing all lines, it prints the count of all palindromes detected.

# Example input

- madam
  hello
  racecar
  abcba
  java

# Example Output

- true
  false
  true
  true
  false
  3

# See unit test in PalindromeTest 

# Problem 2
- The logic for this algorithm is below:
1. set two pointers (start and end) to represent the substring boundaries.
2. Recursively generate substrings from start to end until end > str.length().
3. When end exceeds the string length, increment start and reset end to start + 1.
4. Each substring is added to a Set to ensure uniqueness.
5. Stop recursion when start == str.length().

- This method ensures all single-character substrings, all partial substrings, and the full string itself are captured.

# Example OutPut

- There is a demo outcome in SubString class

# Problem 3

- Algorithm Heart:
- Use recursion to reverse the stack:
- Array Stack: swap elements from both ends until the middle.
- Linked List Stack: recursively pop the top element, reverse the rest, then push the popped element at the bottom.
- Doubly Linked List Stack: recursively swap next and prev pointers until the list is reversed.

# Example Output
- The Test class automatically demonstrates all three stack implementations:

- for (int i = 1; i <= 10 ; i++) stack.push(i);
- This simulates input: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
- Each stack is printed before and after reversing.
- No manual console input is required.

# Problem 4

- Use 2D cross product to check relative orientation of points.
- Two line segments intersect if the orientations indicate a crossing:

- double cross(Point a, Point b, Point c){ return(b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x); }
- Check all pairs of Ghostbuster-ghost lines for intersection.
- If any pair intersects, the ghosts cannot all be eliminated.

# Example outcome
- It is shown in the screenshot uploaded in blackboard.