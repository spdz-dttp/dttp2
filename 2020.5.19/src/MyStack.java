import java.util.Arrays;

/**
 * @program: 2020.5.19
 * @description:
 * @author: spdz
 * @create: 2020-05-19 08:28
 **/

//顺序表实现栈
public class MyStack<T> {
    public T[] elem;
    public int pop;

    public MyStack(){
        this.elem = (T[])new Object[10];
    }

    //是否满了
    private boolean isFull(){
        return this.pop == this.elem.length;
    }

    //入栈
    public void push(T val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.pop] = val;
        this.pop++;
    }

    //是否为空
    public boolean emply() {
        return this.pop == 0;
    }

    //出栈
    public T pop() {
        if(emply()) {
            throw new RuntimeException("栈空!");
        }
        /*T data = this.elem[pop-1];
        this.pop--;
        return data;*/
        return this.elem[--this.pop];
    }

    //栈顶元素
    public T peek() {
        if(emply()) {
            throw new RuntimeException("栈空!");
        }
        return this.elem[this.pop-1];
    }

    //长度
    public int size(){
        return this.pop;
    }

}
