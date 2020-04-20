/**
 * @program: 2020.4.17
 * @description: 封装
 * 封装： 用private来修饰属性 或  方法
 * 没有特殊要求，属性都设置为私有的（封装）
 * 关键字  this : 代表当前对象的引用
 * 要习惯使用this
 * @author: spdz
 * @create: 2020-04-17 20:48
 **/

class Student {
    //封装   限定你只能在当前类中使用
    private String MyName;
    private int Age;

    //手写  公开接口
    //提供一个公开的接口
    public String getMyName() {
        return this.MyName;
    }
    public int getAge() {
        return this.Age;
    }

    //public void setMyName(String name) {
    //    MyName = name;
    //}

    public void setMyName(String MyName) {
        //MyName = MyName;// null  相当于自己给自己赋值，并没有赋值属性，局部变量优先
        this.MyName = MyName;//关键字  this : 代表当前对象的引用
    }
    public void setAge(int age) {
        this.Age = age;
    }


    public void func1() {
        System.out.println("func1()");
    }

    public void show() {
        System.out.println("我叫" + this.MyName + "今年" + this.Age + "岁");
    }
}

class Student2 {
    private String name;
    private int age;

    //快捷键  写  公开接口
    // alt + insert
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

    public void func2() {
        System.out.println("func2()");
    }
    public void show() {
        System.out.println("我叫" + this.name + "今年" + this.age + "岁");
    }

    // 重新  实现了一下 Object类的 toString()方法
    // alt + insert-》toString()
    //  Object  是  所有类的 父类
    @Override//注解：这个注解指的是  这个方法是重新写的
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

   //以上是类的实现者写的代码

   //以下是类的调用者
public class TestDemo3 {

       public static void main(String[] args) {
           Student2 student2 = new Student2();
           student2.setName("spdz");
           student2.setAge(18);
           System.out.println(student2.getName());
           System.out.println(student2.getAge());

           //student2.show();

           System.out.println(student2);
       }

    public static void main1(String[] args) {
        Student student = new Student();
        /*student.MyName = "spdz";//错误  MyName被封装
        System.out.println(student.MyName);//错误  MyName被封装*/

        student.setMyName("spdz");
        String str = student.getMyName();
        System.out.println(str);

        student.setAge(18);
        System.out.println(student.getAge());
    }
}
