/**
 * @program: 2020.11.25
 * @description: 数据结构1
 * @author: spdz
 * @create: 2020-11-25 17:49
 **/

/**
 * 评价体系----复杂度
 *      复杂度：评价 随着 数据规模的增加，算法的变化趋势
 *      例：冒泡排序 时间复杂度 O（n^2）,
 *          对 500 个数排序，用时 3 s
 *          对 2000 个数排序，用时 ？ s
 *          500 -> 2000 扩大了 4 倍
 *          时间复杂度 O（n^2）,所以，运算时间扩大 4^2 = 16 倍
 *          所以用时 3*16 = 48 s
 */

/**
 * 通用三种组织方式
 *  1.线性的（只有线性有下标）
 *  2.树型的
 *  3.图形的
 */

/**
 * 三大类专用数据结构
 *  1. FIFO/FILO---栈/队列
 *  2. 找最值---堆（Heap）
 *  3. 搜索---搜索树（平衡搜索树）/哈希表
 *      1.只处理内存数据---二叉平衡搜索树
 *          1. AVL树     2.红黑树
 *      2.主要处理硬盘数据---B-树系列
 *          应用于数据库
 */

/**
 * 算法
 *  1.排序
 *  2.搜索算法（二分查找）遍历查找（算法同遍历）
 */

/**
 * 树形遍历
 *  DFS（深搜）：前/中/后序 ---- 栈（递归）（递归是对栈的特殊运用）
 *  BFS（广搜）：层序 ---- 队列
 */

/**
 * 只有线性组织方式，可以一一遍历（顺序表--ArrayList, 链表--LinkedList，栈--Stack，队列--Queue）
 * 没有下标的，可以用迭代器( Set, Map)
 * 迭代器说白了，就是从容器里把东西取出来
 */

import java.util.*;

/**
 * interface Iterator {
 *     boolean hasNext();
 *     元素 next();
 *     void remove(); //在遍历的同时如果直接修改容器结构，是危险的,要用 迭代器 删
 * }
 */

/**
 * PriorityQueue<E> 优先级队列，
 *  默认是小根堆（从小到大排序）
 *  底层是堆，E 元素必须具备比较大小的能力
 *
 *  PriorityQueue<E>();  E 元素一定是 Comparable , 否则会有 ClassCastException  (转型异常)
 *  PriorityQueue<E>(Comparator<E> comparator);  E 元素不是 Comparable 时，用这个构造方法（自定义一个比较方法）
 */

public class P1 {

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

    //单向队列
    public static void main3(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("hello");
        queue.add("world");
        queue.add("你好");
        queue.add("世界");

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    //双向队列
    public static void main4(String[] args) {

        //当成 单向队列 使用
        Deque<String> queue = new LinkedList<>();
        queue.add("hello");
        queue.add("world");
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        //当成 栈 使用
        Deque<String> stack = new LinkedList<>();
        stack.push("hello");
        stack.push("world");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    //栈
    public static void main5(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

