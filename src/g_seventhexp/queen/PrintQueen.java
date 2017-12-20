package g_seventhexp.queen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PrintQueen {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入想要打印的矩阵编号");
            Queen.paintChess(readFile(scanner.nextInt()));
        }
    }

    private static int[][] readFile(int number) {
        int[][] chess = new int[9][9];
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    new File("F:\\30 IntelliJ IDEA JavaSrc\\algorithm\\src\\g_seventhexp\\file\\"
                            + String.valueOf(number)).getAbsoluteFile()));
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    chess[i][j] = in.read() - 48;
                }
                in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chess;
    }
}
