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

    protected boolean isPalindromeHelper(Deque<Character> d) {
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
        return d == null ? true : isPalindromeHelper(d);
    }

//    public boolean isPalindrome(String word) {
//        if (word.length() < 2) {
//            return true;
//        }
//        Deque<Character> d = wordToDeque(word);
//        while (d.size() != 0 && d.size() != 1) {
//            Character c1 = d.removeFirst();
//            Character c2 = d.removeLast();
//            if (c1 != c2) {
//                return false;
//            }
//        }
//
//        return true;
//    }
}
