import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 2020.4.16
 * @description:数组
 * @author: spdz
 * @create: 2020-04-15 18:45
 **/
public class TestDemo {


    /**
     * 数组转字符串
     * @param array
     */
    public static void toString(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if (i != array.length-1) {
                ret += ",";
            }
        }
        ret += "]";
        System.out.println(ret);
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        toString(array);
    }


    /**
     * 冒泡排序
     * @param array
     */
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
            if (flg == false) {
                break;
            }
        }
    }
    public static void main8(String[] args) {
        int[] array = {12,11,4,8,5,3,4,2,9,10};

        /*Arrays.sort(array);
        System.out.println(Arrays.toString(array));*/

        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 判断数组是否升序
     * @param array
     * @return
     */
    public static boolean isUP(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
    public static void main7(String[] args) {
        int[] array = {1,3,4,5,7,5};
        System.out.println(isUP(array));
    }


    /**
     * 数组排序
     * Array.sort
     * 底层是什么排序？
     * @param args
     */
    public static void main6(String[] args) {
        int[] array = {2,5,3,7,1,6,9};
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 填充数组
     * Arrays.fill
     * 左闭右开
     * @param args
     */
    public static void main5(String[] args) {
        int[] array = new int[10];
        Arrays.fill(array,6);
        System.out.println(Arrays.toString(array));

        Arrays.fill(array,3,7,8);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 二分查找
     * Arrays.binarySearch  二分查找
     * 左闭右开
     * @param array
     * @param k:查找的数
     * @return
     */
    public static int binarySearch(int[] array,int k) {
        int left = 0;
        int right = array.length-1;
        while(left <= right) {
            int mid = (left + right)/2;
            if (array[mid] < k) {
                left = mid + 1;
            }else if (array[mid] > k) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static void main4(String[] args) {
        int[] array = {2,3,4,6,7,8,10,20,31,35};
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        /*int i = binarySearch(array,k);
        System.out.println("下标为：" + i);*/

        System.out.println(Arrays.binarySearch(array,k));
        int k1 = scanner.nextInt();
        System.out.println(Arrays.binarySearch(array, 2, 8,k1));
    }


    /**
     * 复制数组
     * Arrays.copyOf
     * System.arraycopy  最快
     * clone
     * @param args
     */
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        /*int[] array1 = Arrays.copyOf(array,array.length);
        System.out.println(Arrays.toString(array1));*/

        int[] array2 = new int[array.length];
        System.arraycopy(array,0,array2,0,array.length);
        System.out.println(Arrays.toString(array2));

        /*int[] array3 = array.clone();
        System.out.println(Arrays.toString(array3));*/
    }


    /**
     * 找数组最大值
     * @param array
     * @return
     */
    public static int max(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main2(String[] args) {
        int[] array = {1,5,6,2,4,9,8};
        System.out.println(max(array));
    }


    /**
     * 复制数组
     * @param array
     * @return
     */
    public static int[] copyArray(int[] array) {
        int[] array1 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            array1[i] = array[i];
        }
        return array1;
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        int[] array2 = copyArray(array);
        System.out.println(Arrays.toString(array2));
    }
}
