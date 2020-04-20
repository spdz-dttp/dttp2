/**
 * @program: 2020.4.17
 * @description:类与对象
 * 访问修饰限定符：
 *      public：公有的
 *      private:私有的
 *      protected:受保护的
 *      什么都不写：默认权限-》包访问权限
 * @author: spdz
 * @create: 2020-04-17 09:02
 **/

class Person {

    //1.字段->成员变量-》定义在方法外面，类的里面

    //(1)实例成员变量：对象里面
    //实例化成员（一般不初始化）若没有初始化  默认值为对应的0值
    //   引用类型默认为null  简单类型默认为0
    //   char默认为 '\u0000'  boolean默认为false
    //对象的引用.成员变量
    public String name;
    public int age;
    /*public char ch;
    public boolean flg;*/

    //(2)静态成员变量  若没有初始化  默认值和实例化成员一样对应0值
    //静态成员变量  不属于对象  放在方法区
    //类名.静态成员变量
    public static int size;


    //2.方法->行为
    // (1)实例方法
    //  能调用实例，也能调用静态
    public void eat() {
        int a = 10;//局部变量  放在栈里
        System.out.println("eat()!");
    }
    public void sleep() {
        System.out.println("sleep()!");
    }
    public void show() {
        System.out.println("我叫" + name + "，今年" + age + "岁");
    }
    //(2)静态方法  又称  类方法
    //类名.静态方法
    public static void funcl() {
        System.out.println("static::ffuncl()");
        //age = 99;//错误  静态方法内部不能访问非静态数据成员
        //sleep();//错误   或非静态方法
        size = 9999;
    }
}

class Test {
    public int a;
    public static int count;
}

public class TestDemo2 {

    /*int count;//成员变量*/

    public static void main(String[] args) {
        Test t1 = new Test();
        t1.a++;
        Test.count++;
        System.out.println(t1.a);
        System.out.println(Test.count);
        System.out.println("============");
        Test t2 = new Test();
        t2.a++;
        Test.count++;
        System.out.println(t2.a);
        System.out.println(Test.count);
    }

    public static void main4(String[] args) {
        Person person = new Person();
        person.eat();
        person.sleep();

        person.name = "spdz";
        person.age = 18;
        person.show();

        Person.funcl();
    }


    public static void main3(String[] args) {

        /*Person person = new Person();
        //如何访问静态成员变量？  类名.静态成员变量
        System.out.println(person.name);*/
        System.out.println(Person.size);

    }


    public static void main2(String[] args) {

        Person person = new Person();
        //如何访问对象中的实例成员变量？
        //操作符：点号    对象的引用.成员变量
        System.out.println(person.name);//null
        System.out.println(person.age);//0
        /*System.out.println(person.ch);
        System.out.println(person.flg);//false*/

        person.name = "spdz";
        person.age = 18;
        System.out.println(person.name);
        System.out.println(person.age);

    }


    public static void main1(String[] args) {

        //实例化一个对象  通过关键字 new
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
    }
}
