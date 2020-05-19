import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @program: 2020.5.17
 * @description:
 * @author: spdz
 * @create: 2020-05-16 12:48
 **/

class Student {
    private String name;
    private String classes;
    private double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}

public class TestDemo {

    public static String func1(String str1, String str2) {
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                ret.append(ch);
            }
        }
        return ret.toString();
    }

    public static List<Character> func(String str1, String str2) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            if (!str2.contains(ch + "")) {
                list.add(ch);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        List<Character> ret = func(str1, str2);
        for (char ch:ret) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main2(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void main1(String[] args) {
        Student student1 = new Student("小祝","火箭",1.0);
        Student student2 = new Student("小黄","火箭",2.0);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        System.out.println(list);
    }
}
