import java.util.Arrays;

/**
 * @program: 2020.6.5
 * @description:
 * @author: spdz
 * @create: 2020-06-07 20:37
 **/
public class TestSort {

    /**
     * 非递归实现 归并排序
     */
    public static void mergeSort (int[] array) {
        for (int gap = 1; gap < array.length; gap*=2) {
            mergeNor(array,gap);
        }
    }

    public static void mergeNor(int[] array,int gap) {
        int[] ret = new int[array.length];
        int k = 0;//用来表示ret数组的下标
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < array.length ? s2+gap-1: array.length-1;

        //肯定是有两个归并段的
        while (s2 < array.length) {
            //对应位置比较
            while (s1 <= e1 && s2 <= e2) {
                if (array[s1] <= array[s2]) {
                    ret[k++] = array[s1++];
                }else {
                    ret[k++] = array[s2++];
                }
            }
            //判断谁没走完，把剩下的数放到ret数组中
            while (s1 <= e1) {
                ret[k++] = array[s1++];
            }
            while (s2 <= e2) {
                ret[k++] = array[s2++];
            }
            //重新确定 s1, e1, s2, e2
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < array.length ? s2+gap-1: array.length-1;
        }
        //判断是否有另外的归并段
        while (s1 <= array.length-1) {
            ret[k++] = array[s1++];
        }

        //将ret数组中的数放到array数组中
        for (int i = 0; i < ret.length; i++) {
            array[i] = ret[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12,5,9,34,6,8,33,56,89,0,7,4,22,55,77};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
