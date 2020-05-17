import java.util.Scanner;

/**
 * @program: 2020.5.15
 * @description: 字符串练习
 * @author: spdz
 * @create: 2020-05-14 23:20
 **/
public class TestDemo {

    private static void testMethod(){
        System.out.println("testMethod");

    }

    public static void main(String[] args) {
        ((TestDemo)null).testMethod();

    }

    //截取
    public static void main2(String[] args) {
        String str1 = "ababcabcd";

        String ret = str1.substring(1);
        System.out.println(ret);

        String ret2 = str1.substring(1,7);
        System.out.println(ret2);
    }

    //实现方法 split 分割 字符串
    public static String[] split(String str,String str1) {
        //str1出现次数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str1.equals(ch + "")) {
                count++;
            }
        }
        int m = 0;
        String str3 = str;
        String[] strings = new String[count+1];
        for (int i = 0; i < count; i++) {
            int n = 0;
            int a = str3.indexOf(str1);
            String str2 = str3.substring(n,a);
            n = a + 1;
            str3 = str3.substring(n);
            strings[m] = str2;
            m++;
        }
        strings[m] = str3;
        return strings;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String str1 = scanner.nextLine();

        String[] str2 = split(str, str1);
        for (String str3:str2) {
            System.out.println(str3);
        }
    }
}
