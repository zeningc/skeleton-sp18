public class OffByOne extends Palindrome implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y) {
        return Character.isLetter(x) && Character.isLetter(y) && Math.abs(x - y) == 1;
    }

}
