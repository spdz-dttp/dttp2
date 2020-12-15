/**
 * @program: 2020.11.29
 * @description: 数据结构3
 * @author: spdz
 * @create: 2020-11-29 14:39
 **/

import java.util.*;

/**
 * Java中  只有线性表才有排序的意义
 *      List 可以被排序（顺序表，链表）（链表排序遍历方法不同，不常用）
 *      数组可以排序
 *          static Arrays.sort  ---针对数组排序
 *          static Collections.sort  ----针对 List 排序
 *          List.sort  ---针对 List 对象
 *
 *          要排序 的类型 必须有 Comparable 和 Comparator 出现
 *
 */

public class P1 {

    public static void main(String[] args) {
        int[] arr = {4,2,5,3,1,6};
        System.out.println(Arrays.toString(arr));
        //Sort.bubbleSort(arr);
        //Sort.insertSort(arr);
        //Sort.quickSort(arr);
        Sort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //数组中的最长连续子序列
    public static int MLS1(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int e : arr) {
            set.add(e);
        }
        int[] arr2 = new int[set.size()];
        int i = 0;
        for (int e : set) {
            arr2[i++] = e;
        }
        Arrays.sort(arr2);
        int maxcount = 1;
        int count = 1;
        for (int j = 0; j < arr2.length-1; j++) {
            if (arr2[j] == arr2[j+1] - 1) {
                count++;
                if (count > maxcount) {
                    maxcount = count;
                }
            }else {
                count = 1;
            }
        }
        return maxcount;
    }

    public static int MLS(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list = uniqueSort(arr);
        int count = 1;
        int maxcount = 1;
        for (int i = 1; i < list.size(); i++) {
            int pre = list.get(i-1);
            int cur = list.get(i);
            if (pre == cur-1) {
                count++;
                if (count > maxcount) {
                    maxcount = count;
                }
            }else {
                count = 1;
            }
        }
        return maxcount;
    }

    //去重排序
    private static List<Integer> uniqueSort(int[] arr) {
        //set 去重
        Set<Integer> set = new HashSet<>();
        for (int e : arr) {
            set.add(e);
        }
        //排序
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);//static Collections.sort  ----针对 List 排序
        return list;
    }

    public static void main1(String[] args) {
        int[] arr = {100,4,200,1,3,2};
        System.out.println(MLS(arr));
    }
}
