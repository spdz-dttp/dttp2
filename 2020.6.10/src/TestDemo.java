import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * @program: 2020.6.10
 * @description:练习
 * @author: spdz
 * @create: 2020-06-16 15:08
 **/
public class TestDemo {

    //颜色分类
    public static void sortColors(int[] array) {
        int p1 = -1;
        int p2 = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 2) {
                p2++;
                swap(array,i,p2);
                if (array[p2] < 1) {
                    p1++;
                    swap(array,p1,p2);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {1,0,0,1,1,2,2,0,0};
        sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    public static int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }

    //车队
    public static int carFleet(int target, int[] position, int[] speed) {

        int[][] ret = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            ret[i][0] = position[i];
            ret[i][1] = speed[i];
        }

        //按起始位置从小到大排序
//        Arrays.sort(ret, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });

        Arrays.sort(ret,(o1,o2) -> compare(o1,o2));

        //离得近，所需时间长，和离的远，所需时间短的车辆是一个车队的
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < ret.length; i++) {
            double time = (double) (target - ret[i][0]) / ret[i][1];
            while (!stack.isEmpty() && time >= stack.peek()) {
                stack.pop();
            }
            stack.push(time);
        }
        return stack.size();
    }

    public static void main1(String[] args) {
        int a = 10;
        int b = 5;
        int c= 3;
        double time1 = (a-b)/c;
        System.out.println(time1);//1.0
        double time2 = (double) (a-b)/c;
        System.out.println(time2);//1.6666666666666667
        double d = 3.0;
        double time3 = (a-b)/d;
        System.out.println(time3);//1.6666666666666667

        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(carFleet(target, position, speed));//3

    }

}
