/**
 * @program: 2020.11.13
 * @description:数据类型 ,异常
 * @author: spdz
 * @create: 2020-11-13 18:11
 **/

/**
 * 数据类型：
 *   1.基本类型（8 种）
 *          整型：int 4个字节
 *          短整型：short 2个字节
 *          长整型： long 8个字节
 *          字节： byte 1个字节
 *          字符型：char 2个字节  默认值‘\u0000’
 *          单精度： float 4个字节
 *          双精度 浮点型： double 8个字节
 *          布尔类型：Bollean 没有明确的大小  默认值false
 *          （隐式类型转换：把 小类型 给 大类型
 *            显式类型转换：把大类型给小类型 需要  强制类型转换）
 *   2.引用类型（3 种）
 *          类类型引用  例：String s = ...;
 *          接口类型引用  例：List list = ...;
 *          数组类型引用  例：int[] a = ...;
 *   3.变量的3 种形态
 *          1.局部变量 （在方法中） 栈中
 *          2.属性（在对象中） 堆中
 *          3.静态属性 （在类中） 方法区
 *
 */

class Person implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TestDemo {


    public static void main3(String[] args) {
        int[] array = {1,2,3};
        try {
            System.out.println(array[4]);
            System.out.println("www");//不会被执行
        } catch (ArrayIndexOutOfBoundsException i) {
            i.printStackTrace();
            System.out.println("捕获到了数组越界异常");
        }//当程序抛出异常时，由catch进行捕获，程序自己处理异常，程序会继续向下执行
        //这里是 数组下标越界异常 catch中要用 ArrayIndexOutOfBoundsException类
        System.out.println("hello");//会执行这步

    }

    public static void main2(String[] args) {
        Person person = new Person();
        try {
            Person person2 = (Person) person.clone();
            System.out.println("person2");
        } catch (CloneNotSupportedException e) {

            e.printStackTrace();
        }

    }

    //throws 声明可能出现的异常
    public static int divide(int x,int y) throws ArithmeticException{
        if(y == 0){
            throw new ArithmeticException("y == 0");
        }
        return x/y;
    }

    /**
     * 抛出异常: throw  一般抛出某个你想抛出的异常（还可以抛出自定义异常）
     * @param args
     */

    public static void main1(String[] args) {
        try {
            int ret = divide(20,0);
            System.out.println(ret);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("hhhh");
        }
        System.out.println("继续执行");
    }
}
