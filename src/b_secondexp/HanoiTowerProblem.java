package b_secondexp;

import java.util.Scanner;

public class HanoiTowerProblem {
    private static int i = 1;

    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        hanio(n, '1', '2', '3');
        System.out.println("最后总的步数为" + (i - 1));
    }

    private static void move(int n, char from, char to) {
        System.out.println("第" + i++ + "步:将" + n + "号盘子" + from + "---->" + to);
    }

    //汉诺塔递归函数
    //n表示要将多少个"圆盘"从起始柱子移动至目标柱子
    //start_pos表示起始柱子,tran_pos表示过渡柱子,end_pos表示目标柱子
    private static void hanio(int n, char start_pos, char tran_pos, char end_pos) {
        if (n == 1) {    //很明显,当n==1的时候,我们只需要直接将圆盘从起始柱子移至目标柱子即可.
            move(n, start_pos, end_pos);
        } else {
            hanio(n - 1, start_pos, end_pos, tran_pos);   //递归处理,一开始的时候,先将n-1个盘子移至过渡柱上
            move(n, start_pos, end_pos);                //然后再将底下的大盘子直接移至目标柱子即可
            hanio(n - 1, tran_pos, start_pos, end_pos);    //然后重复以上步骤,递归处理放在过渡柱上的n-1个盘子
            //此时借助原来的起始柱作为过渡柱(因为起始柱已经空了)
        }
    }

}
