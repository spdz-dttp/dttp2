 import java.util.Arrays;
 import java.util.Scanner;

/**
 * @program: 2020.4.14
 * @description:数组，重载
 * @author: spdz
 * @create: 2020-04-13 19:37
 **/
public class TestDemo {

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
    public static void main8(String[] args) {
        int[] array = {7,2,5,4,8,6,4,5,3,2,5};
        System.out.println(Arrays.toString(array));
        move1(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 找出出现一次的数字
     * 只有一个数字是出现一次，其他是两次，请找出这个数字
     * @param array
     * @return
     */
    public static int findNum(int[] array) {
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            num = num ^ array[i];
        }
        return num;
    }
    public static void main7(String[] args) {
        int[] array = {1,2,3,1,3,4,2};
        System.out.println(findNum(array));
    }

    /**
     * 重载
     * 求两个整数的最大值
     * 求两个小数的最大值
     * 两个小数和一个整数的大小关系
     * @param a
     * @param b
     * @return
     */
    public static int max(int a,int b) {
        return a > b ? a : b;
    }
    public static double max(double a, double b) {
        return a > b ? a : b;
    }
    public static double max(double a, double b, int c) {
        return (max(a,b) > c) ? max(a,b) : c;
    }
    public static void main6(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(max(a, b));
        double c = scanner.nextDouble();
        double e = scanner.nextDouble();
        System.out.println(max(c,e));
        double i = scanner.nextDouble();
        double j = scanner.nextDouble();
        int f = scanner.nextInt();
        System.out.println(max(i,j,f));
    }


    /**
     * 打印数组
     * @param args
     */
    public static void main5(String[] args) {
        int[] array = {1,2,3,4};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(array));
    }


    /**
     * 汉诺塔问题
     * @param pos1
     * @param pos2
     */
    public static void move(char pos1,char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }
    /**
     * @param n:盘子个数
     * @param pos1:起始位置
     * @param pos2：中途位置
     * @param pos3：目的位置
     */
    public static void hanoi(int n,char pos1,char pos2,char pos3) {
        if (n == 1) {
            move(pos1,pos3);
            return;
        }
        hanoi(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoi(n-1,pos2,pos1,pos3);
    }
    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        hanoi(n,'A','B','C');
    }


    /**
     * 青蛙跳台阶问题
     * @param n
     * @return
     */
    public static int common(int n) {
        if (n == 1) {
            return 1;
        }else if(n == 2) {
            return 2;
        }
        return (common(n-1) + common(n-2));
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(common(n));
    }


    /**
     * 重载
     * 两个整数 和 三个小数之和
     * @param a
     * @param b
     * @return
     */
    public static int sum(int a, int b) {
        return (a + b);
    }
    public static double sum(double a,double b,double c) {
        return (a + b + c);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(sum(a,b));
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        System.out.println(sum(c,d,e));
    }



    public static void myToString(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            if(i != array.length-1) {
                ret += ",";
            }
        }
        ret += "]";
        System.out.println(ret);
    }
    public static void main(String[] args) {
        int[] array = {10,2,20,30,12};
        myToString(array);
    }
}
