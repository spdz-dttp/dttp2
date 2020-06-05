import java.util.Arrays;

/**
 * @program: 2020.6.3
 * @description:
 * @author: spdz
 * @create: 2020-06-03 23:57
 **/
public class TestSort {

    /**
     *
     * 快速排序（未优化）（递归）
     *
     * 时间复杂度: O(n*log(2)n)  最坏情况: O(n^2)
     * 空间复杂度: O(log(2)n)   最坏情况: O(n)
     * 不稳定排序
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
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

    public static void quick(int[] array, int left,int right) {
        if (left >= right) {
            return;
        }
        int par = partition(array,left,right);
        quick(array,left,par-1);
        quick(array,par+1,right);
    }

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {6,1,2,7,9,3,4,5,10,8};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
