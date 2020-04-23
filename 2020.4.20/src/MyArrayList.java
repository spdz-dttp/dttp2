import java.util.Arrays;

/**
 * @program: 2020.4.20
 * @description:顺序表
 * @author: spdz
 * @create: 2020-04-19 15:57
 **/
public class MyArrayList {
    private int[] elem;//数组
    private int usedSize;//有效的数据个数
    //private static final int capacity = 10;//初始容量

    public int[] getElem() {
        return elem;
    }

    public void setElem(int[] elem) {
        this.elem = elem;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }


    public MyArrayList(int capacity) {
        this.elem = new int[capacity];// capacity 初始容量
        this.usedSize = 0;
    }


    //打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //判断顺序表是否满了
    private boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    //判断pos是否合法
    private void checkPos(int pos) {
        if(pos < 0 || pos > this.usedSize) {
            throw new RuntimeException("pos位置不合法!");
        }
    }

    //在pos位置添加元素data
    public void add(int pos,int data) {
        checkPos(pos);
        //扩容
        if(isFull()) {
            this.elem =
                    Arrays.copyOf(this.elem,this.elem.length*2);
        }

        for (int i = this.usedSize-1; i >= pos; i--) {
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;

        if (pos == this.usedSize) {
            this.elem[pos] = data;
            this.usedSize++;
        }
    }

    //判断是否存在某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    //查找元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //判断顺序表是否为空
    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    //获取pos位置的元素
    public int getPos(int pos) {

        if(isEmpty()) {
            throw new RuntimeException("顺序表为空！");//手动抛出异常
        }
        if(pos < 0 || pos >= this.usedSize) {
            throw new RuntimeException("pos位置不合法！");
        }
        return this.elem[pos];
    }

    //删除第一次出现的关键字 key
    public void remove(int key) {
        if(search(key) == -1) {
            System.out.println("没有要删除的数字");
            return;
        }
        for (int i = search(key); i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    //获得顺序表长度
    public int size() {
        return this.usedSize;
    }

    //清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

}
