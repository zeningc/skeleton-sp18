public class OffByOne extends Palindrome implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return Character.isLetter(x) && Character.isLetter(y) && Math.abs(x - y) == 1;
    }

    @Override
    protected boolean isPalindromeHelper(Deque<Character> d) {
        if (d.size() < 2) {
            return true;
        }
        if (equalChars(d.removeFirst(), d.removeLast())) {
            return isPalindromeHelper(d);
        }
        return false;
    }
}
