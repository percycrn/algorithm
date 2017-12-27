package m_thirteen;

public class LinkedList {
    class Node {
        int num;
        Node next;
        Node prev;

        private Node(int num) {
            this.num = num;
            this.next = null;
            this.prev = null;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    void add(int num) {
        Node l = last;
        Node node = new Node(num);
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
            System.out.print(f.num+" ");
            f = f.next;
        }
        System.out.println();
    }

}