package geekbrains_java_algorithms_2021.DZ_2;

public class Test {

    public static void main(String[] args) {
        int SIZE_ARRAY = 1_00_000;
        ArrayImpl<Integer> bubbleArr = getRandomArrImpl(SIZE_ARRAY);
        ArrayImpl<Integer> selectArr  = new ArrayImpl<>();
        selectArr.size = bubbleArr.size;
        selectArr.data = bubbleArr.data;
        ArrayImpl<Integer> insertArr = new ArrayImpl<>();
        insertArr.size = bubbleArr.size;
        insertArr.data = bubbleArr.data;

        long startBubbleSortNanoTime = System.nanoTime();
        bubbleArr.bubbleSort();
        long stopBubbleSortNanoTime = System.nanoTime();

        long startSelectSortNanoTime = System.nanoTime();
        selectArr.selectSort();
        long stopSelectSortNanoTime = System.nanoTime();

        long startInsertSortNanoTime = System.nanoTime();
        insertArr.insertSort();
        long stopInsertSortNanoTime = System.nanoTime();

        System.out.println("Сортироврка пузырьком заняла (миллисек): " + (stopBubbleSortNanoTime - startBubbleSortNanoTime) / 1000000);
        System.out.println("Сортироврка выбором заняла (миллисек): " + (stopSelectSortNanoTime - startSelectSortNanoTime) / 1000000);
        System.out.println("Сортироврка вставкой заняла (миллисек): " + (stopInsertSortNanoTime - startInsertSortNanoTime) / 1000000);
    }

    static ArrayImpl<Integer> getRandomArrImpl(int sizeArray) {
        ArrayImpl<Integer> arrayImpl = new ArrayImpl<>();
        for (int i = 0; i < sizeArray; i++) {
            arrayImpl.add(getRandomNum(0, sizeArray));
        }
        return arrayImpl;
    }

    static  Integer getRandomNum(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }
}
