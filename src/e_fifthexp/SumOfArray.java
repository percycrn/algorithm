package e_fifthexp;

/*
 *
 * @程序名: SumOfArray.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-11-01
 * @修改日期: 2017-11-01
 *
 */

/*
 *
 *  数组中两个数之和为定值，找出这对数的下标。已知一个数是一个数组中两个数据之和，找出这个数组中某一对符合条件的数
 *  例如：a[]={1,2,3,5,8} n=10，则输出{2，8}
 *
 */

import java.util.Scanner;

public class SumOfArray {
    public static void main(String[] args) {
        System.out.println("请输入数组元素的个数");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("请输入和数");
        int m = scanner.nextInt();
        int temp;
        scanner.close();
        //TheShortestDistance.quickSort(arr, 0, n - 1); // this method is in the TheShortDistance Java File
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int i = 0, j = n - 1;
        while (i != j) {
            if (arr[i] + arr[j] == m) {
                System.out.println("{" + arr[i] + ", " + arr[j] + "}");
                i++;
            } else if (arr[i] + arr[j] < m) {
                i++;
            } else {
                j--;
            }
        }
    }
}
