package h_eighthexp.defectivechessboard;

/*
 *
 * @程序名: DefectiveChessBoard.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-03
 * @修改日期: 2017-10-03
 *
 */

import javax.swing.*;
import java.util.Scanner;

/* 分治法
 * 对于已知的残缺位置，一定处于当前棋盘的某个象限，那么在剩下的三个象限中在连接的地方各取一个方块为残缺，这三个方块的位置刚好可以构成
 * 一个L型直角，而对于每个象限而言又是规定了一个残缺位置，这样与初始状态又一致了。也就是说，将一个完整的棋盘不断地化为四份，并
 * 且补充每个象限中的残缺位置，直到不能再划分。利用递归来实现。
 */

public class DefectiveChessBoard {

    private static int number = 0;
    private static int[][] chess;

    private static void defective(int x, int y, int a, int b, int size) {
        if (size < 2) return;
        size /= 2;
        if (a < x + size && b < y + size) { // left top
            chess[x + size - 1][y + size] = number;
            chess[x + size][y + size - 1] = number;
            chess[x + size][y + size] = number++;
            defective(x, y, a, b, size); // left top
            defective(x, y + size, x + size - 1, y + size, size); // right top
            defective(x + size, y, x + size, y + size - 1, size); // left bottom
            defective(x + size, y + size, x + size, y + size, size); // right bottom
        } else if (a < x + size && b >= y + size) { // right top
            chess[x + size - 1][y + size - 1] = number;
            chess[x + size][y + size - 1] = number;
            chess[x + size][y + size] = number++;
            defective(x, y, x + size - 1, y + size - 1, size); // left top
            defective(x, y + size, a, b, size); // right top
            defective(x + size, y, x + size, y + size - 1, size); // left bottom
            defective(x + size, y + size, x + size, y + size, size); // right bottom
        } else if (a >= x + size && b < y + size) { // left bottom
            chess[x + size - 1][y + size - 1] = number;
            chess[x + size - 1][y + size] = number;
            chess[x + size][y + size] = number++;
            defective(x, y, x + size - 1, y + size - 1, size); // left top
            defective(x, y + size, x + size - 1, y + size, size); // right top
            defective(x + size, y, a, b, size); // left bottom
            defective(x + size, y + size, x + size, y + size, size); // right bottom
        } else { // right bottom
            chess[x + size - 1][y + size - 1] = number;
            chess[x + size - 1][y + size] = number;
            chess[x + size][y + size - 1] = number++;
            defective(x, y, x + size - 1, y + size - 1, size); // left top
            defective(x, y + size, x + size - 1, y + size, size); // right top
            defective(x + size, y, x + size, y + size - 1, size); // left bottom
            defective(x + size, y + size, a, b, size); // right bottom
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input matrix size");
        int x = scanner.nextInt();
        chess = new int[x + 1][x + 1];
        System.out.println("please input detective coordinate");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        chess[a][b] = number++;
        defective(1, 1, a, b, x);
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Detective Chess Board");
        frame.setSize(chess.length * 50, chess.length * 50);
        frame.setResizable(false);
        frame.add(new Paints(chess));
    }
}
