/**
 * @program: 2020.6.10
 * @description:
 * @author: spdz
 * @create: 2020-06-17 19:21
 **/

class OuterClass {
    public int data1 = 1;

    //静态内部类
    static class InnerClass {
        public OuterClass out;
        public InnerClass(OuterClass out) {
            this.out = out;
        }
        public void func() {
            System.out.println(this.out.data1);
        }
    }

    static class InnerClass2 {
        OuterClass outerClass = new OuterClass();
        public void func() {
            System.out.println(outerClass.data1);
        }
    }
}

public class TestDemo2 {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass(outerClass);
        innerClass.func();//1
        OuterClass.InnerClass2 innerClass2 = new OuterClass.InnerClass2();
        innerClass2.func();//1
    }
}



