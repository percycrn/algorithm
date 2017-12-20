package e_fifthexp;

/*
 *
 * @程序名: LinkedList.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-11-01
 * @修改日期: 2017-11-01
 *
 */

/*
 *
 *  约瑟夫环问题：已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。
 *  从编号为k的人开始报数，数到m的那个人出列；他的下一个人又从1开始报数，数到m的那个人又出列；
 *  依此规律重复下去，直到圆桌周围的人只剩下一个人。输出这个人在圈里的序号（要求用链表来求解）。
 *
 */

public class LinkedList<E> {
    private static class Node<E> {
        E num;
        Node<E> next;
        Node<E> prev;

        private Node(E num) {
            this.num = num;
            this.next = null;
            this.prev = null;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    void add(E num) {
        Node<E> l = last;
        Node<E> node = new Node<E>(num);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
            node.prev = l;
        }
        size++;
    }

    void concat() {
        last.next = first;
        first.prev = last;
    }

    public void print(int num) {
        Node<E> f = first;
        for (int i = 1; i <= num; i++) {
            System.out.println(f.num);
            f = f.next;
        }
    }

    void delete(Node node) {
        // if prev=next it means there's only one point left
        if (node.prev == node.next) {
            System.out.println(node.next.num);
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void cycleDelete(E location, int cycleLength) {
        Node<E> f = first;
        Node<E> p;

        //找到这个结点
        while (true) {
            if (f.num == location) {
                break;
            }
            f = f.next;
        }

        for (int i = 1; i <= size - 1; i++) {
            for (int j = 1; j <= cycleLength - 1; j++) { // 这里要减1
                f = f.next;
            }
            p = f;
            f = f.next;
            System.out.println("排除编号为" + p.num + "的人");
            delete(p);
        }
    }

}
