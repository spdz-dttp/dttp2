import java.util.Arrays;

/**
 * @program: 2020.11.27
 * @description: PriorityQueue
 * @author: spdz
 * @create: 2020-11-28 22:37
 **/

//优先级队列---小堆
public class MyPriorityQueue {

    private long[] array = new long[10];
    private int size;

    private boolean isFull() {
        return size == array.length;
    }

    private void expansion() {
        array = Arrays.copyOf(array,array.length*2);

    }

    void add(long l) {
        if (isFull()) {
            expansion();
        }
        array[size++] = l;
        adjustUp(array,size-1);
    }

    //向上调整
    private void adjustUp(long[] array, int i) {
        while (true) {
            int parentIndex = (i-1)/2;
            if (i == 0) {
                return;
            }
            if (array[parentIndex] < array[i]) {
                return;
            }else {
                long t = array[parentIndex];
                array[parentIndex] = array[i];
                array[i] = t;
            }
            i = parentIndex;
        }

    }


    //删除堆顶元素
    long remove() throws NoSuchFieldException {
        if (size <= 0) {
            throw new NoSuchFieldException();
        }

        long s = array[0];
        array[0] = array[size-1];
        size--;
        adjustDown(array,0);
        return s;
    }

    //向下调整
    private void adjustDown(long[] array, int i) {

        while (true) {
            int leftIndex = i * 2 + 1;
            int rightIndex = i * 2 + 2;

            if (leftIndex >= size) {
                return;
            }
            int minIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }
            if (array[i] < array[minIndex]) {
                return;
            }
            long t = array[i];
            array[i] = array[minIndex];
            array[minIndex] = t;
            i = minIndex;
        }

    }

    //返回堆顶元素
    long element() throws NoSuchFieldException {
        if (size <= 0) {
            throw new NoSuchFieldException();
        }
        return array[0];
    }

    //打印堆
    void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
