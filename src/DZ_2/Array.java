package DZ_2;

public interface Array<E> {

    void add(E value);

    E get(int index);

    boolean remove(E value);

    E remove(int index);

    int indexOf(E value);

    void bubbleSort();

    void selectSort();

    void insertSort();

    boolean contains(E value);

    boolean isEmpty();

    int size();

    void display();


}
