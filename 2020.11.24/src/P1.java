/**
 * @program: 2020.11.24
 * @description:语法
 * @author: spdz
 * @create: 2020-11-23 17:59
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

/**
 * static （与其所在类解绑）
 *      1.语法用法  一共五种
 *      修饰类、修饰方法、修饰属性----static 必须出现在顶级类内部
 *      修饰代码块
 *      静态导入时
 *
 *          静态导入：类分为两种，一种要实例化对象，一种是静态方法的合集
 *
 *      2.和对象解绑
 *      修饰类、方法、属性、代码块 的作用-----综合来看，static修饰什么，什么和对象解绑
 *          修饰属性 和对象解绑含义：普通属性 有一个隐含的对象 (this),static含义就是和对象解绑
 *                      静态属性没有（this）
 *          修饰方法 和对象解绑含义：普通方法 有一个隐含的对象 (this),static含义就是和对象解绑
 *  *                      静态方法没有（this）
 *                      调静态方法 不需要对象 就可以调（用类调就行），即不需要new 一个对象，
 *                      普通方法 必须要有一个对象
 *                     （static 不需要 new,凡是和对象有关系的方法/属性，都不应该使用static
 *                      写一个方法时，看这个方法 需不需要 这个方法所在类 的对象）
 *          修饰类（内部类） 和对象解绑含义： 普通内部类 默认有一个 外部类对象的引用（Outer.this）,
 *                      静态内部类 没有，他与外部类没有联系（与外部类解绑）,相当于写在外部的非静态类
 *          修饰代码块  和对象解绑含义： 与外部类没有联系
 *                      静态属性的初始化（语法位置/初始化顺序）---发生在类被加载的过程中（仅此一次）
 *                          有两种初始化方式 ：
 *                              1： static int a = 10;//变量中直接初始化
 *                              2： static int b;
 *                                  static{b = 20;}//放在静态代码块中初始化
 *                          初始化顺序：按书写顺序
 *                      属性的初始化（语法位置/初始化顺序）---发生在对象被实例化的过程中（运行中）（可发生多次）
 *                          有三种初始化方式 ：
 *                              1： int a = 10;//定义时
 *                              2： {a = 20;}//构造代码块
 *                              3： Person() {name = ...;}//构造方法
 *                          初始化顺序：定义时 和 构造代码块 地位平等（按顺序）
 *                                     构造方法地位低，最后执行
 *
 *
 *
 */

//静态导入 --- 以方法/属性为单位导入 （导入 Math 类的 abs 方法）
import static java.lang.Math.abs;
//普通导入 --- 以类为单位导入（导入 Math 类）
import java.lang.Math;

class Person {
    int a;
    static int count = 0;
    String name;

    Person(String name) {
        this.name = name;
    }

    /**
     *   相当于  static String getName(final Person this) {return name;}
     *   凡是没有 static 修饰的 默认都带有  final Person this（this ：当前对象的引用）
     *   当你要用 一个非静态属性时，必须传入一个对象（即 new 一个对象）
     */
    String getName() {
        return name;
    }

    /**
     *   静态 不需要 this （this : 当前对象的引用） ，给了也可以
     *   所以 引用 p1 调用静态属性 报警告，但能用
     */
    static int getCount() {
        return count;
    }

    /**
     * 相当于 static void method(final Person this) { }
     */
    void method() {
        a = 20; //相当于 this.a = 20;
    }

    static void staticMethod() {
        /**
         *  a = 10;  错的  相当于 this.a = 10; ,但静态方法中没有 this ,所以错
         *  method();  错的  相当于 this.method() ,但静态方法中没有 this ,所以错
         *  即 静态中不能访问 非静态属性
         *  凡是 访问某个对象属性/调用普通方法，都不用 static 修饰
         */

    }


}

public class P1 {
    //下面的用法，只能出现在顶级类内部

    //静态内部类
    static class StaticInnerClass {}

    //静态方法
    static void staticMethod() {}

    //静态属性
    static int staticField;

    //静态代码块
    static {}

    public static void main1(String[] args) {
        Math.abs(-1);//普通导入，要用 类名.静态方法  abs 是静态方法
        abs(-1);//静态导入后，可以直接使用

        /**
         *  aa bb 都在new 的对象中
         *  静态属性（count）保存在类的内部(方法区) 所有对象共用 同一份
         */
        Person p1 = new Person("aa");
        Person p2 = new Person("bb");
        System.out.println(p1.count);//引用 p1 调用静态属性 报警告，但能用；
        System.out.println(Person.count);//通常用 类名 Person 调用静态属性

    }

    public static void main(String[] args) {
        Person p1 = new Person("aa");

        /**
         *   相当于  String str = Person.getName(p1);
         *   所以非静态方法必须 new 一个对象，否则没有 p1
         */
        String str = p1.getName();
        System.out.println(str);

        int i = Person.getCount();
        System.out.println(i);
    }

}
