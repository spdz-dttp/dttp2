package demo1;

/**
 * @program: 2020.5.14
 * @description:顺序表
 * @author: spdz
 * @create: 2020-05-14 19:15
 **/

/**
 * <T>：只是一个占位符，表示当前类是一个泛型类
 * 泛型的意义：
 * 1、可以自动进行类型的检查
 * 2、可以自动进行类型的转换
 *
 * 面试问题：泛型到底是怎么编译的？
 *          擦除机制
 *  重要： 泛型只是编译时期的一种机制 --》擦除机制  在运行时，不存在泛型这种说法
 *  所有的处理均在编译阶段已经处理。
 *
 *  擦除机制 ： 在编译的时候，泛型类型就被擦除为 Object了  不是替换
 *
 * @param <T>
 *
 *  泛型的坑：
 *      1、不能 new泛型类型的数组 。 T a = new T[10];
 *      2、简单类型 不能做为 泛型类型的参数，泛型类型的参数 必须是 引用类型
 *          //MyArrayList<Int> myArrayList1 = new MyArrayList<>();//error
 *      3、泛型类型的参数（这里是 <Integer>），不参与类型的组成
 *          MyArrayList<Integer> myArrayList = new MyArrayList<>();
 */

//泛型类
public class MyArrayList<T> {


    //Object 是所有类的父类，这里用Object可以使 顺序表可以放任何类型
    //public Object[] elem;

    public T[] elem;//泛型
    public int usedSize;

    public MyArrayList() {
        this.elem = (T[])new Object [10];//不能 new泛型类型的数组 。 T a = new T[10];
        this.usedSize = 0;
    }

    //默认放到数组最后
    public void addLast (T val) {
        this.elem[this.usedSize] = val;
        this.usedSize++;
    }

    //pos位置的值
    public T getval(int pos) {
        return this.elem[pos];
    }
}
