import java.util.Scanner;

/**
 * @program: 2020.11.26
 * @description: 泛型练习
 * @author: spdz
 * @create: 2020-11-26 22:57
 **/


//写一个泛型类，包含一个方法，该方法是找到数组当中的最大值
class Generic<T extends Comparable<T>> {
    public T maxNum(T[] arr) {
        T maxNum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxNum.compareTo(arr[i]) < 0) {
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
}

//类型推导 -》 根据实参的类型推导出形参的类型
class Generic2 {
    public static <T extends Comparable<T>> T maxNum(T[] arr) {
        T maxanum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxanum.compareTo(arr[i]) < 0) {
                maxanum = arr[i];
            }
        }
        return maxanum;
    }
}


public class TestDemo {

    public static void main3(String[] args) {
        Generic<Integer> generic = new Generic<>();
        Integer[] arr = {1,2,5,6,3,4,8,5,10,5};
        System.out.println(generic.maxNum(arr));
        Integer[] arr2 = {5,6,4,8,9,2,2,5,7,11};
        System.out.println(Generic2.maxNum(arr2));
    }

    //按字符串原有的字符顺序，输出字符集合，重复出现并靠后的字母不输出。
    public static String func1(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String str2 = stringBuffer.toString();
            if (!str2.contains(ch+"")) {
                stringBuffer.append(ch);
            }
        }
        return stringBuffer.toString();
    }

    //按字符串原有的字符顺序，输出字符集合，重复出现并靠后的字母不输出。
    public static String func2(String str) {
        StringBuffer s = new StringBuffer();
        for (char ch : str.toCharArray()) {
            String s1 = s.toString();
            if (!s1.contains(ch +"")){
                s.append(ch);
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(func1(str));
            System.out.println(func2(str));
        }
    }

    public static void main1(String[] args) {
        int n = 10;
        int i = (int)Math.sqrt(n);
        System.out.println(i);
    }
}
