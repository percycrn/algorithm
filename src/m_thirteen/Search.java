package m_thirteen;

import m_thirteen.util.LinkedList;
import m_thirteen.util.NodeTable;

// 编程实现图的邻接矩阵，邻接表存储，及两种存储模式下的深度及广度优先遍历
/* 0 1 1 0 0 0 0 0
 * 1 0 0 1 1 0 0 0
 * 1 0 0 0 0 1 1 0
 * 0 1 0 0 0 0 0 1
 * 0 1 0 0 0 0 0 1
 * 0 0 1 0 0 0 0 1
 * 0 0 1 0 0 0 0 1
 * 0 0 0 1 1 1 1 0
 */
public class Search {
    private static int[][] matrix = new int[][]{
            {0, 1, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 0}};
    private static int[] path = new int[matrix.length];
    private static int[] visited = new int[matrix.length];
    private static int length = 0;
    private static int index = 0;
    private static NodeTable nodeTable = new NodeTable(matrix);
    private static LinkedList breadthTable = new LinkedList();

    public static void main(String[] args) {
        // print adjacency list

        // nodeTable.print();
        /*// depth traversal: matrix
        index = 0;
        path[index++] = 0;
        visited[0] = 1;
        depthTraversalMatrix(0);*/

        // depth traversal table
        index = 0;
        path[index++] = 0;
        visited[0] = 1;
        depthTraversalTable(0);

        // breath traversal
        //breadthTraversalTable();
        //breadthTraversalMatrix();
    }

    private static void breadthTraversalTable() {
        int index = 0;
        breadthTable.addPre(0, -1);
        while (index != matrix.length - 1) {
            for (int i = 1; i < nodeTable.getLinkedList(index).getSize(); i++) {
                if (visited[nodeTable.getLinkedList(index).getNum(i)] == 0) {
                    breadthTable.addPre(nodeTable.getLinkedList(index).getNum(i), index);
                    visited[nodeTable.getLinkedList(index).getNum(i)] = 1;
                    if (nodeTable.getLinkedList(index).getNum(i) == 7) {
                        breadthTable.printBreadthTable();
                        return;
                    }
                }
            }
            index++;
        }
    }

    private static void breadthTraversalMatrix() {
        int index = 0;
        breadthTable.addPre(0, -1);
        while (index != matrix.length - 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[index][i] == 1 && visited[i] == 0) {
                    breadthTable.addPre(i, index);
                    visited[i] = 1;
                }
            }
            index++;
        }
        breadthTable.printBreadthTable();
    }

    private static void depthTraversalMatrix(int x) {
        if (x == matrix.length - 1) {
            print();
            return;
        }
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[x][j] == 1 && visited[j] == 0) {
                path[index++] = j;
                visited[j] = 1;
                length++;
                depthTraversalMatrix(j);
                length--;
                visited[j] = 0;
                index--;
            }
        }
    }

    private static void depthTraversalTable(int x) {
        if (x == matrix.length - 1) {
            print();
            return;
        }

        for (int i = 1; i < nodeTable.getLinkedList(x).getSize(); i++) {
            if (visited[nodeTable.getLinkedList(x).getNum(i)] == 0) {
                path[index++] = nodeTable.getLinkedList(x).getNum(i);
                visited[nodeTable.getLinkedList(x).getNum(i)] = 1;
                length++;
                depthTraversalTable(nodeTable.getLinkedList(x).getNum(i));
                visited[nodeTable.getLinkedList(x).getNum(i)] = 0;
                index--;
                length--;
            }
        }
    }

    private static void print() {
        for (int i = 0; i <= length; i++) {
            System.out.print(path[i] + 1 + " ");
        }
        System.out.println();
    }
}
