import java.util.*;

/**
 * @program: 2020.12.1
 * @description: 随机数、迭代器
 * @author: spdz
 * @create: 2020-12-02 19:36
 **/
public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            int e = random.nextInt(20);
            System.out.println(e);
            set.add(e);
        }
        System.out.println(set);
        System.out.println(set.size());

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int n = it.next();
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
