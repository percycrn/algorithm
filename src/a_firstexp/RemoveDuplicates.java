package a_firstexp;

import java.util.Scanner;

public class RemoveDuplicates {
    private static int count;
    public static void main(String[] args) {
        int i, temp, flag;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数组长度 ");
        count = scanner.nextInt();
        int[] a = new int[count];

        for (i = 0; i < count; i++) {
            a[i] = scanner.nextInt();
        }

        //排序 从小到大 冒泡算法
        for (i = count; i > 0; i--) { //count is the length of Array
            flag = 0;                 //flag is to judge whether sort is done
            for (int j = 0; j < i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    flag++;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        //删去重复元素
        for (i = 0; i < count - 1; i++) {
            if (a[i] == a[i + 1]) {
                for (int j = i + 1; j < count - 1; j++) {
                    a[j] = a[j + 1];
                }
                count--;
                i--;
            }
        }
        System.out.println("数组长度 " + count);
        for (i = 0; i < count; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

