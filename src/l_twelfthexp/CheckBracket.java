package l_twelfthexp;

import java.util.Scanner;

/* 括号检验：输入一个代数表达式，表达式中只能含有+,-,*,/,(,),1,2,3,4,5,6,7,8,9,0字符
 * 且每个数字均小于10，假设表达式中除了括号匹配有错误外，再无其它错误。
 * 编写算法对输入的表达式进行检验，判断括号匹配是否正确。
 */
public class CheckBracket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the expression");
        String str = scanner.next();
        int flag = 0;
        char[] exp = str.toCharArray();
        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == '(') {
                flag++;
                if (i + 1 == exp.length) {
                    System.out.println("the last one can't be left bracket");
                    return;
                }
                if (i != 0 && String.valueOf(exp[i - 1]).matches("[0-9)]")) {
                    System.out.println("there must be operator or left bracket before left bracket");
                    return;
                }
                if (String.valueOf(exp[i + 1]).matches("[+-.*/)]")) {
                    System.out.println("there must be number or left bracket after left bracket");
                    return;
                }
            } else if (exp[i] == ')') {
                flag--;
                if (flag < 0) {
                    System.out.println("there's no corresponding left bracket before right bracket");
                    return;
                }
                if (String.valueOf(exp[i - 1]).matches("[+-.*/(]")) {
                    System.out.println("there must be number or right bracket before right bracket");
                    return;
                }
                if (i < exp.length - 1 && String.valueOf(exp[i + 1]).matches("[0-9(]")) {
                    System.out.println("there must be right bracket or operator after right bracket");
                    return;
                }
            }
        }
        if (flag > 0) {
            System.out.println("there's no enough right bracket");
            return;
        }
        System.out.println("expression is correct");
    }
}
