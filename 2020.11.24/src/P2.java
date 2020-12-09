/**
 * @program: 2020.11.24
 * @description: 内存
 * @author: spdz
 * @create: 2020-11-24 16:12
 **/

/**
 *  内存：
 *      栈：
 *          分为java栈、本地方法栈
 *          表现方法的执行和返回过程，存储方法在执行过程中的一些临时数据
 *          先进后出
 *          栈里存的数据是线程私有的，栈帧中的数据主要是局部变量，修改时没有线程安全问题
 *      堆：
 *          保存大量的对象，普通属性在对象中，所以普通属性也在堆中
 *          堆中的数据是所有线程共享的，属性修改时可能蕴含线程安全问题
 *      方法区：（也在堆中）
 *          静态属性保存在类中，类在方法区，所以静态属性在方法区
 *          方法区是所有线程共享的，修改静态属性修改时可能蕴含线程安全问题
 *      类常量池：
 *      PC：
 */

/**
 * 普通类 和（接口  抽象类）
 *      区别： 普通类 可以实例化对象，     接口/抽象类 不能实例化对象
 *                    不可以出现抽象方法               允许出现抽象方法（可有可没有）
 *
 *      abstract：  语法上两种 （修饰类/修饰方法）
 *      final：  语法上三种 （修饰类/修饰方法/修饰变量）
 */

/**
 *  场景题----解决问题式
 *  1.问题是什么？
 *  2.观察问题--测量--确定问题/缩小问题范围
 *  3.理论角度分析
 *  4.设计实验验证
 *  5.解决问题
 *
 *  内存泄漏：  一部分内存因某些原因，不受控制，不能使用
 */

class Animal {
    void eat() {

    }
}

class Bird extends Animal {
    void eat() {
        System.out.println("bird eat");
    }
    void fly() {
        System.out.println("bird fly");
    }
}

/**
 *  向下转型
 *  向下转型-》 将父类的引用  变成  子类的引用
 *      注意：向下转型非常不安全 很少会使用
 *      关键字  instanceof
 *              A instanceof B  判断 A 是不是 B 的一个父类
 */

public class P2 {
    public static void main(String[] args) {
        Animal animal = new Bird();
        if (animal instanceof Bird) {
            Bird bird = (Bird)animal;
            bird.fly();
        }

    }
}

