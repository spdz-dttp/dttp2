package demo;

/**
 * @program: 2020.5.3
 * @description:
 * 接口和接口之间是 扩展 extends
 * 类和接口之间是  实现 implements
 * @author: spdz
 * @create: 2020-05-05 16:16
 **/

interface A {
    void func1();
}
interface B {
    void func2();
}

//extends 扩展
interface C extends A,B {
    void func3();
}

// implements 实现
class TestB implements C {
    @Override
    public void func1() {

    }

    @Override
    public void func2() {

    }

    @Override
    public void func3() {

    }
}


public class TestDemo {
}
