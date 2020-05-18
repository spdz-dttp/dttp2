import java.util.*;

/**
 * @program: 2020.5.16
 * @description:List
 * @author: spdz
 * @create: 2020-05-15 20:15
 **/
public class TestMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add(0,"abc");
        System.out.println(list);

        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("bit");

        /**
         * addAll(Collection<? extends E> c);
         *  ？ 是 通配符
         *  1、实现了Collection接口
         *  2、类型 是 E的子类或本身
          */
        list.addAll(list1);
        System.out.println(list);

        //删除元素
        String ret = list.remove(0);
        System.out.println(ret);
        System.out.println(list);

        //删除元素
        list.remove("bit");
        System.out.println(list);

        System.out.println("=======get======");
        //获取下标元素
        ret = list.get(0);
        System.out.println(ret);

        System.out.println("=======set======");
        //更新
        list.set(0,"hhhh");
        System.out.println(list);

        System.out.println("=======contains=======");
        //是否包含
        System.out.println(list.contains("java"));

        System.out.println("======indexOf======");
        //返回 第一个 某元素 所在的下标
        System.out.println(list.indexOf("hhhh"));
        System.out.println(list.indexOf("hhhh1"));

        //返回 最后一个 某元素 所在的下标
        list.add("hhhh");
        System.out.println(list.lastIndexOf("hhhh"));

        System.out.println("=======subList========");
        //截取一部分 (浅拷贝)
        List<String> ret2 = list.subList(0,2);
        System.out.println(ret2);
        ret2.set(0,"spdz");
        System.out.println(ret2);
        System.out.println(list);

        //清空
        list.clear();
        System.out.println(list);

    }
}
