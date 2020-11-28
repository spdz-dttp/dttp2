package IteratorDemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: 2020.7.18
 * @description: 迭代器
 * @author: spdz
 * @create: 2020-11-27 16:52
 **/

/**
 * 通用三种组织方式
 *  1.线性的（只有线性有下标）
 *  2.树型的
 *  3.图形的
 */

/**
 * 只有线性组织方式有下标，可以一一遍历（顺序表--ArrayList,  链表--LinkedList, 栈--Stack）
 * 没有下标的，可以用迭代器(队列--Queue, Set, Map)
 * 迭代器说白了，就是从容器里把东西取出来
 */

/**
 * interface Iterator {
 *     boolean hasNext();
 *     元素 next();
 *     void remove(); //在遍历的同时如果直接修改容器结构，是危险的,要用 迭代器 删
 * }
 */

public class Main {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("word");
        set.add("你好");
        set.add("世界");

        //迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            //set.remove(element);//遍历的同时，删除 会报异常
            iterator.remove();//正确，要用 迭代器 删


        }//可以缩写成 foreach

        //这里 foreach 本质上是系统帮你进行了迭代器的工作
        for (String element :set) {
            System.out.println(element);
            //set.remove(element);//遍历的同时，删除 会报异常
        }

    }
}
