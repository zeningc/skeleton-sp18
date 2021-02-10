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
        while (true) {
            insertNum = StdRandom.uniform(1000);
            random = StdRandom.uniform(4);
            switch (random) {
                case 0:
                    sad.addFirst(insertNum);
                    ads.addFirst(insertNum);
                    msg += "\naddFirst(" + insertNum + ")";
                    break;
                case 1:
                    sad.addLast(insertNum);
                    ads.addLast(insertNum);
                    msg += "\naddLast(" + insertNum + ")";
                    break;
                case 2:
                    if (ads.size() > 0 && !sad.isEmpty()) {
                        Integer a = sad.removeFirst();
                        Integer b = ads.removeFirst();
                        msg += "\nremoveFirst(): ";
                        assertEquals(msg, b, a);
                    }
                    break;
                case 3:
                    if (ads.size() > 0 && !sad.isEmpty()) {
                        Integer a = sad.removeLast();
                        Integer b = ads.removeLast();
                        msg += "\nremoveLast(): ";
                        assertEquals(msg, b, a);
                    }
                    break;
                default:
            }
        }
    }

}
