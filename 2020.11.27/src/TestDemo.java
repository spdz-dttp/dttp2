import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 2020.11.27
 * @description: ${description}
 * @author: spdz
 * @create: 2020-11-27 15:54
 **/
public class TestDemo {

    //字符串中的第一个唯一字符下标
    public static int firstOnlyChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            int first = str.indexOf(str.charAt(i));
            int last = str.lastIndexOf(str.charAt(i));
            if (first == last) {
                return i;
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int i = firstOnlyChar(str);
        System.out.println(str.charAt(i));
    }

    public static void main2(String[] args) {
        long[] array = {1,9,5,3,2,8,6,7,4};
        System.out.println(Arrays.toString(array));
        Heap.createHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) throws NoSuchFieldException {
        long[] array = {1,9,5,3,2,8,6,7,4,9,10};
        System.out.println(Arrays.toString(array));
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        for (long e : array) {
            myPriorityQueue.add(e);
        }
        myPriorityQueue.show();
        System.out.println(myPriorityQueue.element());
        System.out.println(myPriorityQueue.remove());
        myPriorityQueue.show();
    }


}
