import java.util.Arrays;

/**
 * @program: 2020.4.16
 * @description: 二维数组
 * @author: spdz
 * @create: 2020-04-16 23:20
 **/
public class TestDemo2 {

    public static void main(String[] args) {
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
