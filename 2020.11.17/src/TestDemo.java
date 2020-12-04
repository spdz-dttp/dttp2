import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 2020.11.17
 * @description: ${description}
 * @author: spdz
 * @create: 2020-11-17 09:56
 **/
public class TestDemo {

    public static void main(String[] args) {
        int[] arr = {10,5,7,9,2,8,8,16,6};
        System.out.println(Arrays.toString(arr));
        //Sort.insertSort(arr);
        Sort.quickSort(arr);
        //Sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        //System.out.println(BinarySearch.binarySeach(arr, 2));
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5 - i - 1 ; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i + 1; j++){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    //打印菱形图案
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
            for (int i = 0; i < n + 1; i++) {
                System.out.print("* ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < n - i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }
        }

    }

    public static void main1(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("1 ");
            }
            System.out.println();
        }
    }
}




