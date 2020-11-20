import java.util.*;

/**
 * @program: 2020.6.12
 * @description:
 * @author: spdz
 * @create: 2020-06-17 22:55
 **/


public class TestDemo2 {

    //统计重复数字及其出现次数
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

//        for (int i = 0; i < 10_0000; i++) {
//            list.add(random.nextInt(6000));
//        }

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);

        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer key : list) {
            if (map.get(key) == null) {
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }

        for (HashMap.Entry<Integer,Integer> entry :map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

    }

    public static void main2(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(6000));
        }

        //请去掉重复的数
        HashSet<Integer> set = new HashSet<>();
        for (Integer val :list) {
            set.add(val);
        }
        System.out.println(set);
    }

    //找出10_0000 个数中，第一个重复的数
    public static int repeat(ArrayList<Integer> list) {
        Set<Integer> set = new HashSet<>();
        int t = 0;
        for (Integer i : list) {
            if (set.contains(i)) {
                return i;
            }else {
                set.add(i);
            }
        }
        return -1;
    }

    public static void main1(String[] args) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();

//        for (int i = 0; i < 10_0000; i++) {
//            list.add(random.nextInt(6000));
//        }

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);

        System.out.println(repeat(list));
    }

}
