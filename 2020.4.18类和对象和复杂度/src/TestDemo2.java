/**
 * @program: 2020.4.18类和对象和复杂度
 * @description: 代码块
 * @author: spdz
 * @create: 2020-04-18 20:52
 **/

    //代码块：
    //   实例代码块/构造代码块
    //   静态代码块
    //   本地代码块
class Student {
    private String name;
    private int age;
    private static int count;

    //实例代码块
    {
        this.name = "zhangfei";
        count = 99;
        System.out.println("实例代码块");
    }

    //静态代码块
    //不能访问非静态数据成员
    //静态的内容，只会被执行一次，且最早执行
    //如果 都是静态 的，则和 定义的前后顺序 有关
    static {
        //this.name = "zhangfei";//错误，name是实例成员变量
        count = 99;
        System.out.println("静态代码块");
    }

    public Student() {
        System.out.println("Student<init>");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("eat()");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Test {
    public static void hello() {
        System.out.println("hello");
    }
}

public class TestDemo2 {
    public static void main3(String[] args) {
        Test test=null;
        test.hello();
    }

    public static void main(String[] args) {
        /*Student student = new Student();
        student.eat();
        student.setAge(18);
        System.out.println(student.getAge());*/

        //匿名对象 ：没有名字的对象（没有引用的对象）
        //   只能在创建对象时使用
        new Student().eat();
        new Student().setAge(19);
        System.out.println(new Student().getAge());

    }

    public static void main1(String[] args) {
        Student student = new Student();
        System.out.println("===============");
        Student student1 = new Student();

    }

}
