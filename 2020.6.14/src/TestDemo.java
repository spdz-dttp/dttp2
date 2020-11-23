import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @program: 2020.6.14
 * @description:
 * @author: spdz
 * @create: 2020-07-08 14:09
 **/

class Node {
    int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
    }
}

public class TestDemo {
    

    //键盘上坏了的键
    public static void badKey(String expected , String actual) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char i : actual.toUpperCase().toCharArray()) {
            hashSet.add(i);
        }
        HashSet<Character> badKey = new HashSet<>();
        for (char j : expected.toUpperCase().toCharArray()) {
            if (!hashSet.contains(j)) {
                if (!badKey.contains(j)) {
                    badKey.add(j);
                    System.out.print(j);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "7_This_is_a_test";
        String str2 = "_hs_s_a_es";
        badKey(str1,str2);
    }

    //石头（S）中的宝石（J）数
    public static int numJewelsInStones(String J , String S) {
        HashSet<Character> hashSet = new HashSet<>();
        char[] arr1 = J.toCharArray();
        for (char j : arr1) {
            hashSet.add(j);
        }
        int num = 0;
        char[] arr2 = S.toCharArray();
        for (char s : arr2) {
            if (hashSet.contains(s)) {
                num++;
            }
        }
        return num;
    }

    //深拷贝复制带随机指针的链表
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        HashMap<Node,Node> hashMap = new HashMap<>();
        while (cur != null) {
            hashMap.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while ( cur!= null) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    //唯一只出现了一次的数。
    public static int singleNumber2(int[] arr) {
        int n = 0;
        for(int i : arr) {
            n ^= i;
        }
        return n;
    }

    public static int singleNumber(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i :arr) {
            if (!hashSet.contains(i)) {
                hashSet.add(i);
            }else {
                hashSet.remove(i);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }

    public static void main1(String[] args) {
        int[] arr = {4,1,2,1,2};
        System.out.println(singleNumber(arr));
    }
}
