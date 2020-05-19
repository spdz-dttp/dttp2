import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: 2020.5.17
 * @description:
 * @author: spdz
 * @create: 2020-05-16 22:37
 **/
public class TestMain {

    //杨辉三角
    public static List<List<Integer>> generate(int numRow) {
        List<List<Integer>> ret = new ArrayList<>();
        if (numRow == 0) {
            return ret;
        }
        List<Integer> oneRow = new ArrayList<>();
        ret.add(oneRow);
        ret.get(0).add(1);
        for (int i = 1; i < numRow; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            List<Integer> prevRow = new ArrayList<>();
            prevRow = ret.get(i-1);
            for (int j = 1; j < i; j++) {
                int x = prevRow.get(j-1);
                int y = prevRow.get(j);
                curRow.add(x + y);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRow = scanner.nextInt();
        System.out.println(generate(numRow));
        List<List<Integer>> ret = generate(numRow);
        for (List<Integer> tmp :ret) {
            System.out.println(tmp);
        }
    }
}
