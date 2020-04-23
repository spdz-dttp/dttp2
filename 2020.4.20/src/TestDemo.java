import java.util.Arrays;

/**
 * @program: 2020.4.20
 * @description:
 * @author: spdz
 * @create: 2020-04-19 15:19
 **/

public class TestDemo {

    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList(10);
        for (int i = 0; i < 9; i++) {
            myArrayList.add(i,i);
        }
        myArrayList.display();

        myArrayList.add(8,9);
        myArrayList.display();

        myArrayList.add(10,20);
        myArrayList.display();

        //myArrayList.add(13,30);
        //myArrayList.display();
        System.out.println("==================================");

        System.out.println(myArrayList.contains(20));
        System.out.println(myArrayList.contains(21));

        System.out.println(myArrayList.search(20));
        System.out.println(myArrayList.search(21));
        System.out.println("===================================");

        MyArrayList myArrayList1 = new MyArrayList(10);
        //System.out.println(myArrayList1.getPos(8));
        //System.out.println(myArrayList1.size());

        int[] array = new int[]{1,2,5,6,4,8,10,3};

        myArrayList1.setElem(array);
        myArrayList1.setUsedSize(array.length);
        System.out.println(Arrays.toString(myArrayList1.getElem()));
        System.out.println(myArrayList1.getUsedSize());

        myArrayList1.add(8,6);
        myArrayList1.display();
        myArrayList1.add(6,10);
        myArrayList1.display();
        myArrayList1.add(10,11);
        myArrayList1.display();
        //myArrayList1.add(12,30);
        //myArrayList1.display();
        System.out.println("======================================");

        System.out.println(myArrayList1.getPos(4));
        //System.out.println(myArrayList1.getPos(12));
        //System.out.println(myArrayList1.getPos(11));
        System.out.println("======================================");

        myArrayList1.display();
        myArrayList1.remove(10);
        myArrayList1.display();
        myArrayList1.remove(66);
        myArrayList1.display();
        myArrayList1.remove(1);
        myArrayList1.display();
        myArrayList1.remove(11);
        myArrayList1.display();
        System.out.println("======================================");

        myArrayList1.display();
        System.out.println("清空");
        myArrayList1.clear();
        myArrayList1.display();
    }
}
