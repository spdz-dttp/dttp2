/**
 * @program: 2020.6.6
 * @description:
 * @author: spdz
 * @create: 2020-06-08 23:34
 **/

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 基于比较器比较
 */
class Person{
    public String name;
    public int age;
    public int score;

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

public class TestDemo3 {

    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        //优先队列
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(ageComparator);
        priorityQueue.offer(new Person("hehe",16,80));
        priorityQueue.offer(new Person("enen",18,60));
        System.out.println(priorityQueue);

    }

    public static void main2(String[] args) {
        Person person1 = new Person("hehe",16,80);
        Person person2 = new Person("enen",18,60);
        Person person3 = new Person("arar",20,90);
        Person[] people = new Person[3];
        people[0] = person1;
        people[1] = person2;
        people[2] = person3;

        AgeComparator ageComparator = new AgeComparator();

        ScoreComparator scoreComparator = new ScoreComparator();

        Arrays.sort(people,ageComparator);
        System.out.println(Arrays.toString(people));

        Arrays.sort(people,scoreComparator);
        System.out.println(Arrays.toString(people));
    }

    public static void main1(String[] args) {
        Person person1 = new Person("hehe", 16, 80);
        Person person2 = new Person("enen", 18, 60);

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(person1 , person2));//-2

        ScoreComparator scoreComparator = new ScoreComparator();
        System.out.println(scoreComparator.compare(person1 , person2));//20

    }
}