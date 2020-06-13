import java.util.Arrays;

/**
 * @program: 2020.6.5
 * @description:
 * @author: spdz
 * @create: 2020-06-12 20:38
 **/

//基数排序
public class RadixSort {

    //获得最大数
    public static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for(int value : array) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    //获得最大数位数
    public static int getMaxLenght(int[] array) {
        int maxValue = getMaxValue(array);
        if (maxValue == 0) {
            return 1;
        }
        int maxLenght = 0;
        for (int i = maxValue; i != 0 ; i/=10) {
            maxLenght++;
        }
        return maxLenght;
    }

    //扩容并存入数据
    public static int[] arrayExpand(int[] array, int k) {
        array = Arrays.copyOf(array, array.length+1);
        array[array.length-1] = k;
        return array;
    }

    //基数排序
    public static void radixSort(int[] array) {
        if (array.length == 0) {
            System.out.println("数组为空");
            return;
        }
        int maxLenght = getMaxLenght(array);
        int a = 10;
        int b = 1;
        for (int i = 0; i < maxLenght; i++) {
            int[][] ret = new int[10][0];
            for (int j = 0; j < array.length; j++) {
                int k = array[j]%a/b;
                ret[k] = arrayExpand(ret[k], array[j]);
            }
            int p = 0;
            for (int[] arr :ret) {
                for (int n :arr) {
                    array[p++] = n;
                }
            }
            a *= 10;
            b *= 10;
        }
    }

    public static void main(String[] args) {
        int[] array = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
        System.out.println(Arrays.toString(array));
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }

}
