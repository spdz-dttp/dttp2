/**
 * @program: 2020.6.2
 * @description:
 * @author: spdz
 * @create: 2020-06-04 19:20
 **/

class Animal{
    public String name;
    public Animal(String name) {
        this.name = name;
    }

    public Animal() {

    }
    public void Animal(){
        System.out.println(this.name);
    }
}

class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

//    public Cat() {
//        super();
//    }

}

public class TestDemo2 {

    public static void main(String[] args) {
        Cat cat = new Cat("ssss");
        System.out.println(cat.name);
    }
}

class Test {
    static int i = 0;
    public int aMethod(){
        //static int i = 0;//错误 静态变量只能在类主体中定义，不能在方法中定义
                          //因为在static加载时，方法还没有分配空间
        i++;
        return i;
    }

    public static void main(String args[]){
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);//2
    }
}

class Test2 {
    public static void hello() {
        System.out.println("hello");
    }
}
class MyApplication {
    public static void main(String[] args) {

        Test2 test2=null;//当程序执行Test2 tset2时，将static 的 hello()放入方法区，
                        //所以可以 test.静态的东西
        test2.hello();//hello
    }
}



