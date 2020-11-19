/**
 * @program: 2020.6.11
 * @description:泛型的边界
 * @author: spdz
 * @create: 2020-06-17 14:22
 **/

/**
 * 泛型的边界
 *
 * 如果没有给上界，被擦除为 Object，如果有上界，被擦除为上界
 *
 * class Generic<T extends Comparable<T>> 中
 *          <T extends Comparable<T>> 中 Comparable是上界
 *          T 一定是实现了 Comparable 接口的（T 一定是 Comparable的子类）
 *          T 被擦除为 Compareble
 *
 * 泛型没有 下界
 */

//写一个泛型类，包含一个方法，该方法是找到数组当中的最大值
class Generic<T extends Comparable<T>> {
    public T maxNum(T[] array) {
        T maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxNum .compareTo(array[i]) < 0) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }
}

/**
 * 类型推导 -》 根据实参的类型推导出形参的类型
 */
class Generic2 {
    public static <T extends Comparable<T>> T maxNum(T[] array) {
        T maxNum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (maxNum .compareTo(array[i]) < 0) {
                maxNum = array[i];
            }
        }
        return maxNum;
    }
}

public class TestDemo3 {

    public static void main(String[] args) {
        Integer[] array = {12,3,4,5,1,15,20,8};
        System.out.println(Generic2.maxNum(array));
        String[] str = {"abc","defg","hij"};
        System.out.println(Generic2.maxNum(str));
    }

    public static void main1(String[] args) {
        Generic<Integer> generic = new Generic<>();
        Integer[] array = {12,3,4,5,1,15,20,8};
        System.out.println(generic.maxNum(array));
    }
}
