import java.util.*;

/**
 * @program: 2020.5.18
 * @description:
 * @author: spdz
 * @create: 2020-05-18 13:07
 **/

class A<T> {
    private T value;

    public A(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    @Override
    public String toString() {
        return "["+id + "," + importance + "," + subordinates + "]";
    }
}

public class TestDemo {

    //员工的重要性
    public static int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id,e);
        }
        return getImportanceSum(map,id);
    }

    public static int getImportanceSum(Map<Integer,Employee> map,int id) {
        Employee e = map.get(id);
        int importanceSum = e.importance;
        if (e.subordinates == null) {
            return importanceSum;
        }
        for(int id2: e.subordinates) {
            importanceSum += getImportanceSum(map , id2);
        }
        return importanceSum;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.subordinates = new ArrayList<>();
        employee.id = 1;
        employee.importance = 5;
        employee.subordinates.add(2);
        employee.subordinates.add(3);
        employees.add(employee);

        Employee employee1 = new Employee();
        employee1.id = 2;
        employee1.importance = 3;
        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.id = 3;
        employee2.importance = 3;
        employees.add(employee2);

        System.out.println(employees);
        int i = getImportance(employees,1);
        System.out.println(i);


    }

    public static void main1(String[] args) {
        A<Integer> a = new A<>(10);
        int i = (int)a.get();
        System.out.println(i);
    }

}
