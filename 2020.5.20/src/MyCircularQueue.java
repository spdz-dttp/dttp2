import org.omg.CORBA.Object;

/**
 * @program: 2020.5.20
 * @description:
 * @author: spdz
 * @create: 2020-05-20 09:58
 **/

//循环对列
public class MyCircularQueue{
    public int[] elem;
    public int front;//头
    public int rear;//尾

    public MyCircularQueue(int k) {
        this.elem = new int[k+1];
    }

    //入队
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    //出队
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    //获得头节点
    public int Front() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！");
        }
        return this.elem[this.front];
    }

    //获得尾节点
    public int Rear() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！");
        }
        int index = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        return this.elem[index];
    }

    //是否为空
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    //是否为满
    public boolean isFull() {
        return (this.rear+1) % this.elem.length == this.front;
    }
}



