import java.util.ArrayList;

/**
 * @program: 2020.6.11
 * @description:
 * @author: spdz
 * @create: 2020-06-17 15:22
 **/

/**
 * 通配符 : 也是一种泛型
 * 通配符一般用于读取  add(?)
 * 泛型一般用于写入   add(T)
 *
 * 通配符既有上界 ，也有下界
 *  <? extends 上界>    ? 一定是上界的子类
 *  <? super 下界>    ? 一定是下界的父类
 */

/**
 *  泛型中的父子类型
 *  Object 是 所有的 父类
 *  但 MyArrayList<Object> 不是 MyArrayList<Integer> 的父类
 *          因为 泛型 中 <> 里的东西 不参与类型的组成
 *  需要通过 通配符 来确定父子类型
 *          MyArrayList<？> 是 MyArrayList<？ extends Number> 的父类型
 *          MyArrayList<？ extends Number> 是 MyArrayList<Integer> 的父类型
 */

//一个通用方法，打印集合中所有元素
class GenerList {
    public static <T> void printList(ArrayList<T> list) {
        for (T ret:list) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

    //<?> : 通配符
    public static void printList2(ArrayList<?> list) {
        for (Object ret:list) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }
}
public class TestDemo4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        GenerList.printList(list);
        GenerList.printList2(list);
    }
}
