import java.util.Arrays;

/**
 * @program: 2020.4.19
 * @description:数组练习
 * @author: spdz
 * @create: 2020-04-19 10:39
 **/


public class TestDemo {

    private static int x = 100;

    /**
     * 交换两个数组
     * @param array
     * @param array2
     */
    public static void moveArray(int[] array,int[] array2) {
        for (int i = 0; i < array.length; i++) {
            int t = array[i];
            array[i] = array2[i];
            array2[i] = t;
        }
    }
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = {6,5,4,3,2,1};
        moveArray(array,array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }


    /**
     * 偶数位于奇数之前
     * @param array
     */
    public static void move(int[] array) {
        int left = 0;
        int right = array.length-1;
        while (left < right) {
            if (array[left]%2 !=0 && array[right]%2 == 0) {
                int t = array[left];
                array[left] = array[right];
                array[right] = t;
            }
            if (array[left]%2 == 0){
                left++;
            }
            if (array[right]%2 != 0) {
                right--;
            }
        }
    }

    public static void main2(String[] args) {
        int[] array = {7,2,5,4,8,6,4,5,3,2,5};
        System.out.println(Arrays.toString(array));

        move(array);
        System.out.println(Arrays.toString(array));
    }


    public static void main1(String args[]) {
        TestDemo hsl = new TestDemo();
        hsl.x++;
        TestDemo hs2 = new TestDemo();
        hs2.x++;
        hsl = new TestDemo();
        hsl.x++;
        TestDemo.x--;
        System.out.println(" x=" + x);
    }
}
