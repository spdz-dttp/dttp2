import java.util.Stack;

/**
 * @program: 2020.5.21
 * @description:
 * @author: spdz
 * @create: 2020-05-20 22:01
 **/

//获取栈中的最小值
public class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> stack2;

    public MinStack() {
        this.stack = new Stack<>();
        this.stack2 = new Stack<>();
    }

    //入栈
    public void push(int x) {
        this.stack.add(x);
        if (this.stack2.empty()) {
            this.stack2.add(x);
        }else {
            if (x <= this.stack2.peek()) {
                this.stack2.add(x);
            }
        }
    }

    //出栈
    public void pop() {
        if (this.stack.empty()) {
            return;
        }
        int i = this.stack.pop();
        if (i == this.stack2.peek()) {
            this.stack2.pop();
        }
    }

    //栈顶元素
    public int top() {
        if (this.stack.empty()) {
            throw new RuntimeException("空栈!");
        }
        return this.stack.peek();
    }

    //栈中最小值
    public int getMin() {
        if (this.stack.empty()) {
            throw new RuntimeException("空栈!");
        }
        return this.stack2.peek();
    }
}
