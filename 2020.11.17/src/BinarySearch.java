/**
 * @program: 2020.11.17
 * @description: ${description}
 * @author: spdz
 * @create: 2020-11-18 16:06
 **/
public class BinarySearch {
    //二分查找
    public static int binarySeach(int[] arr, int t) {
        int left = 0;
        int right = arr.length;
        while (right >= left){
            int mid = (left + right)/2;
            if (arr[mid] > t) {
                right = mid;
            }else if (arr[mid] < t) {
                left = mid;
            }else {
                return mid;
            }
        }
        return -1;

    }

}
