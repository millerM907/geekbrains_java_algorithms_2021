package DZ_2;

public class Test {

    public static void main(String[] args) {
        int SIZE_ARRAY = 100000;

        Integer[] bubbleArr = new Integer[SIZE_ARRAY];
        Test.fillArrayRandomNumber(bubbleArr);
        Integer[]  selectArr = new Integer[SIZE_ARRAY];
        Test.arrayCopy(bubbleArr, selectArr);
        Integer[] insertArr = new Integer[SIZE_ARRAY];
        Test.arrayCopy(bubbleArr, insertArr);

        long startBubbleSortNanoTime = System.nanoTime();
        Test.bubbleSort(bubbleArr);
        long stopBubbleSortNanoTime = System.nanoTime();

        long startSelectSortNanoTime = System.nanoTime();
        Test.selectSort(selectArr);
        long stopSelectSortNanoTime = System.nanoTime();

        long startInsertSortNanoTime = System.nanoTime();
        Test.insertSort(insertArr);
        long stopInsertSortNanoTime = System.nanoTime();

        System.out.println("Сортироврка пузырьком заняла (миллисек): " + (stopBubbleSortNanoTime - startBubbleSortNanoTime) / 1000000);
        System.out.println("Сортироврка выбором заняла (миллисек): " + (stopSelectSortNanoTime - startSelectSortNanoTime) / 1000000);
        System.out.println("Сортироврка вставкой заняла (миллисек): " + (stopInsertSortNanoTime - startInsertSortNanoTime) / 1000000);
    }

    private static void fillArrayRandomNumber(Integer[] arrayList) {
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = getRandomNum(1, 10_000);
        }
    }

    static void arrayCopy(Integer[] srcArr, Integer[] destArr) {
        if (srcArr.length == destArr.length) {
            System.arraycopy(srcArr, 0, destArr, 0, srcArr.length);
        }
    }

    static Integer getRandomNum(int min, int max) {
        return (int) ((Math.random() * ((max - min) + 1)) + min);
    }


    static void bubbleSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - j; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(j, j + 1, array);
                }
            }
        }
    }

    static void selectSort(Integer[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = 1;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(minIndex, i, array);
        }
    }

    static void insertSort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int in = i;
            while (in > 0 && array[in - 1].compareTo(temp) >= 0) {
                array[in] = array[in - 1];
                in--;
            }
            array[in] = temp;
        }
    }

    static void swap(int a, int b, Integer[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
