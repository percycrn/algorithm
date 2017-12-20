package g_seventhexp;

/*
 *
 * @程序名: Poke.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-11-15
 * @修改日期: 2017-11-15
 *
 */

import java.util.Scanner;

// 54张扑克牌，2个人轮流拿牌，每人每次最少取1张，最多取4张，谁拿最后一张谁输。编写模拟计算机先拿牌且必胜的算法。
public class Poke {
    private static int poke = 54;

    private static void take() {
        for (int i = 1; i <= 4; i++) {
            int x = poke - i;
            if ((x - 1) % 5 == 0) {
                poke = poke - i;
                System.out.println("computer take " + i);
                System.out.println("left poke " + poke);
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x;
        while (poke > 1) {
            take();
            if (poke == 1) {
                System.out.println("玩家输了");
                break;
            }
            System.out.println("请输入您要取的值");
            x = scanner.nextInt();
            poke -= x;
            System.out.println("剩余卡牌数 " + poke);
            if (poke == 1) {
                System.out.println("电脑输了");
                break;
            }
        }
    }
}
/*
1

2
3
4
5

6 给对面6 对面就输了

7
8
9
10

11 给对面11 对面就输了

12
13
14
15

16

17
18
19
20

21


*/