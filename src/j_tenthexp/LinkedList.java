package j_tenthexp;

        /*
         * @程序名: LinkedList.java
         * @编程人: 陈若楠 (学号: 1512480434)
         * @编程日期: 2017-12-06
         * @修改日期: 2017-12-06
         */

public class LinkedList {
    class Node {
        int height;
        int width;
        Node next;
        Node prev;

        private Node(int height, int width) {
            this.height = height;
            this.width = width;
            this.next = null;
            this.prev = null;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    void add(int height, int width) {
        Node l = last;
        Node node = new Node(height, width);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
            node.prev = l;
        }
        size++;
    }

    void print() {
        Node f = first;
        for (int i = 1; i <= size; i++) {
            System.out.println(f.height + " " + f.width);
            f = f.next;
        }
    }

    Node get(int i) {
        Node node = first;
        for (int j = 0; j < i - 1; j++) {
            node = node.next;
        }
        return node;
    }

    int getSize() {
        return size;
    }
}