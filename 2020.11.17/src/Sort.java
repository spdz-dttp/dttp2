/**
 * @program: 2020.11.17
 * @description: 排序6
 * @author: spdz
 * @create: 2020-11-18 16:04
 **/
public class Sort {
    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int key = arr[i+1];
            int j;
            for (j = i; j >= 0 && arr[j] > key; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = key;
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1;i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if (!flg) {
                break;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr) {
        quick(arr,0,arr.length-1);
    }

    public static void quick(int[] arr, int left ,int right) {
        if (left >= right) {
            return;
        }
        int t = partition(arr,left,right);
        quick(arr,left,t-1);
        quick(arr,t+1,right);

    }

    public static int partition(int[] arr, int low, int high) {
        int t = arr[low];
        while(low < high) {
            while (low < high && arr[high] >= t) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= t) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = t;
        return low;
    }


    //归并排序
    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }

    public static void mergeSortInternal(int[] array, int low, int high) {
        //当每组数组分解成只有一个时结束
        if (high-low <= 0) {
            return;
        }
        //mid 是每组数组的中间下标（分解后是前一个数组的最后一个数下标）
        int mid = (low + high)>>>1;//除2
        //分解（每次数组都二分）
        mergeSortInternal(array, low, mid);
        mergeSortInternal(array,mid+1,high);//mid+1 是后一个数组的第一个数下标
        //合并
        merge(array,low,mid,high);
    }
    //合并
    public static void merge (int[] array, int low, int mid, int high) {
        int les1 = low;//les1： 前一个数组的第一个数下标
        int les2 = mid + 1;//les2： 后一个数组的第一个数下标
        int[] ret = new int[high-low+1];//建一个长度为 需要合并 的两个数组的长度和 的新数组
        int i = 0;//新数组下标
        //需要合并 的两组按位置依次比较，将小的按顺序放入新数组
        while (les1 <= mid && les2 <= high) {
            //array[les1] <= array[les2] 保证了 归并排序的稳定性
            if (array[les1] <= array[les2]) {
                ret[i++] = array[les1++];
            }else {
                ret[i++] = array[les2++];
            }
        }
        //判断谁没走完，把剩下的数放到ret数组中
        while (mid >= les1) {
            ret[i++] = array[les1++];
        }
        while (high >= les2) {
            ret[i++] = array[les2++];
        }
        //将新数组中的数放到array数组中
        for (int n : ret) {
            array[low++] = n;
        }

    }

}
