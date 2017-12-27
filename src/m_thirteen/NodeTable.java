package m_thirteen;

public class NodeTable {
    private LinkedList[] linkedLists;

    NodeTable(int[][] matrix) {
        linkedLists = new LinkedList[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            linkedLists[i] = addList(matrix[i], i);
        }
    }

    private LinkedList addList(int[] matrix, int num) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(num);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == 1) {
                linkedList.add(i);
            }
        }
        return linkedList;
    }

    void print() {
        for (LinkedList linkedList : linkedLists) {
            linkedList.print();
        }
    }
}
