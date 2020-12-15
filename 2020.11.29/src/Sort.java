/**
 * @program: 2020.11.29
 * @description: 排序7
 * @author: spdz
 * @create: 2020-11-29 17:04
 **/

/**
 * 排序 --- 7 种 基于比较的 排序
 *      插入排序
 *      希尔排序
 *      选择排序
 *      堆排序
 *      冒泡排序
 *      快速排序（重要）
 *      归并排序（重要）
 */

/**
 * 平均时间复杂度
 *  O(n^1.3): 希尔排序
 *  O(n*log(n)): 快速排序、堆排序、归并排序
 *  O(n^2): 插入排序、冒泡排序、选择排序
 */

/**
 * 最好时间复杂度
 *  O(n): 冒泡排序、插入排序
 *  O(n*log(n)): 快速排序、堆排序、归并排序
 *  O(n^2): 选择排序
 */

/**
 * 空间复杂度
 *  O(1): 插入排序、希尔排序、选择排序、堆排序、冒泡排序
 *  O(log(n)): 快速排序
 *  O(n): 归并排序
 */

/**
 * 稳定性
 *  稳定排序：冒泡排序、插入排序、归并排序
 *  不稳定排序：其余
 */

/**
 * 按内部排序/外部排序
 *  外部排序：归并排序
 */

/**
 * 按减治算法/分治算法
 *  减治算法：冒泡排序、插入排序、选择排序、堆排序
 *  分治算法：快速排序、归并排序
 */

public class Sort {

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean f = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    f = true;
                }
            }
            if (!f) {
                return;
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int e = arr[i];
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    arr[j] = arr[j-1];
                    arr[j-1] = e;
                }
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition(arr,left,right);
        quick(arr,left,mid-1);
        quick(arr,mid+1,right);
    }

    private static int partition(int[] arr, int low, int high) {
        int e = arr[low];
        while (low < high) {
            while (high > low && arr[high] >= e) {
                high--;
            }
            arr[low] = arr[high];
            while (high > low && arr[low] <= e) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = e;
        return low;

    }

    //归并排序
    public static void mergeSort(int[] arr) {
        mergeSortInternal(arr,0,arr.length-1);
    }

    private static void mergeSortInternal(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high)>>>1;
        mergeSortInternal(arr,low,mid);
        mergeSortInternal(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    private static void merge(int[] arr,int low,int mid,int high) {
        int les1 = low;
        int les2 = mid + 1;
        int[] ret = new int[high-low+1];
        int i = 0;
        while (les1 <= mid && les2 <= high){
            //arr[les1] <= arr[les2] 保证了 归并排序的稳定性
            if (arr[les1] <= arr[les2]) {
                ret[i++] = arr[les1++];
            }else {
                ret[i++] = arr[les2++];
            }
        }
        while (les1 <= mid) {
            ret[i++] = arr[les1++];
        }
        while (les2 <= high) {
            ret[i++] = arr[les2++];
        }
        for (int e : ret) {
            arr[low++] = e;
        }
    }
}
