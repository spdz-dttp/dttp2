import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 2020.11.23
 * @description: ${description}
 * @author: spdz
 * @create: 2020-11-22 23:10
 **/
public class TestDemo {

    //往字符串 str1 中插入 str2 ，判断有几种方法使其成为回文数
    public static int func(String str1,String str2) {
        int count = 0;
        for (int i = 0; i <= str1.length(); i++) {
            StringBuilder stringBuilder  = new StringBuilder(str1);
            StringBuilder stringBuilder1 = stringBuilder.insert(i,str2);
            String str3 = stringBuilder1.toString();
            String str4 = stringBuilder1.reverse().toString();
            if (str3.equals(str4)) {
                count++;
            }
        }
        return count;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(func(str1, str2));
    }

    //快速排序查找数组第K大的数
    public static int findKth(int[] a, int n, int K) {
        quick(a,0,n-1);
        return a[n-K];
    }

    public static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int t = partition(a,left,right);
        quick(a,left,t-1);
        quick(a,t+1,right);
    }

    public static int partition(int[] a, int low,int high) {
        int t = a[low];
        while (low < high) {
            while (low < high && a[high] >= t) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= t) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = t;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,2,2};
        int n = findKth(a, 5, 3);
        System.out.println(Arrays.toString(a));
        System.out.println(n);
    }

}
