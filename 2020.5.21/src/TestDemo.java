import java.util.Scanner;
import java.util.Stack;

/**
 * @program: 2020.5.21
 * @description:Stack练习
 * @author: spdz
 * @create: 2020-05-20 20:11
 **/
public class TestDemo {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    //判断左右括号是否匹配
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }else {
                if (stack.empty()) {
                    System.out.println("右括号多");
                    return false;
                }
                char ch2 = stack.peek();
                if (ch2 == '(' && s.charAt(i) == ')' || ch2 == '[' && s.charAt(i) == ']'
                        || ch2 == '{' && s.charAt(i) == '}') {
                    stack.pop();
                }else {
                    System.out.println("左右括号不匹配");
                    return false;
                }
            }
        }
        if (!stack.empty()) {
            System.out.println("左括号多");
            return false;
        }
        return true;
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(isValid(s));
        }

    }
}
