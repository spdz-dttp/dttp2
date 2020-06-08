import java.util.Comparator;

/**
 * @program: 2020.6.6
 * @description:
 * @author: spdz
 * @create: 2020-06-08 23:41
 **/
public class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.age-o2.age;
    }
}
