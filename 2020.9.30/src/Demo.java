import java.util.Scanner;

/**
 * @program: 2020.9.30
 * @description: 简单购票
 * @author: spdz
 * @create: 2020-11-18 09:32
 **/
public class Demo {
    public static void main(String[] args) {
        System.out.println("进入购票系统 ");
        System.out.println("=============================");
        System.out.println("1.成人票");
        System.out.println("2.儿童票");
        System.out.println("3.老年票");
        System.out.println("4.学生票");
        System.out.println("=============================");
        System.out.print("请选择-> ");

        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        Person person;
        person = PersonFactory.getPerson(i);
        person.who();
    }
}
