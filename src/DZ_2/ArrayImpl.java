package DZ_2;

import java.util.Arrays;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    protected static final int DEFAULT_CAPACITY = 8;

    protected E[] data;
    protected int size;


    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    //O(1) -> O(n)
    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    protected void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    //O(1)
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errMsg = String.format("Incorrect 'index' value: %d; max value is %d", index, size - 1);
            throw new IndexOutOfBoundsException(errMsg);
        }
    }

    @Override
    public boolean remove(E value) {
        return remove(indexOf(value)) != null;
    }

    //O(n)
    @Override
    public E remove(int index) {
        checkIndex(index);

        E removedValue = data[index];
        if ((size - index - 1) >= 0) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }

        data[--size] = null;

        return removedValue;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - j; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public void selectSort() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = 1;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    @Override
    public void insertSort() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    private void swap(int a, int b) {
        E tmp = this.data[a];
        this.data[a] = this.data[b];
        this.data[b] = tmp;
    }

    //O(n)
    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])) return i;
        }
        return -1;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "ArrayImpl{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }
}
