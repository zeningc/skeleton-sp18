public class OffByN extends Palindrome implements CharacterComparator {

    private int N;

    public OffByN(int n) {
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Character.isLetter(x) && Character.isLetter(y) && Math.abs(x - y) == N;
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
