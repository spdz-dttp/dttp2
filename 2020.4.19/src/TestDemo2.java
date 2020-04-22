import java.util.Scanner;
/**
 * @program: 2020.4.19
 * @description:类练习
 * @author: spdz
 * @create: 2020-04-20 09:54
 **/

/**
 * 加减乘除类
 */
class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add() {
        return this.num1 + this.num2;
    }

    public int sub() {
        return this.num1 - this.num2;
    }

    public int mul() {
        return this.num1 * this.num2;
    }

    public double exc() {
        return this.num1*1.0/this.num2;
    }
}

class MyValue {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class TestDemo2 {
    /**
     * 实参交换两个数
     * @param myValue
     * @param myValue1
     */
    public static void swap (MyValue myValue,MyValue myValue1) {
        int t = myValue.getNum();
        myValue.setNum(myValue1.getNum());
        myValue1.setNum(t);

    }

    public static void main(String[] args) {
        MyValue myValue = new MyValue();
        myValue.setNum(10);
        MyValue myValue1 =new MyValue();
        myValue1.setNum(20);

        System.out.println(myValue.getNum());
        System.out.println(myValue1.getNum());

        swap(myValue,myValue1);

        System.out.println(myValue.getNum());
        System.out.println(myValue1.getNum());

    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Calculator calculator = new Calculator();
        calculator.setNum1(a);
        calculator.setNum2(b);

        System.out.println("加法");
        System.out.println(calculator.add());
        System.out.println("减法");
        System.out.println(calculator.sub());
        System.out.println("乘法");
        System.out.println(calculator.mul());
        System.out.println("除法");
        System.out.println(calculator.exc());
    }

}
