import java.util.Arrays;
import java.util.Random;

/**
 * @program: 2020.6.3
 * @description:
 * @author: spdz
 * @create: 2020-06-04 22:34
 **/
public class TestSort2 {

    //快速排序(优化)（递归）

    public static int partition(int[] array,int low,int high) {
        int t = array[low];
        while (high > low) {
            while (array[high] >= t && high > low) {
                high--;
            }
            array[low] = array[high];
            while (array[low] <= t && high > low) {
                low++;
            }
            array[high] = array[low];
        }
        array[high] = t;
        return high;
    }

    public static void insert_sort(int[] array,int start, int end) {
        for (int i = start+1; i <= end; i++) {
            int t = array[i];
            int j = i-1;
            for (; j >= start ; j--) {
                if (array[j] > t) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = t;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void three_num_mid(int[] array, int left, int right) {
        int mid = (left+right)/2;
        if (array[mid] > array[right]) {
            swap(array,mid,right);
        }
        if (array[left] > array[right]) {
            swap(array,left,right);
        }
        if (array[mid] > array[left]) {
            swap(array,mid,left);
        }
    }

    public static void quick(int[] array, int left,int right) {
        if (left >= right) {
            return;
        }
        //优化方法一 : 当待排序序列的数据小于等于100时，用直接插入排序
        if (right-left+1 <= 100) {
            insert_sort(array,left,right);
            return;
        }

        //优化方法二 : 三数取中
        //    让第一个元素的值更接近数组中数的中间值
        three_num_mid(array, left,right);

        int par = partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void main2(String[] args) {
        int[] array = new int[100_0000];
        Random random = new Random();
        for (int i = 0; i < 100_0000; i++) {
            array[i] = random.nextInt(100_0000);
        }
        long start = System.currentTimeMillis();
        quickSort(array);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        int[] array = {6,1,2,7,9,3,4,5,10,8};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
