
/**
 * @program: 2020.5.20
 * @description:循环队列
 * @author: spdz
 * @create: 2020-05-20 08:40
 **/
public class TestDemo {

    public static void main(String[] args) {
        MyCircularQueue ret = new MyCircularQueue(4);
        System.out.println(ret.isEmpty());
        System.out.println(ret.enQueue(1));
        System.out.println(ret.enQueue(2));
        System.out.println(ret.enQueue(3));
        System.out.println(ret.enQueue(4));
        System.out.println(ret.isFull());
        System.out.println(ret.Front());
        System.out.println(ret.Rear());
        System.out.println(ret.deQueue());
        System.out.println(ret.deQueue());
        ret.enQueue(5);
        ret.enQueue(6);
        System.out.println(ret.Front());
        System.out.println(ret.Rear());
        System.out.println(ret.elem[0]);
        System.out.println(ret.elem[1]);

    }

    public static void main2(String[] args) {
        int b = 1;
        double a = 1;
        double c = b/a;
        System.out.println(c);
    }

    // 100以内素数
    public static void main1(String[] args) {
        int count = 0;
        for (int i = 2; i < 100; i++) {
            int j = 2;
            for (; j <= Math.sqrt(i); j++) {
                if (i%j == 0) {
                    break;
                }
            }
            if (j > Math.sqrt(i)){
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
