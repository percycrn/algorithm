package e_fifthexp;

/*
 *
 * @程序名: JosephCircle.java
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

import java.util.Scanner;

public class JosephCircle {
    public static void main(String[] args) {
        System.out.println("请输入总人数，起始点，出圈数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int num = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();
        LinkedList<Integer> people = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            people.add(i);
        }
        people.concat(); // connect the head and the tail
        //people.print(20);
        people.cycleDelete(num, m); // delete the number that meet the requirement
        //people.testDelete();
    }
}