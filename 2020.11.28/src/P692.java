import java.util.*;

/**
 * @program: 2020.11.28
 * @description: 优先级队列，比较器练习
 * @author: spdz
 * @create: 2020-11-28 16:57
 **/

//前 k 个高频单词
public class P692 {
    public static List<String> topKFrequent(String[] words,int k) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (!hashMap.containsKey(word)){
                hashMap.put(word,1);
            }else {
                hashMap.put(word, hashMap.get(word) + 1);
            }
        }
        PriorityQueue<String> minQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (hashMap.get(o1) == hashMap.get(o2)) {
                    return o2.compareTo(o1);//单词有相同出现频率，按字母顺序排序
                }else {
                    return hashMap.get(o1) - hashMap.get(o2);
                }
            }
        });
        for (String word : hashMap.keySet()) {
            minQueue.add(word);
            while(minQueue.size() > k) {
                minQueue.poll();
            }
        }
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
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> list = new LinkedList<>();
        list = topKFrequent(words,k);
        System.out.println(list);
    }
}
