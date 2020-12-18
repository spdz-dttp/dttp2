import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: 2020.12.2
 * @description: 矩阵练习
 * @author: spdz
 * @create: 2020-12-02 17:56
 **/
public class Solution {

    //矩阵元素查找
    public static int[] findElement(int[][] mat, int n, int m, int x) {
        int i = 0;
        int j = m-1;
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return new int[] {i,j};
            }else if (mat[i][j] > x) {
                j--;
            }else {
                i++;
            }
        }
        return null;
    }

    //矩阵的最小路径和
    public static int minPathSum(int n, int m, int[][] arr) {
        //mp 数组中任意一个元素，都是arr 数组中 从[0,0] 位置 到 这个元素对应位置 的最小路径 的数字和
        int[][] mp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    mp[i][j] = arr[i][j];
                }else if (i == 0) {
                    mp[i][j] = mp[i][j-1] + arr[i][j];
                }else if (j == 0) {
                    mp[i][j] = mp[i-1][j] + arr[i][j];
                }else {
                    mp[i][j] = Math.min(mp[i-1][j],mp[i][j-1]) + arr[i][j];
                }
            }
        }
        return mp[n-1][m-1];
    }

    //矩阵查找
    public static boolean searchMatrix (int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) {
            return false;
        }
        int left = 0;
        int right = m;
        int mid = right/2;
        while (left < right) {
            if (target < matrix[mid][n-1]) {
                right = mid;
                mid = (left + right)/2;
            }else if (target > matrix[mid][n-1]) {
                left = mid + 1;
                mid = (left + right)/2;
            }else {
                return true;
            }
        }
        int l = 0;
        int r = n-1;
        int mid2 = r/2;
        while (l <= r) {
            if (target < matrix[mid][mid2]) {
                r = mid2 - 1;
                mid2 = (l + r)/2;
            }else if (target > matrix[mid][mid2]) {
                l = mid2 + 1;
                mid2 = (l + r)/2;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,9},{10,11,12,30},{230,300,350,500}};
        System.out.println(searchMatrix(arr, 15));
    }


    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(minPathSum(n, m, arr));
    }

    public static void main1(String[] args) {
        int[][] arr = {{1,5,9},{3,6,28},{4,8,30}};
        int[] arr2 = findElement(arr,3,3,6);
        System.out.println(Arrays.toString(arr2));
    }
}
