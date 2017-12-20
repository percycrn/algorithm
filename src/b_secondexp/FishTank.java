package b_secondexp;

import java.util.Scanner;

public class FishTank {

    // 标记数组
    private static int[] size = new int[1001];

    public static void main(String[] args) {
        int minSize, maxSize, n, count = 0;
        size[0] = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入新放入鱼最小尺寸：");
        minSize = scanner.nextInt();
        System.out.print("输入新放入鱼最大尺寸：");
        maxSize = scanner.nextInt();
        System.out.print("输入原鱼塘鱼的数量：");
        n = scanner.nextInt();
        int[] fishSize = new int[n];
        System.out.println("输入原鱼塘鱼的尺寸大小：");
        // 原来的鱼的size
        for (int i = 0; i < n; i++) {
            fishSize[i] = scanner.nextInt();
        }

        // 将原鱼塘内的鱼 吃与被吃的范围内size值置
        for (int i = 0; i < n; i++) {
            int left = (int) Math.ceil(fishSize[i] / 10);
            int right = (int) Math.floor(fishSize[i] / 2);
            for (int j = left; j <= right; j++) {
                size[j] = 1;
            }
            if (fishSize[i] * 10 >= 1000) {
                right = 1000;
            } else {
                right = fishSize[i] * 10;
            }
            for (int j = fishSize[i] * 2; j <= right; j++) {
                size[j] = 1;
            }
        }

        // 每当检测到size值为0，则count加一
        for (int i = minSize; i <= maxSize; i++) {
            if (size[i] == 0) {
                System.out.print(i + " ");
                count++;
            }
        }
        System.out.println("可放入鱼的数量" + count);
    }

}