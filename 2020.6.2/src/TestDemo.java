import java.util.Scanner;

/**
 * @program: 2020.6.2
 * @description:
 * @author: spdz
 * @create: 2020-06-03 21:22
 **/
public class TestDemo {

    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";//等号比较引用地址，equals()比较值。
    }

    public static boolean isAdmin2(String userId){
        return userId.toLowerCase().equals("admin");

    }

    public static void main(String[] args){
        System.out.println(isAdmin("Admin"));//false
        System.out.println(isAdmin2("Admin"));//true
    }

    //一个数组中逆序对个数
    public static int func2(int[] array, int n) {
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (array[i] > array[j]) {
                    t++;
                }
            }
        }
        return t;
    }

    public static void main2(String[] args) {
        int[] array = {1,2,3,4,2,6,7,0};
        int n = array.length;
        System.out.println(func2(array, n));
    }

    //三个空气水瓶换一瓶汽水
    public static int func(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int a = n/3;
        int b = n%3;
        return a + func(a+b);
    }

    public static void main1(String[] args) {
        int[] array = new int[10];
        int use = 0;
        Scanner scanner = new Scanner(System.in);
        while (use < 10) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            array[use] = n;
            use++;
        }
        for (int i = 0; i < use; i++) {
            int n = array[i];
            System.out.println(func(n));
        }
    }
}
