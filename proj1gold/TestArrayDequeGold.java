import static org.junit.Assert.*;

import org.junit.Test;

public class TestArrayDequeGold {

    @Test(timeout = 1000)
    public void testAddRemove() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String msg = new String();
        int random;
        Integer insertNum;
        int sadSize = 0;
        while (true) {
            insertNum = StdRandom.uniform(1000);
            random = StdRandom.uniform(4);
            switch (random) {
                case 0:
                    sad.addFirst(insertNum);
                    ads.addFirst(insertNum);
                    sadSize++;
                    msg += "addFirst(" + insertNum + ")\n";
                    break;
                case 1:
                    sad.addLast(insertNum);
                    ads.addLast(insertNum);
                    sadSize++;
                    msg += "addLast(" + insertNum + ")\n";
                    break;
                case 2:
                    if (ads.size() > 0 && sadSize > 0) {
                        Integer a = sad.removeFirst();
                        Integer b = ads.removeFirst();
                        msg += "removeFirst(): " + a;
                        ;
                        assertEquals(msg, b, a);
                        msg += "\n";
                        sadSize--;
                    }
                    break;
                case 3:
                    if (ads.size() > 0 && sadSize > 0) {
                        Integer a = sad.removeLast();
                        Integer b = ads.removeLast();
                        msg += "removeLast(): " + a;
                        ;
                        assertEquals(msg, b, a);
                        msg += "\n";
                        sadSize--;
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
