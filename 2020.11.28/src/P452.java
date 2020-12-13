import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @program: 2020.11.28
 * @description: 迭代器 、比较器 的练习
 * @author: spdz
 * @create: 2020-11-28 18:19
 **/

public class P452 {

    static class Section implements Comparable<Section>{
        int low;
        int high;

        Section(int low,int high) {
            this.low = low;
            this.high = high;
        }

        Boolean inSection(int high) {
            return high >= this.low && high <= this.high;
        }

        @Override
        public boolean equals(Object obj) {
            Section section = (Section)obj;
            return section.low == this.low && section.high == this.high;
        }

        @Override
        public int compareTo(Section o) {
            return high - o.high;
        }
    }

    //用最小弓箭数引爆气球
    public static int findMinArrowShots(int[][] points) {
        PriorityQueue<Section> queue = new PriorityQueue<>();
        for (int[] point : points) {
            Section section = new Section(point[0],point[1]);
            queue.add(section);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Section minSection = queue.remove();
            count++;
            Iterator<Section> it = queue.iterator();
            while (it.hasNext()) {
                Section section = it.next();
                if (section.inSection(minSection.high)) {
                    it.remove();
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(P452.findMinArrowShots(arr));
    }
}
