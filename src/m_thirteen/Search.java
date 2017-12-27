package m_thirteen;

// 编程实现图的邻接矩阵，邻接表存储，及两种存储模式下的深度及广度优先遍历
/* 0 1 1 1
 * 1 0 1 0
 * 1 1 0 1
 * 1 0 1 0
 */
public class Search {
    private static int[][] matrix = new int[][]{{0, 1, 2, 3}, {10, 11, 12, 13}, {100, 110, 120, 130}, {-1, -2, -3, -4}};
    private static int[] path = new int[matrix.length];

    public static void main(String[] args) {
        // print adjacency list
        NodeTable nodeTable = new NodeTable(matrix);
        nodeTable.print();

        // depth traversal


        // breath traversal
    }

    private static void depthTraversal(int i, int x, int y) {
        switch (i) {
            // matrix
            case 1:
                if (x == matrix.length) {
                    print();
                }
                if (y >= matrix.length || y < 0) {
                    return;
                }
                path[x] = matrix[x][y];
                depthTraversal(i, x + 1, y);
                depthTraversal(i, x + 1, y + 1);
                depthTraversal(i, x + 1, y - 1);
                break;
            // table
            case 2:

                break;
            default:
                break;
        }
    }

    private static void breadthTraversal(int i) {
        switch (i) {
            // matrix
            case 1:

                break;
            // table
            case 2:

                break;
            default:
                break;
        }
    }

    private static void print() {
        for (int aPath : path) {
            System.out.print(aPath + " ");
        }
        System.out.println();
    }
}
