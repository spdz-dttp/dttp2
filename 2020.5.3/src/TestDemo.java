import java.util.Arrays;

/**
 * @program: 2020.5.4
 * @description:深拷贝
 *  深拷贝： 改变不会使原数据改变
 *  浅拷贝： 改变会使原数据改变
 * @author: spdz
 * @create: 2020-05-04 08:36
 **/

class Money implements Cloneable{
    double money = 12.5;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;

    Money money = new Money();


    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        // 1. 克隆 person
        Person p1 = (Person) super.clone();
        // 2. 克隆当前的 Money对象
        p1.money = (Money) this.money.clone();
        return p1;
    }
}

public class TestDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person1.money.money);
        System.out.println(person2.money.money);
        System.out.println("======================修改");
        person2.money.money = 99.9;
        System.out.println(person1.money.money);
        System.out.println(person2.money.money);

    }

    public static void main2(String[] args) throws CloneNotSupportedException {
        Person person1 = new Person();

        Person person2 = (Person)person1.clone();
        System.out.println(person1.age);
        System.out.println(person2.age);
        System.out.println("=====================修改");
        person2.age = 99;
        System.out.println(person1.age);
        System.out.println(person2.age);
    }

    public static void main1(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = array.clone();
        array2[0] = 99;
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}
