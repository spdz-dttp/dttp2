import java.util.*;

/**
 * @program: 2020.6.12
 * @description:Set ,Map
 * @author: spdz
 * @create: 2020-06-17 18:47
 **/


public class TestDemo {

    //// Set 的核心操作是 key 是否存在（相当于集合），key 不能重复
    public static void main2(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(3);
        set.add(2);
        set.add(10);
        System.out.println(set);

        Iterator<Integer> it = set.iterator();//迭代器
        //判断 it 是否有下一个
        while (it.hasNext()) {
            System.out.println(it.next());
            //打印 it 的下一个，并且 it 向后走一步
        }
    }

    // Map 的核心操作是 通过 key 来获取 value 值
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"caocao");
        map.put(2,"zhangfei");
        map.put(3,"guanyu");
        System.out.println(map);

        //map 的三种遍历方法
        //1、entrySet()   效率高
        for (Map.Entry<Integer,String> entry :map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        //2、普通使用
        for (Integer key:map.keySet()) {
            System.out.println(key + "->" + map.get(key));
        }

        //3、Iterator迭代器
        Iterator<Map.Entry<Integer,String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,String> entry = it.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

    }

}
