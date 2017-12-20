package f_sixthexp;

/*
 *
 * @程序名: TrimExpression.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-08
 * @修改日期: 2017-10-08
 *
 */

import java.util.Scanner;

/**
 * 键盘输入一个含有括号的四则运算表达式，可能含有多余的括号。编写一个算法整理该表达式，
 * 去掉所有多余的括号。原表达式中所有变量和运算符相对位置保持不变，并保持与原表达式等价。
 */

public class TrimExpression {
    public static void main(String[] args) {
        System.out.println("请输入四则运算表达式");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        char[] arr = str.toCharArray();
        LinkedList exp = new LinkedList();
        for (char anArr : arr) {
            exp.add(anArr);
        }
        exp.modify();
        System.out.println("除去多余括号后");
        exp.print();
    }
}