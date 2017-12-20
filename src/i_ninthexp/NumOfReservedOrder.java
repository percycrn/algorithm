package i_ninthexp;

import java.util.Scanner;

// 用分治法来求一串数中的逆序数的个数

public class NumOfReservedOrder {
    private static int[] arr;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the quantity of numbers");
        int n = scanner.nextInt();
        arr = new int[n];
        System.out.println("please input the content in array");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        divideAndConquerMethod(0, n - 1);
        System.out.println(count);
    }

    private static int[] divideAndConquerMethod(int left, int right) {
        if (left == right) {
            return new int[]{arr[left], arr[left]};
        } else if (right - left == 1) {
            if (arr[right] < arr[left]) {
                count++;
            }
            return new int[]{arr[left], arr[right]};
        } else {
            int mid = (left + right) / 2;
            int[] lResult = divideAndConquerMethod(left, mid);
            int[] rResult = divideAndConquerMethod(mid + 1, right);
            if (lResult[1] > rResult[0]) {
                count++;
            }
            return new int[]{lResult[0], rResult[1]};
        }
    }
}