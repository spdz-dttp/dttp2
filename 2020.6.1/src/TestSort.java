import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.jar.JarOutputStream;

/**
 * @program: 2020.6.1
 * @description:排序2
 * @author: spdz
 * @create: 2020-06-02 23:48
 **/
public class TestSort {

    /**
     * 冒泡排序
     *
     *  时间复杂度: O(n^2)
     *  空间复杂度: O(1)
     *  稳定性排序
     * @param array
     */
    public static void bubbleSort1(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                    flg = true;
                }
            }
            if (flg == false) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {10,15,8,4,1,9};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 堆排序
     *
     * 时间复杂度: O(n*log(2)n)
     * 空间复杂度: O(1)
     * 不稳定排序
     * @param array
     * @param root
     * @param end
     */
    public static void adjustDown(int[] array, int root, int end) {
        int p = root;
        int c = p*2 + 1;
        while(c < end) {
            if (c+1<end && array[c]<array[c+1]) {
                c++;
            }
            if (array[c] > array[p]) {
                int t = array[c];
                array[c] = array[p];
                array[p] = t;
                p = c;
                c = 2*p+1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0; i--) {
            adjustDown(array,i,array.length);
        }
    }

    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length;
        while (end > 0) {
            int t = array[0];
            array[0] = array[end-1];
            array[end-1] = t;
            adjustDown(array,0,end-1);
            end--;
        }
    }

    public static void main3(String[] args) {
        int[] array = {10,15,8,4,1,9};
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 选择排序
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度：O(1)
     * 不稳定排序
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    public static void main2(String[] args) {
        int[] array = new int[10_0000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            //array[i] = random.nextInt(10_0000);
        }
        long start = System.currentTimeMillis();
        selectSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

    public static void main1(String[] args){
        int[] array = {10,15,8,4,1,9};
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
