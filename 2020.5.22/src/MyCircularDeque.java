/**
 * @program: 2020.5.22
 * @description:
 * @author: spdz
 * @create: 2020-05-21 08:16
 **/

//循环双端队列
public class MyCircularDeque {

    public int[] elem;
    public int front;
    public int last;


    public MyCircularDeque(int k) {
        this.elem = new int[k+2];
    }

    //头部入队
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            this.last = (this.last+1) % this.elem.length;
        }
        this.elem[this.front] = value;
        if (this.front == 0) {
            this.front = this.elem.length-1;
        }else {
            this.front = this.front-1;
        }
        return true;
    }

    //尾部入队
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            if (this.front == 0) {
                this.front = this.elem.length-1;
            }else {
                this.front = this.front-1;
            }
        }
        this.elem[this.last] = value;
        this.last = (this.last+1) % this.elem.length;
        return true;
    }

    //头部出队
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front+1) % this.elem.length;
        return true;
    }

    //尾部出队
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (this.last == 0) {
            this.last = this.elem.length-1;
        }else {
            this.last = this.last-1;
        }
        return true;
    }

    //头部元素
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[(this.front+1) % this.elem.length];
    }

    //尾部元素
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = this.last == 0 ? this.elem.length-1 : this.last-1;
        return this.elem[index];
    }

    //是否为空
    public boolean isEmpty() {
        if (this.front == this.last) {
            return true;
        }
        if ((this.front+1) % this.elem.length == this.last) {
            this.front = (this.front+1) % this.elem.length;
            return true;
        }
        return false;
    }

    //是否为满
    public boolean isFull() {
        return (this.last+1) % this.elem.length == this.front;
    }
}
