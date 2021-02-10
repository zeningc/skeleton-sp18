public class Quick {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution();
        sad.addLast(919);
        sad.addLast(431);
        sad.removeFirst();
        sad.removeLast();
        sad.addLast(716);
        sad.removeFirst();
        sad.addLast(111);
        sad.removeLast();
        sad.addLast(857);
        sad.addLast(297);
        sad.addFirst(692);
        sad.removeFirst();
        sad.addFirst(632);
        sad.addFirst(916);
        sad.removeLast();
        sad.addLast(839);
        sad.addFirst(105);
        sad.removeFirst();
        sad.addLast(855);
        sad.addLast(783);

        ads.addLast(919);
        ads.addLast(431);
        ads.removeFirst();
        ads.removeLast();
        ads.addLast(716);
        ads.removeFirst();
        ads.addLast(111);
        ads.removeLast();
        ads.addLast(857);
        ads.addLast(297);
        ads.addFirst(692);
        ads.removeFirst();
        ads.addFirst(632);
        ads.addFirst(916);
        ads.removeLast();
        ads.addLast(839);
        ads.addFirst(105);
        ads.removeFirst();
        ads.addLast(855);
        ads.addLast(783);
        
        Integer a=sad.removeLast();
        Integer b = ads.removeLast();

        sad.addLast(952);
        sad.addFirst(588);
        sad.addFirst(408);
        sad.removeFirst();
        sad.addFirst(240);
        sad.removeFirst();
        sad.addFirst(603);
        sad.addLast(116);
        sad.removeLast();
        sad.addLast(775);
        sad.addLast(405);
        sad.removeLast();
        sad.addFirst(690);
        sad.removeFirst();
        sad.addFirst(100);
        sad.removeLast();
        Integer i = sad.removeLast();
    }
}
