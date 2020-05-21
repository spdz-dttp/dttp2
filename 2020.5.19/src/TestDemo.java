import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: 2020.5.19
 * @description: Stack (栈）  Queue (对列)
 * @author: spdz
 * @create: 2020-05-19 08:25
 **/
public class TestDemo {

    public static void main5(String[] args) {
        int n = 0;
        int count = 0;
        while (n <= 100) {
          ;  if (n%10 == 9) {
                count++;
            }
            if(n/10 == 9) {
                count++;
            }
            n++;
        }
        System.out.println(count);
    }

    public static void main4(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.isEmply());
        myQueue.offer(0);
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.size());
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //入队
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        //队顶元素
        System.out.println(queue.peek());
        //出队
        System.out.println(queue.poll());
        System.out.println(queue.peek());

    }

    public static void main2(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        System.out.println(myStack.emply());
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());

    }

    public static void main1(String[] args) {
        //List<Integer> list = new Stack<>();
        Stack<Integer> list = new Stack<>();
        //是否为空
        System.out.println(list.empty());
        //入栈
        list.push(0);
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        //栈顶元素
        System.out.println(list.peek());
        //出栈
        System.out.println(list.pop());
        System.out.println(list.peek());
        //查找元素位置（从上往下数第几个）
        System.out.println(list.search(3));
    }
}
