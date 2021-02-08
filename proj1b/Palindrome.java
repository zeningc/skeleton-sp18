public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null || word.equals("")) {
            return null;
        }
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean isPalindromeHelper(Deque<Character> d, CharacterComparator c) {
        if (d.size() < 2) {
            return true;
        }
        if (c.equalChars(d.removeFirst(), d.removeLast())) {
            return isPalindromeHelper(d, c);
        }
        return false;
    }

    private boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() < 2) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            return isPalindromeHelper(d);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        return d == null || isPalindromeHelper(d);
    }

    public boolean isPalindrome(String word, CharacterComparator c) {
        Deque<Character> d = wordToDeque(word);
        return d == null || isPalindromeHelper(d, c);
    }

}
