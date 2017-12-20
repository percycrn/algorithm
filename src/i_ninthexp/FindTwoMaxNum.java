package i_ninthexp;

import java.util.Scanner;

// 分治算法求n个数的数组中找出第二个最大元素

public class FindTwoMaxNum {
    private static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the quantity of numbers");
        int n = scanner.nextInt();
        arr = new int[n];
        System.out.println("please input the content in array");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] result = divideAndConquerMethod(0, n - 1);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    private static int[] divideAndConquerMethod(int left, int right) {
        int max, max2;
        // 只剩一个值
        if (left == right) {
            max = arr[left];
            max2 = 0;
        // 剩两个值
        } else if (right - left == 1) {
            if (arr[left] > arr[right]) {
                max = arr[left];
                max2 = arr[right];
            } else {
                max = arr[right];
                max2 = arr[left];
            }
        // 剩余三个值几以上
        } else {
            int mid = (left + right) / 2;
            int[] lResult = divideAndConquerMethod(left, mid);
            int[] rResult = divideAndConquerMethod(mid + 1, right);
            if (lResult[0] > rResult[0]) {
                max = lResult[0];
                if (lResult[1] > rResult[0]) {
                    max2 = lResult[1];
                } else {
                    max2 = rResult[0];
                }
            } else {
                max = rResult[0];
                if (rResult[1] > lResult[0]) {
                    max2 = rResult[1];
                } else {
                    max2 = lResult[0];
                }
            }
        }
        return new int[]{max, max2};
    }
}