package g_seventhexp.queen;

/*
 *
 * @程序名: Queen.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-11-15
 * @修改日期: 2017-11-15
 *
 */

// 8皇后问题。在国际棋盘上放8个皇后，国际象棋共有8行8列，皇后可以吃掉与之同行同列以及同一对角线山的其他皇后。
// 为让他们共存，请编写算法找出各种放置方法。请用图形界面展示皇后的排列结果。

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Queen {

    private static int[][] chess = new int[9][9];
    private static int count = 0;
    private static int numOfFile = 1;

    public static void main(String[] args) {
        queen(1);
        System.out.println(count);
    }

    private static void queen(int row) {
        if (row == 9) {
            file(chess);
            count++;
            return;
        }
        for (int j = 1; j < 9; j++) {
            if (check(row, j)) {
                chess[row][j] = 1;
                queen(row + 1);
                chess[row][j] = 0;
            }
        }
    }

    private static boolean check(int i, int j) {
        int varI = i, varJ = j;
        for (int a = 1; a < 9; a++) {
            if (chess[i][a] == 1 || chess[a][j] == 1) {
                return false;
            }
        }
        while (varI >= 1 && varJ >= 1) {
            if (chess[varI--][varJ--] == 1) {
                return false;
            }
        }
        varI = i;
        varJ = j;
        while (varI < 9 && varJ >= 1) {
            if (chess[varI++][varJ--] == 1) {
                return false;
            }
        }
        varI = i;
        varJ = j;
        while (varI >= 1 && varJ < 9) {
            if (chess[varI--][varJ++] == 1) {
                return false;
            }
        }
        varI = i;
        varJ = j;
        while (varI < 9 && varJ < 9) {
            if (chess[varI++][varJ++] == 1) {
                return false;
            }
        }
        return true;
    }

    static void paintChess(int[][] chess) {
        JFrame frame = new JFrame();
        frame.setTitle(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(300, 300);
        frame.add(new Paints(chess));
    }

    private static void file(int[][] chess) {
        try {
            PrintWriter out = new PrintWriter(
                    new File("F:\\30 IntelliJ IDEA JavaSrc\\algorithm\\src\\g_seventhexp\\"
                            + String.valueOf(numOfFile++)).getAbsoluteFile());
            try {
                for (int i = 1; i <= 8; i++) {
                    for (int j = 1; j <= 8; j++) {
                        out.print(chess[i][j]);
                    }
                    out.print("\n");
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}