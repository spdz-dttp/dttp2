import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @program: 2020.6.16
 * @description:比较练习
 * @author: spdz
 * @create: 2020-07-14 19:37
 **/
public class TestDemo {

    //找到 K 个最接近的元素
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length;
        while (right - left > 1) {
            int mid = (left + right) >> 1;
            if (arr[mid] == x) {
                left = mid;
                right = mid + 1;
            }else if (arr[mid] > x) {
                right = mid;
            }else {
                left = mid;
            }
        }
        while (k > 0) {
            if (right >= arr.length) {
                left--;
            }else if (left < 0) {
                right++;
            }else {
                if (arr[right] - x >= x - arr[left]) {
                    left--;
                }else {
                    right++;
                }
            }
            k--;
        }
        for (int i = left + 1; i < right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = -1;
        System.out.println(findClosestElements(arr, k, x));
    }

    public static void main3(String[] args) {
        int i = 3;
        int n = i/2;
        System.out.println(n);//1
    }

    //比较版本号
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        for (int i = 0; i < Math.max(arr1.length,arr2.length); i++) {
            int a = 0;
            if (i < arr1.length) {
                a = Integer.parseInt(arr1[i]);
            }else {
                a = 0;
            }
            int b = 0;
            if (i < arr2.length) {
                b = Integer.parseInt(arr2[i]);
            }else {
                b = 0;
            }
            if (a < b) {
                return -1;
            }else if (a > b) {
                return 1;
            }
        }
        return 0;
    }

    public static void main2(String[] args) {
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";
        System.out.println(compareVersion(version1, version2));
    }

    public static <E> void swap(E[] array, int i, int j) {
        E t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main1(String[] args) {
        String[] array = {"aaa","bbb","ccc","ddd"};
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(array));
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        swap(array,i,j);
        System.out.println(Arrays.toString(array));

        Integer[] array2 = new Integer[]{1,2,3,4,5,6};
        System.out.println(Arrays.toString(array2));
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        swap(array2,n,m);
        System.out.println(Arrays.toString(array2));
    }
}
