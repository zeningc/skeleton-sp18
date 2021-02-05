
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
            length = (int) ((size + 1) / FACTOR);
        }
        T[] a = (T[]) new Object[length];
        System.arraycopy(array, 0, a, 0, size);
        array = a;
    }

    public void addFirst(T item) {
        if (size + 1 == array.length) {
            increaseSize();
        }
        head = (head - 1) % array.length;
        array[head] = item;
        size += 1;
    }

    public void addLast(T item) {
        if (size + 1 == array.length) {
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
        if (array.length > 16 && (size - 1) / array.length < FACTOR) {
            int length = (int) ((size - 1) * FACTOR);
            T[] a = (T[]) new Object[length];
            System.arraycopy(array, 0, a, 0, size);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        if (array.length > 16 && (size - 1) / array.length < FACTOR) {
            decreaseSize();
        }
        T item = array[head];
        head = (head + 1) % array.length;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        if (array.length > 16 && (size - 1) / array.length < FACTOR) {
            decreaseSize();
        }
        tail = (tail - 1) % array.length;
        size -= 1;
        return array[tail];
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return array[(head + index) % array.length];
    }


}
