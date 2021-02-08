import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('1', '2'));

        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('1', '1'));
        assertFalse(offByOne.equalChars('a', 'B'));

        Palindrome palindrome = new Palindrome();

        assertTrue(palindrome.isPalindrome(null));
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
