package j_tenthexp;

import java.util.Scanner;

// 编程实现数塔问题的求解

public class MathTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the height of the tower");
        int height = scanner.nextInt();
        int[][] tower = new int[height][height];
        int[][] track = new int[height - 1][height - 1];
        int[][] routine = new int[height][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                tower[i][j] = scanner.nextInt();
                routine[i][j] = tower[i][j];
            }
        }
        for (int i = height - 1; i > 0; i--) {
            for (int j = 0; j < height - 1; j++) {
                if (tower[i][j] > tower[i][j + 1]) {
                    track[i - 1][j] = 0;
                    tower[i - 1][j] += tower[i][j];
                } else {
                    track[i - 1][j] = 1;
                    tower[i - 1][j] += tower[i][j + 1];
                }
            }
        }
        System.out.println(tower[0][0]);
        System.out.print("the path is " + routine[0][0]);
        int j = 0;
        for (int i = 1; i < height; i++) {
            j += track[i - 1][j];
            System.out.print(" -> " + routine[i][j]);
        }
    }
}
