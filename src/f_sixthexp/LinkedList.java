package f_sixthexp;

/*
 *
 * @程序名: LinkedList.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-11-08
 * @修改日期: 2017-11-08
 *
 */

public class LinkedList {
    private static class Node {
        char character;
        Node next;
        Node prev;

        private Node(char character) {
            this.character = character;
            this.next = null;
            this.prev = null;
        }
    }

    private Node first;
    private Node last;
    private int size = 0;

    void add(char num) {
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

    public void print() {
        Node f = first;
        for (int i = 1; i <= size; i++) {
            System.out.print(f.character);
            f = f.next;
        }
    }

    private void delete(Node node) {
        if (node == first) {
            first = node.next;
        } else if (node == last) {
            node.prev.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    void modify() {
        Node f = first, leftB, rightB, f2;
        char left = '@', right = '@';
        while (f != null) {
            if (f.character == '(') {
                leftB = f; // record the point of left bracket
                if (f.prev != null) {
                    // record the value of the point rightwards the left bracket
                    left = f.prev.character;
                }
                while (f.character != ')') { // find the right bracket
                    f = f.next;
                }
                rightB = f;
                if (f.next != null) {
                    right = f.next.character;
                }
                if (left == '-') { // change the signal after the minus
                    f2 = leftB;
                    while (f2 != rightB) {
                        if (f2.character == '-') {
                            f2.character = '+';
                        } else if (f2.character == '+') {
                            f2.character = '-';
                        }
                        f2 = f2.next;
                    }
                }
                //delete the redundant brackets
                if ((left == '@' || left == '+' || left == '-') && (right == '@' || right == '+' || right == '-')) {
                    delete(leftB);
                    delete(rightB);
                }
            }
            f = f.next;
        }
    }
}