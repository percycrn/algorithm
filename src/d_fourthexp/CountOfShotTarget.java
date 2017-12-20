package d_fourthexp;

/*
 *
 * @程序名: CountOfShotTarget.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-25
 * @修改日期: 2017-10-25
 *
 */

import java.util.Scanner;

// 一个射击运动员打靶,靶一共有10环,连开n枪打中m环的可能行有多少种?
public class CountOfShotTarget {

    private static int count = 0;
    private static int n, m;

    private static void judgeAndPrint(int[] target, int num) {
        if (num <= 0) {
            return;
        }
        for (int i = 1; i <= 10; i++) {
            target[num] = i;
            judgeAndPrint(target, num - 1);
            if (num == 1) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    sum += target[j];
                }
                if (sum == m) {
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.close();
        int[] target = new int[n + 1];
        judgeAndPrint(target, n);
        System.out.println("打"+n+"次中" + m + "环的可能行数为" + count);
    }
}
