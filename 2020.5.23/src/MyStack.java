import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: 2020.5.23
 * @description:
 * @author: spdz
 * @create: 2020-05-21 10:29
 **/

//队列实现栈
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    //入栈
    public void push(int x) {
        if (!queue1.isEmpty()) {
            queue1.offer(x);
        } else if (!queue2.isEmpty()) {
            queue2.offer(x);
        }else {
            queue1.offer(x);
        }
    }

    //出栈
    public int pop() {
        if (empty()) {
            return -1;
        }
        int data = 0;
        int s1 = queue1.size();
        int s2 = queue2.size();
        if (!queue1.isEmpty()) {
            for (int i = 0; i < s1-1; i++) {
                queue2.offer(queue1.poll());
            }
            data = queue1.poll();
        }else {
            for (int i = 0; i < s2-1; i++) {
                queue1.offer(queue2.poll());
            }
            data = queue2.poll();
        }
        return data;
    }

    //栈顶元素
    public int top() {
        if (empty()) {
            return -1;
        }
        int data = 0;
        int s1 = queue1.size();
        int s2 = queue2.size();
        if (!queue1.isEmpty()) {
            for (int i = 0; i < s1; i++) {
                data = queue1.poll();
                queue2.offer(data);
            }
        }else {
            for (int i = 0; i < s2; i++) {
                data = queue2.poll();
                queue1.offer(data);
            }
        }
        return data;
    }

    //是否为空
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return true;
        }
        return false;
    }
}
