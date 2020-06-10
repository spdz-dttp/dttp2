import java.util.Comparator;

/**
 * @program: 2020.6.6
 * @description:
 * @author: spdz
 * @create: 2020-06-10 21:22
 **/
public class ScoreComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.score - o2.score;
    }
}
