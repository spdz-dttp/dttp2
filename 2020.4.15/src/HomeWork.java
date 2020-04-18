import java.util.Arrays;

/**
 * @program: 2020.4.15
 * @description:数组
 * @author: spdz
 * @create: 2020-04-14 23:44
 **/
public class HomeWork {

    /**
     * 奇数位于偶数之前
     * @param array
     */
    public static void move1(int[] array) {
        int len = array.length;
        for (int i = 0; i <= len-1; i++) {
            for (int j = len-1; j > i ; j--) {
                if (array[j]%2 != 0) {
                    int t = array[j-1];
                    array[j-1] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    public static void move2(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            if (array[left]%2 ==0 && array[right]%2 != 0) {
                int t = array[left];
                array[left] = array[right];
                array[right] = t;
            }
            if (array[left]%2 != 0){
                left++;
            }
            if (array[right]%2 == 0) {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {7,2,5,4,8,6,4,5,3,2,5};
        System.out.println(Arrays.toString(array));

        move1(array);
        System.out.println(Arrays.toString(array));

        /*move2(array);
        System.out.println(Arrays.toString(array));*/
    }


    /**
     * 创建一个 int 类型的数组, 元素个数为 100,
     * 并把每个元素依次设置为 1 - 100
     * @param array
     */
    public static void assignment(int[] array) {
        for (int i = 0; i < 100; i++) {
            array[i] = (i+1);
        }
    }
    public static void main5(String[] args) {
        int[] array = new int[100];
        System.out.println(Arrays.toString(array));
        assignment(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 循环访问数组中的每个元素, 打印每个元素的值.
     * @param array
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main4(String[] args) {
        int[] array = {1,2,3,4,5,6};
        printArray(array);
    }


    /**
     * 将数组中的每个元素 乘以 2
     * @param array
     */
    public static void transform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i]*2;
        }
    }
    public static void main3(String[] args) {
        int[] array= {1,2,3};
        System.out.println(Arrays.toString(array));
        transform(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * 数组所有元素之和
     * @param array
     * @return
     */
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        return sum;
    }
    public static void main2(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        System.out.println("元素和:" + sum(array));
    }


    /**
     * 数组的平均值
     * @param array
     * @return
     */
    public static double avq(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        return sum/array.length;
    }
    public static void main1(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(Arrays.toString(array));
        System.out.println("平均数:" + avq(array));
    }
}
