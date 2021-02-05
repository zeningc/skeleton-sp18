
public class ArrayDeque<T> {
    private T[] array;
    private static final double FACTOR = 0.25;
    private int size;
    private int head;
    private int tail;

    public ArrayDeque() {
        size = 0;
        array = (T[]) new Object[8];
        head = 0;
        tail = 0;
    }

    private void increaseSize() {
        int length;
        if (array.length < 16) {
            length = 16;
        } else {
            length = (int) ((double) size / FACTOR);
        }
        T[] a = (T[]) new Object[length];
        if (head < tail) {
            System.arraycopy(array, head, a, 0, array.length);
        } else {
            System.arraycopy(array, head, a, 0, array.length - head);
            System.arraycopy(array, 0, a, array.length - head, tail);
        }
        head = 0;
        tail = size;
        array = a;
    }

    public void addFirst(T item) {
        if (size == array.length) {
            increaseSize();
        }
        head = (head + array.length - 1) % array.length;
        array[head] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size == array.length) {
            increaseSize();
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
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
        int i = head;
        while (i != tail) {
            System.out.print(array[i]);
            if (i % array.length != (tail - 1) % array.length) {
                System.out.print(" ");
            }
            i = (i + 1) % array.length;
        }
    }

    private void decreaseSize() {
        if (array.length > 16 && (double) size / array.length < FACTOR) {
            int length = (int) ((double) array.length * FACTOR);
            T[] a = (T[]) new Object[length];
            if (head < tail) {
                System.arraycopy(array, head, a, 0, size);
            } else {
                System.arraycopy(array, head, a, 0, array.length - head);
                System.arraycopy(array, 0, a, array.length - head, tail);
            }
            head = 0;
            tail = size;
            array = a;

        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = array[head];
        head = (head + 1) % array.length;
        size -= 1;
        if (array.length > 16 && (double) size / array.length < FACTOR) {
            decreaseSize();
        }
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        tail = (tail + array.length - 1) % array.length;
        T item = array[tail];
        size -= 1;
        if (array.length > 16 && (double) size / array.length < FACTOR) {
            decreaseSize();
        }
        return item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[(head + index) % array.length];
    }


}
