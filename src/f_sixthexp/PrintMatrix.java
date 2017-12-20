package f_sixthexp;

/*
 *
 * @程序名: PrintMatrix.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-08
 * @修改日期: 2017-10-08
 *
 */

import java.util.Scanner;

/**
 * 编写程序打印如下图所示的n*n方阵
 * n = 5
 * 1 1 1 1 1
 * 1 2 2 2 1
 * 1 2 3 2 1
 * 1 2 2 2 1
 * 1 1 1 1 1
 * <p>
 * n = 6
 * 1 1 1 1 1 1
 * 1 2 2 2 2 1
 * 1 2 3 3 2 1
 * 1 2 3 3 2 1
 * 1 2 2 2 2 1
 * 1 1 1 1 1 1
 * <p>
 * n = 7
 * 1 1 1 1 1 1 1
 * 1 2 2 2 2 2 1
 * 1 2 3 3 3 2 1
 * 1 2 3 4 3 2 1
 * 1 2 3 3 3 2 1
 * 1 2 2 2 2 2 1
 * 1 1 1 1 1 1 1
 */

public class PrintMatrix {
    public static void main(String[] args) {
        System.out.println("请输入一个数表示矩阵的长");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        int[][] matrix = new int[n + 1][n + 1];
        for (int i = 1; i <= (n + 1) / 2; i++) {
            for (int j = 1; j <= (n + 1) / 2; j++) {
                if (j > i) {
                    matrix[i][j] = i;
                } else {
                    matrix[i][j] = j;
                }
                matrix[i][n - j + 1] = matrix[i][j];
                matrix[n - i + 1][j] = matrix[i][j];
                matrix[n - i + 1][n - j + 1] = matrix[i][j];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}