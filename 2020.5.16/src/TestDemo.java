import java.util.ArrayList;
import java.util.List;

/**
 * @program: 2020.5.16
 * @description:
 * @author: spdz
 * @create: 2020-05-15 23:19
 **/

class Student{
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
    public static void main(String[] args) {
        Student student = new Student("bit","火箭",15.9);
        Student student2 = new Student("spdz","火箭",89.9);

        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        System.out.println(list);

    }
}
