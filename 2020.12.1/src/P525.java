import java.util.HashMap;
import java.util.Map;

/**
 * @program: 2020.12.1
 * @description: 哈希表练习
 * @author: spdz
 * @create: 2020-12-01 23:08
 **/


public class P525 {

    //给定一个二进制数组, 找到含有相同数量的 0 和 1 的最长连续子数组的长度
    public static int findMaxLength(int[] nums) {
        //Map<0和1的数量差，最早出现的位置（下标）>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLength = 0;
        int countDiff = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n == 0) {
                countDiff++;
            } else {
                countDiff--;
            }

            Integer index = map.get(countDiff);
            if (index != null) {
                int length = i - index;
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                map.put(countDiff, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,1,1,0,0,1,0,1,1,1,0,0};
        System.out.println(findMaxLength(arr));
    }
}
