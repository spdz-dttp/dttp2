/**
 * @program: 2020.5.22
 * @description:
 * @author: spdz
 * @create: 2020-05-21 08:15
 **/

public class TestDemo {
    public static void main(String[] args) {
        MyCircularDeque ret = new MyCircularDeque(4);
        System.out.println(ret.insertFront(1));
        System.out.println(ret.insertFront(2));
        System.out.println(ret.insertFront(3));
        System.out.println(ret.insertLast(4));
        System.out.println(ret.getFront());
        System.out.println(ret.getRear());
        System.out.println(ret.deleteFront());
        System.out.println(ret.deleteLast());
        System.out.println(ret.getFront());
        System.out.println(ret.getRear());
    }
}
