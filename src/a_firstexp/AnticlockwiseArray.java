package a_firstexp;

import java.util.Scanner;

public class AnticlockwiseArray {
    public static void main(String[] args) {
        int N, i, j, length;
        System.out.println("输入阶数 ");
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[][] arr = new int[N][N];
        length = N * N;
        int s = 0, x = 0, z = 0, y = 0, flag = 1;//上下左右
        i = -1;
        j = 0;
        //逆时针输出
        while (length != 0) {
            //方向下
            while (length != 0 && i < N - x - 1) {
                i++;
                arr[i][j] = flag++;
                //System.out.print("arr[" + i + "]" + "[" + j + "] " + arr[i][j] + " ,");
                length--;
            }
            //System.out.println();
            z++;
            //方向右
            while (length != 0 && j < N - y - 1) {
                j++;
                arr[i][j] = flag++;
                //System.out.print("arr[" + i + "]" + "[" + j + "] " + arr[i][j] + " ,");
                length--;
            }
            //System.out.println();
            x++;
            //方向上
            while (length != 0 && i > s) {
                i--;
                arr[i][j] = flag++;
                //System.out.print("arr[" + i + "]" + "[" + j + "] " + arr[i][j] + " ,");
                length--;
            }
            //System.out.println();
            y++;
            //方向左
            while (length != 0 && j > z) {
                j--;
                arr[i][j] = flag++;
                //System.out.print("arr[" + i + "]" + "[" + j + "] " + arr[i][j] + " ,");
                length--;
            }
            //System.out.println();
            s++;
        }
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}