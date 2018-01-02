package m_thirteen.util;

public class LinkedList {
    class Node {
        int num;
        boolean status;
        int pre;
        Node next;
        Node prev;

        private Node(int num) {
            this.num = num;
            this.status = false;
            this.pre = -1;
            this.next = null;
            this.prev = null;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    public void add(int num) {
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

    public void addPre(int num, int pre) {
        Node l = last;
        Node node = new Node(num);
        node.pre = pre;
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
            node.prev = l;
        }
        size++;
    }

    public void printBreadthTable() {
        Node l = last;
        System.out.print((l.num + 1));
        while (l.num != -1) {
            l = getNumBreadthTable(l.pre);
            if (l == null) {
                return;
            }
            System.out.print("--" + (l.num + 1));
        }
    }

    private Node getNumBreadthTable(int pre) {
        Node f = first;
        while (f.next != null) {
            if (f.num == pre) {
                return f;
            }
            f = f.next;
        }
        return null;
    }

    public int getNum(int x) {
        Node f = first;
        for (int i = 0; i < x; i++) {
            f = f.next;
        }
        return f.num;
    }

    public boolean getStatus(int x) {
        Node f = first;
        for (int i = 0; i < x; i++) {
            f = f.next;
        }
        return f.status;
    }

    public void setStatus(int x, boolean flag) {
        Node f = first;
        for (int i = 0; i < x; i++) {
            f = f.next;
        }
        f.status = flag;
    }

    public int getSize() {
        return size;
    }

    void print() {
        Node f = first;
        for (int i = 0; i < size; i++) {
            System.out.print(f.num + " ");
            f = f.next;
        }
        System.out.println();
    }

}