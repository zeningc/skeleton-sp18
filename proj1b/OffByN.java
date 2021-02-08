public class OffByN implements CharacterComparator {

    private int N;

    public OffByN(int n) {
        N = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Character.isLetter(x) && Character.isLetter(y) && Math.abs(x - y) == N;
    }

}
