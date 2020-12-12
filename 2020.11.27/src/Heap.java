/**
 * @program: 2020.11.27
 * @description: 数据结构2
 * @author: spdz
 * @create: 2020-11-28 18:27
 **/

/**
 * 堆（Heap) + 优先级队列（PriorityQueue)
 *  1.作用：在一组数据中找最值（一般找多组最值）
 *  2.什么是堆：完全二叉树 + 数组形式 + 大堆/小堆性质
 *      左孩子结点 = 父亲结点 * 2 + 1；
 *      有孩子结点 = 父亲结点 * 2 + 2；
 *      父亲节点 = （孩子结点 - 1）/2；
 *  3.重要操作
 *      向下调整
 *      建堆
 */

/**
 * 堆：一颗 顺序存储 的完全二叉树 (数组中 存储的是 这颗二叉树的 层序遍历)
 *      大堆（大根堆）：根节点的值 > 左右孩子节点的值
 *      小堆（小根堆）：根节点的值 < 左右孩子节点的值
 */

//堆---大堆
public class Heap {

    //堆向下调整 为 大根堆
    //时间复杂度: O(log(2)n)
    public static void adjustDown(long[] array,int size,int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index +2;

            if(leftIndex >= size) {
                return;
            } 

            int maxIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] > array[leftIndex]){
                maxIndex = rightIndex;
            }

            if (array[index] >= array[maxIndex]) {
                return;
            }

            swap(array, index, maxIndex);
            index = maxIndex;
        }
    }

    private static void swap(long[] array, int index, int maxIndex) {

        long t = array[index];
        array[index] = array[maxIndex];
        array[maxIndex] = t;
    }

    //建堆
    public static void createHeap(long[] array, int size) {
        int lastIndex = size - 1;
        int lastParentIndex = (lastIndex-1)/2;

        for (int i = lastParentIndex; i >= 0; i--) {
            adjustDown(array,size,i);
        }
    }

}
