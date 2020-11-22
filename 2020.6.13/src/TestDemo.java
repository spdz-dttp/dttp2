import java.util.*;

/**
 * @program: 2020.6.13
 * @description:set,map练习
 * @author: spdz
 * @create: 2020-06-18 20:52
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

    //前 k 个高频单词
    public static List<String> topKFrequent(String[] words,int k) {
        // 建立哈希表统计单词频率
        HashMap<String,Integer> map = new HashMap<>();
        for (String key : words) {
            if (map.get(key) == null) {
                map.put(key,1);
            }else {
                Integer val = map.get(key);
                map.put(key,val+1);
            }
        }
        // 小根堆
        PriorityQueue<String> minQueue = new PriorityQueue<>(new Comparator<String>() {
            public int compare(String o1,String o2) {
                Integer o1val = map.get(o1);
                Integer o2val = map.get(o2);
                if (o1val == o2val) {
                    return o2.compareTo(o1);
                }else {
                    return o1val-o2val;
                }
            }
        });
        for (String word : map.keySet()) {
            minQueue.offer(word);
            if (minQueue.size() > k) {
                minQueue.poll();
            }
        }
        //用栈逆序输出
        Stack<String> stack = new Stack<>();
        while (!minQueue.isEmpty()) {
            stack.push(minQueue.poll());
        }
        List<String> list = new LinkedList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"the", "day", "is", "sunny",
                "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        System.out.println(topKFrequent(words, k));

    }

    //键盘上坏掉的键
    public static void badKey(String expected, String actual) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char i : actual.toUpperCase().toCharArray()) {
            hashSet.add(i);
        }
        HashSet<Character> badKey = new HashSet<>();
        for (char i : expected.toUpperCase().toCharArray()) {
            if (!hashSet.contains(i)) {
                if (!badKey.contains(i)) {
                    badKey.add(i);
                    System.out.print(i);
                }
            }
        }
        System.out.println();
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();
        badKey(expected,actual);
    }

    //石头（S）中的宝石（J）数
    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> hashSet = new HashSet<>();
        char[] arr1 = J.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            hashSet.add(arr1[i]);
        }
        int count = 0;
        char[] arr2 = S.toCharArray();
        for (int i = 0; i < arr2.length; i++) {
            if (hashSet.contains(arr2[i])) {
                count++;
            }
        }
        return count;
    }

    public static void main2(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    //深拷贝复制带随机指针的链表
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        HashMap<Node,Node> hashMap = new HashMap<>();
        while(cur != null) {
            hashMap.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }

    //唯一只出现了一次的数。
    public static int singleNumber1(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret ^= nums[i];
        }
        return ret;
    }

    public static int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            }else  {
                hashSet.remove(nums[i]);
            }
        }
        Iterator<Integer> it = hashSet.iterator();
        return it.next();
    }

    public static void main1(String[] args) {
        int[] array = {4,1,2,1,2,4,5,6,6};
        System.out.println(singleNumber(array));//5
    }
}
