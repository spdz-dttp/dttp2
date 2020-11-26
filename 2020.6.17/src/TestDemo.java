import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: 2020.6.17
 * @description:
 * @author: spdz
 * @create: 2020-07-17 21:22
 **/
public class TestDemo {

    //两个数组的交集1(输出结果中的每个元素一定是唯一的)
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            if (set1.contains(n)) {
                set2.add(n);
            }
        }
        int[] arr = new int[set2.size()];
        int i = 0;
        for (int n : set2) {
            arr[i] = n;
            i++;
        }
        return arr;
    }

    //两个数组的交集2(输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致)
    public static int[] intersect(int[] num1, int[] num2) {
        if (num1.length > num2.length) {
            intersect(num2, num1);
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int n : num1) {
            if (!hashMap.containsKey(n)) {
                hashMap.put(n,1);
            }else {
                int count = hashMap.get(n);
                hashMap.put(n,count+1);
            }
        }
        int[] arr = new int[num1.length];
        int i = 0;
        for (int n : num2) {
            if (hashMap.containsKey(n) && hashMap.get(n) > 0) {
                arr[i] = n;
                i++;
                int count = hashMap.get(n);
                hashMap.put(n,count-1);
            }
        }
        return Arrays.copyOf(arr,i);
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(intersect(num1, num2)));//2,2
        System.out.println(Arrays.toString(intersection(num1, num2)));//2
    }

    //同构字符串
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))){
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        String s1 = "egg";
        String t1 = "add";
        System.out.println(isIsomorphic(s1, t1));//true
        String s2 = "foo";
        String t2 = "bar";
        System.out.println(isIsomorphic(s2, t2));//false
        String s3 = "paper";
        String t3 = "title";
        System.out.println(isIsomorphic(s3, t3));//true
    }
}
