/**
 * @program: 2020.5.19
 * @description:
 * @author: spdz
 * @create: 2020-05-19 15:40
 **/

//链表实现队列
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

public class MyQueue {
    public int usedSize;
    public Node front;//头
    public Node rear;//尾

    //入队
    public boolean offer(int val) {
        Node node = new Node(val);
        if (isEmply()) {
            this.front = node;
            this.rear = node;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
        return true;
    }

    //出队
    public int poll() {
        if (isEmply()) {
            throw new RuntimeException("队列为空!");
        }
        int data = this.front.data;
        this.front = this.front.next;
        this.usedSize = this.usedSize-1;
        return data;
    }

    //队顶元素
    public int peek() {
        if (isEmply()) {
            throw new RuntimeException("队列为空!");
        }
        return this.front.data;
    }

    //是否为空
    public boolean isEmply() {
        return this.usedSize == 0;
    }

    //长度
    public int size() {
        return this.usedSize;
    }

}
