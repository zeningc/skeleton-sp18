public class LinkedListDeque<T> {
    private class LinkedList {
        private LinkedList next;
        private LinkedList prev;
        private T item;

        public LinkedList(T i, LinkedList n, LinkedList p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private LinkedList head;
    private int size;

    public LinkedListDeque() {
        head = new LinkedList(null, null, null);
        head.next = head;
        head.prev = head;
    }

    public void addFirst(T item) {
        LinkedList p = new LinkedList(item, head.next, head);
        head.next = p;
        p.next.prev = p;
        size += 1;
    }

    public void addLast(T item) {
        LinkedList p = new LinkedList(item, head, head.prev);
        head.prev = p;
        p.prev.next = p;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (size == 0) {
            return;
        }
        LinkedList p = head.next;
        while (p != head) {
            System.out.print(p.item);
            if (p.next != null) {
                System.out.print(" ");
            }
            p = p.next;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        LinkedList p = head.next;
        head.next = p.next;
        p.next.prev = head;
        size -= 1;
        return p.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        LinkedList p = head.prev;
        head.prev = p.prev;
        p.prev.next = head;
        size -= 1;
        return p.item;
    }

    public T get(int index) {
        if (size <= index) {
            return null;
        }
        LinkedList p = head.next;
        while (p != head) {
            if (index == 0) {
                return p.item;
            }
            p = p.next;
            index -= 1;
        }
        return null;
    }

    private T getRecursiveHelper(int index, LinkedList p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index - 1, p.next);
    }

    public T getRecursive(int index) {
        if (size <= index) {
            return null;
        }
        return getRecursiveHelper(index, head.next);
    }


}
