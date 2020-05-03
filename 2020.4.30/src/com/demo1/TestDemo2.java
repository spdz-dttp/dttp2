package com.demo1;

/**
 * @program: 2020.4.30
 * @description:理解多态
 *
 * @author: spdz
 * @create: 2020-04-30 15:09
 **/

class Shape {
    public void draw() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个○");
    }
}

class React extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个◇");
    }
}

class Tringle extends Shape {
    @Override
    public void draw() {
        System.out.println("画一个△");
    }
}

class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("画一朵❀");
    }
}

public class TestDemo2 {

    /**
     * 什么是多态： 是一种思想(一个方法因 动态绑定 而表现出不同的 形式)
     *   发生前提:
     *   1.父类引用子类对象(向上转型)
     *   2.父类和子类有同名的覆盖方法（重写）
     *   3.通过父类引用去调用这个重写的方法的时候
     *
     *   封装：
     *          降低了代码的 管理复杂度
     *   继承：
     *          代码能够 复用
     *   多态：
     *          1.（能让调用者连这个类的类型都不必知道，
     *          只需要知道这个类具有某个方法）
     *          类调用者对类的 使用成本 进一步降低
     *          2.降低了 圈复杂度（if - else）
     *          3.可扩展能力极强
     * @param shape
     */
    public static void drawMap(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Shape shape1 = new Cycle();
        Shape shape2 = new React();
        drawMap(shape1);
        drawMap(shape2);
        Shape shape3 = new Tringle();
        drawMap(shape3);

        int[] arrs = {1,2,3,4};
        // foreach 遍历数组
        for (int x : arrs) {
            System.out.println(x);
        }

        Shape[] shape4 = {new Cycle(),new React(),new Tringle()};
        for (Shape shape5 : shape4) {
            shape5.draw();
        }

    }
}
