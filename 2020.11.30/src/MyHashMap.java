import java.util.*;

/**
 * @program: 2020.11.30
 * @description: 哈希表
 * @author: spdz
 * @create: 2020-11-30 19:21
 **/

/**
 * 哈希表
 *  当元素数量 > 房间数量时，冲突 便会发生
 *  解决冲突的方法：
 *      1.线性探测法
 *      2.链表法/哈希桶
 */

/**
 * 负载因子
 *  size/array.length ---size 链表长度，array.length 数组长度
 *  为了降低冲突率，一般规定 负载因子 不能超过某个值，所以数组要扩容
 *
 *  ArrayList 扩容 原因：顺序表放不下了
 *  哈希表 扩容 原因：为了降低冲突率
 */

//链表法/哈希桶 方法 哈希表
public class MyHashMap {
    // Entry 就是我们链表的结点。起名 Entry是为了模拟 Map.Entry
    public static class Entry {
        private String key;
        private Integer value;
        private Entry next;

        public Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }

    private Entry[] array;
    private int size;

    MyHashMap() {
        array = new Entry[16];
        size = 0;
    }

    //时间复杂度：O(1)
    public Integer get(String key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Entry cur = array[index];
        // 这里链表极短，遍历时间复杂度 O(1)
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    //寻找key值，没有，返回默认值
    //时间复杂度：O(1)
    public Integer getOrDefault(String key, Integer defaultValue) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Entry cur = array[index];
        while (cur != null) {
            if (key.equals(cur.key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return defaultValue;
    }

    //时间复杂度：O(1)
    public Integer put(String key, Integer value) {
        // 1. key 是什么类型？ String 类型（不是基本类型，都是引用类型）
        //    把一个对象（通过引用类型来表示） 变成 int 类型
        //    Ojbect 类是所有 java 类的祖先类，Object 的方法所有类都支持
        //    Object 中提供了 hashCode()
        int hash = key.hashCode();
        // 2. 刚才得到的 hash 值是一个合法的下标么？ [0, array.length)
        //    把 hash 变成一个合法的下标
        int index = hash % array.length;
        // Java 中如何做的：它的前提是：数组的长度一定是 2 的 n 次方
        /*
        int h = (hash >>> 16) ^ hash;
        int n = array.length;
        int index = h & (n - 1);
         */

        Entry current = array[index];
        while (current != null) {
            // 比较 key 和 current.key 是否相等
            if (key.equals(current.key)) {
                Integer oldValue = current.value;
                current.value = value;
                return oldValue;
            }

            current = current.next;
        }

        Entry node = new Entry(key, value);
        node.next = array[index];
        array[index] = node;
        size++;

        // 负载因子 不能 大于 0.75 ,大于，就扩容
        if(100 * size/array.length > 75) {
            resize();
        }

        return null;
    }

    //扩容
    private void resize() {
        Entry[] newArray = new Entry[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            for (Entry cur = array[i]; cur != null;cur = cur.next) {
                int hash = cur.key.hashCode();
                int index = hash % newArray.length;
                Entry entry = new Entry(cur.key,cur.value);
                entry.next = newArray[index];
                array[index] = entry;
            }
        }
        array = newArray;
    }

    //时间复杂度：O(1)
    public Integer remove(String key) {
        int hash = key.hashCode();
        int index = hash % array.length;

        Entry cur = array[index];
        Entry pre = null;
        while (cur != null) {
            if (key.equals(cur.key)) {
                Integer oldValue = cur.value;
                if (pre == null) {
                    array[index] = cur.next;
                }else {
                    pre.next = cur.next;
                }
                size--;
                return oldValue;
            }
            pre = cur;
            cur = cur.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //遍历key
    //时间复杂度：O(n)
    public Set<String> keySet() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            Entry cur = array[i];
            while (cur != null) {
                set.add(cur.key);
                cur = cur.next;
            }
        }
        return set;
    }

    //遍历value
    //时间复杂度：O(n)
    public Collection<Integer> values() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Entry cur = array[i];
            while (cur != null) {
                list.add(cur.value);
                cur = cur.next;
            }
        }
        return list;
    }

    //遍历 哈希表
    //时间复杂度：O(n)
    public Set<Entry> entrySet() {
        Set<Entry> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            Entry cur = array[i];
            while (cur != null) {
                set.add(cur);
                cur = cur.next;
            }
        }
        return set;
    }
}
