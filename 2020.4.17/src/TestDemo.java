import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

/**
 * @program: 2020.4.17
 * @description: 二维数组
 * @author: spdz
 * @create: 2020-04-16 18:51
 **/
public class TestDemo {

    public static void main(String[] args) {
        int d = Byte.MAX_VALUE + 1;
        byte e = (byte)(Byte.MAX_VALUE + 1);
        System.out.println(d+" " + e);
    }

    /**
     *找出出现一次的数字
     *只有两个数字是出现一次，其他是两次，请找出这两个数字
     * @param array
     * @return
     */
    //全部异或
    public static int xor(int[] array) {
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        return xor;
    }
    //二进制从右起第一个1的位数
    public static int findOne(int num) {
        int i = 0;
        for (int j = 0; j < 32; j++) {
            i++;
            if (((num>>j) & 1) == 1) {
                return i;
            }
        }
        return 0;
    }
    public static int isBit(int i,int k) {
        if(((i>>(k-1)) & 1) == 1) {
            return 1;
        }else {
            return 0;
        }
    }
    public static int[] findNum(int[] array) {
        if (array == null||array.length < 2) {
            return null;
        }
        int[] arr = new int[2];
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < array.length; i++) {
            if(isBit(array[i],findOne(xor(array))) == 1) {
                num1 ^= array[i];
            }else {
                num2 ^= array[i];
            }
        }
        arr[0] = num1;
        arr[1] = num2;
        return arr;
    }
    public static void main3(String[] args) {
        int[] array = {2,3,4,5,2,6,8,9,3,4,6,8};
        System.out.println(Arrays.toString(findNum(array)));
    }


    /**
     *
     * @param args
     */
    public static void main2(String[] args) {
        int[][] array = new int[2][3];
        System.out.println(Arrays.deepToString(array));

        int[][] array1 = new int[2][];
        array1[0] = new int[]{1,2,3};
        array1[1] = new int[2];
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1[i].length; j++) {
                System.out.print(array1[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 二维数组的打印
     * @param args
     */
    public static void main1(String[] args) {
        int[][] array = {{1,2,3},{4,5}};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.deepToString(array));

        int[][] array1 = new int[][]{{2,3,5},{5,6}};
        for (int[] arr:array1) {
            for (int arr1:arr) {
                System.out.print(arr1 + " ");
            }
            System.out.println();
        }

        int[][] array2 = {{1,2,3},{4,5,6}};
        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                System.out.print(array2[i][j] + " ");
            }
            System.out.println();
        }

        int[][] array3 = new int[2][3];

    }
}
