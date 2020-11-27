/**
 * @program: 2020.6.11
 * @description:
 * @author: spdz
 * @create: 2020-06-17 13:44
 **/

/**
 * 泛型
 * 1、<T> : T 占位符 表示 当前类是 泛型类
 * 2、放数据时 可以自动进行类型检查
 * 3、取数据时 可以自动进行类型转换
 * 4、泛型是在编译时期的一种机制 -》擦除机制 。 编译时 按照 Object 编译，不是替换成 Object
 * 5、泛型是有边界的
 *
 * 不能 new 泛型类型的数组
 * 简单类型 不能 作为泛型类型的参数
 * 泛型类型的参数 不参与类型组成
 */
class MyStack<T> {
    public T[] elem;
    public int top;

    public MyStack() {
        //this.elem = new T[10];//error 不能 new 泛型类型的数组
        this.elem = (T[]) new Object[10];
    }

    public void push(T val) {
        this.elem[this.top] = val;
        this.top++;
    }

    public T peek() {
        return this.elem[top-1];
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(10);
        myStack.push(20);

        int ret = myStack.peek();
        System.out.println(ret);//20

        MyStack<String> myStack2 = new MyStack<>();
        myStack2.push("abcd");
        myStack2.push("efgh");

        String ret2 = myStack2.peek();
        System.out.println(ret2);//efgh
    }
}
