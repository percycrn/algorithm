package b_secondexp;

import java.util.Scanner;

public class ChangeNum {
    private static int[] number = new int[20];

    public static void main(String[] args) {

        int num, count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入该数字：");
        num = scanner.nextInt();
        scanner.close();
        while (num > 9) {
            num = finNum(num);
            count++;
        }
        System.out.println("变换次数为" + count);
    }

    //获得数的长度
    private static int getLength(int num) {
        int flag = 1;
        int length = 0;
        while (true) {
            if (num / flag > 0) {
                flag *= 10;
                length++;
            } else {
                break;
            }
        }
        return length;
    }

    //获得各个位置的数字
    private static void getNumber(int num, int length) {
        int flag = 1;
        int i;
        for (int j = 1; j < length; j++) {
            flag *= 10;
        }
        for (i = 1; i < length; i++) {
            number[i] = num / flag;
            num = num - flag * number[i];
            flag /= 10;
        }
        number[i] = num % 10;
    }

    //获得乘法之后的数
    private static int finNum(int oldNum) {
        int length = getLength(oldNum);
        getNumber(oldNum, length);
        // 输出该数的各个位数
        System.out.print("此次变换该数各个位数为：");
        for (int i = 1; i <= length; i++) {
            System.out.print(number[i] + " ");
        }
        System.out.println();
        int num = 1;
        for (int i = 1; i <= length; i++) {
            num *= number[i];
        }
        return num;
    }
}
