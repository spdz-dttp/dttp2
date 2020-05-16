import demo1.MyArrayList;

import java.util.Scanner;

/**
 * @program: 2020.5.14
 * @description:泛型  <>
 *     泛型方法：后面讲
 *     泛型类 的定义：
 *          1、尖括号 <> 是泛型的标志
 *          2、<T> 中 T 是类型变量 ，变量名 一般要 大写
 *          3、T 在定义时是形参 代表最后的传入类型，现在还不知道
 *
 * @author: spdz
 * @create: 2020-05-14 10:36
 **/

class Person {

}

public class TestDemo {

    public static void main4(String[] args) {
        Person person = new Person();
        //因为没有 重写 toString（）方法
        System.out.println(person);//输出的是 类型（这里是Person） @ 地址
        System.out.println("===============================");
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        //泛型类型的 参数（这里是 <Integer>），不参与类型的组成
        System.out.println(myArrayList);//输出的是 类型（这里是MyArrayList） @ 地址
                                        //而不是 类型（MyArrayList<Integer>） @ 地址
    }

    public static void main3(String[] args) {

        //简单类型不能做为泛型类型的参数
        //MyArrayList<Int> myArrayList1 = new MyArrayList<>();// error  泛型 <Int>

        //指定泛型类型为 Integer
        MyArrayList<Integer> myArrayList = new MyArrayList<>();//泛型 <Integer>
        //myArrayList.addLast("hello");//error 可以自动进行类型的检查（这里是String类型）
        myArrayList.addLast(2);
        myArrayList.addLast(3);

        int val = (int)myArrayList.getval(1);
        System.out.println(val);

        MyArrayList<String> myArrayList2 = new MyArrayList<>();//泛型 <>
        myArrayList2.addLast("hello");
        myArrayList2.addLast("world");
        String val2 = (String)myArrayList2.getval(1);
        System.out.println(val2);
    }


    public static void main2(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.addLast("hello");
        myArrayList.addLast(2);

        int val = (int)myArrayList.getval(1);
        System.out.println(val);
    }

    //按字符串原有的字符顺序，输出字符集合，重复出现并靠后的字母不输出。
    public static String func1(String str) {
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String str2 = ret.toString();
            if (!str2.contains(ch + "")){
                ret.append(ch);
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(func1(str));
        }
    }

}
