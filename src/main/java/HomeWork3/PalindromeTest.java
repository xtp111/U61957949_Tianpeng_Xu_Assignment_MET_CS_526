
package HomeWork3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @Test
    public void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("madam"));
        assertTrue(Palindrome.isPalindrome("racecar"));
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
        assertFalse(Palindrome.isPalindrome("java"));
    }

    @Test
    public void testPalindromeWithSpaces() {
        assertFalse(Palindrome.isPalindrome("nurses run"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }
}
