package b_secondexp;

import java.util.Scanner;

public class MagicBracelet {
    public static void main(String[] args) {
        int num, k;
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入数字环的长度：");
        num = scanner.nextInt();
        System.out.print("请输入变换的次数：");
        k = scanner.nextInt();
        int[] magicNumber = new int[num];
        System.out.println("请输入数字环各个数：");
        for (int i = 0; i < num; i++) {
            magicNumber[i] = scanner.nextInt();
        }
        scanner.close();

        for (int j = 0; j < k; j++) {
            int temp = (magicNumber[num - 1] + magicNumber[0]) % 100;
            for (int m = 0; m < num - 1; m++) {
                magicNumber[m] = (magicNumber[m] + magicNumber[m + 1]) % 100;
            }
            magicNumber[num - 1] = temp;
        }

        for (int i = 0; i < num; i++) {
            System.out.print(magicNumber[i] + " ");
        }
    }
}
