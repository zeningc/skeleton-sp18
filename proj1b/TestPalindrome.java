import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {

        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertFalse(palindrome.isPalindrome("aA"));
        assertFalse(palindrome.isPalindrome("persiflage"));
        assertTrue(palindrome.isPalindrome("hell1lleh"));
        assertTrue(palindrome.isPalindrome("helllleh"));
        assertFalse(palindrome.isPalindrome("hellLleH"));
        assertTrue(palindrome.isPalindrome("hellalleh"));
        assertTrue(palindrome.isPalindrome("123321"));
        assertFalse(palindrome.isPalindrome("123jjsadhfa"));

        OffByOne offByOne = new OffByOne();

        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertFalse(palindrome.isPalindrome("aA", offByOne));
        assertFalse(palindrome.isPalindrome("persiflage", offByOne));
        assertTrue(palindrome.isPalindrome("hell1kmdi", offByOne));
        assertTrue(palindrome.isPalindrome("hellkmdi", offByOne));
        assertFalse(palindrome.isPalindrome("hellKmdI", offByOne));
        assertTrue(palindrome.isPalindrome("hellakmdi", offByOne));
        assertTrue(palindrome.isPalindrome("123432", offByOne));
        assertFalse(palindrome.isPalindrome("123jjsadhfa", offByOne));
    }

}
