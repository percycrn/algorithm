package h_eighthexp;

import java.util.*;

//在O（NlogN）的时间复杂度内找出数据集合S中任意两个数之间的最近距离。例如S={8，3，1，4，6，5}，则最近距离为1。
public class TheShortestDistance {
    public static void main(String[] args) {
        //输入数组
        int shortDistance;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入数据集合的长度");
        int length = scanner.nextInt();
        int[] arr = new int[length];
        System.out.println("输入数据");
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        //快速排序
        quickSort(arr, 0, length - 1);
        shortDistance = arr[1] - arr[0];
        for (int i = 1; i < length - 2; i++) {
            if (shortDistance > arr[i + 1] - arr[i]) {
                shortDistance = arr[i + 1] - arr[i];
            }
        }
        System.out.println("最短距离为 " + shortDistance);
    }

    // 快速排序
    private static void quickSort(int[] arr, int left, int right) {
        int start = left;
        int end = right;
        int key = arr[left];

        while (end > start) {
            //从后往前比较
            while (end > start && arr[end] >= key) // 如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (arr[end] <= key) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            //从前往后比较
            while (end > start && arr[start] <= key) // 如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (arr[start] >= key) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            // 此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        // 递归
        if (start > left) quickSort(arr, left, start - 1); // 左边序列。第一个索引位置到关键值索引-1
        if (end < right) quickSort(arr, end + 1, right); // 右边序列。从关键值索引+1到最后一个
    }
}