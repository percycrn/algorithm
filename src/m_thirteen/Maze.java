package m_thirteen;

import java.util.ArrayList;

// 利用回溯法完成迷宫问题的求解
/* 0 1 1 1 1
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 1 1 0
 */

public class Maze {
    private static int[][] maze = new int[][]{{0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 1, 1, 0}};
    private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 上下左右
    private static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        // start maze[0][0]
        // end maze[3][4]
        findWay(0, 0);
    }

    private static void findWay(int x, int y) {
        if (x == 3 && y == 4) {
            System.out.print("[0, 0]");
            for (String aArrayList : arrayList) {
                System.out.print(" -> " + aArrayList);
            }
            System.out.println();
        }
        for (int i = 0; i < 4; i++) {
            if (x + dir[i][0] < 0 || x + dir[i][0] > 3 || y + dir[i][1] < 0 || y + dir[i][1] > 4) {
                continue;
            }
            if (maze[x + dir[i][0]][y + dir[i][1]] == 0) {
                maze[x + dir[i][0]][y + dir[i][1]] = 1;
                arrayList.add("[" + (x + dir[i][0]) + ", " + (y + dir[i][1]) + "]");
                findWay(x + dir[i][0], y + dir[i][1]);
                maze[x + dir[i][0]][y + dir[i][1]] = 0;
                arrayList.remove("[" + (x + dir[i][0]) + ", " + (y + dir[i][1]) + "]");
            }
        }
    }
}