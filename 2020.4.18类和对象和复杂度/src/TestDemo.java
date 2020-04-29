/**
 * @program: 2020.4.18类和对象和复杂度
 * @description:构造方法
 * @author: spdz
 * @create: 2020-04-18 09:02
 **/

class Person {
    private String name;
    private int age;

    //构造方法 ：  方法名 和 类名 相同，且 没有 返回值
    //作用  ： 构造对象 （new实例化一个对象就用到了构造方法）
    //  当 没有提供 构造方法 时，
    //  编译器会自动提供一个不带参数的构造方法

    /*//手写 构造方法
    public Person() {
        System.out.println("Person<init>");
    }

    public Person(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }*/

    //this  :
    //this()  :调用自己的构造方法
    //         (只能在构造方法中使用，且只能用一次，且只能在第一行用)
    //this.data  :调用当前对象的属性 （例如 this.name）（先查找本类，如果本类没有，就调用父类）
    //this.func()  :调用当前对象的方法

    //快捷键  构造方法
    // alt+insert
    public Person() {
        // this()  调用了public Person(String name, int age)
        this("caocao",18);
        System.out.println("Person<init>");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person<String,int>");
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TestDemo {

    public static void main(String[] args) {
        Person person = new Person();
    }

    public static void main3(String[] args) {
        Person person = new Person();//new Person() 就使用了构造方法
        System.out.println(person);

        Person person1 = new Person("spdz",18);
        System.out.println(person1);
    }

    public static void main2(String[] args) {
        Person person = new Person();
        person.setName("spdz");
        System.out.println(person.getName());
        person.setAge(18);
        System.out.println(person.getAge());

        System.out.println(person);

    }

    public static void main1(String[] args) {
        String ch = "hehe";
        System.out.println(ch);
    }

}
