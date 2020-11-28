/**
 * @program: 2020.7.18
 * @description:
 * @author: spdz
 * @create: 2020-07-20 20:40
 **/
public class TestDemo {

    //字符串中的第一个唯一字符
    public static int firstUniqChar(String s) {

        for (int i = 0; i < s.length(); i++) {
            int first = s.indexOf(s.charAt(i));
            int last = s.lastIndexOf(s.charAt(i));
            if (first == last) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
