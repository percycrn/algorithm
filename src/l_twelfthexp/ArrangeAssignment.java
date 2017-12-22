package l_twelfthexp;

/* 某一印刷厂有6项加工任务，对印刷车间和装订车间所需时间如表所示。
 * 完成每项任务都要先去印刷车间印刷，再去装订车间装订。
 * 问怎样安排这6项加工任务的加工工序，使得加工总工时最少。
 * 任务        J1    J2    J3    J4    J5    J6
 * 印刷车间     3     12    5     2     9     11
 * 装订车间     8     10    9     6     3     1
 */
public class ArrangeAssignment {
    public static void main(String[] args) {
        int[] print = new int[]{3, 12, 5, 2, 9, 11};
        int[] bookBind = new int[]{8, 10, 9, 6, 3, 1};
        int length = print.length;
        int[] time = new int[length];
        int[] status = new int[length];
        int[] order = new int[length];
        int positiveNum = 0;
        int moreTime = 0;
        int flag;
        int index = -1;
        int spaceBetween;
        for (int i = 0; i < length; i++) {
            time[i] = bookBind[i] - print[i];
        }
        // get quantity of positive number
        for (int i = 0; i < length; i++) {
            if (time[i] >= 0) {
                positiveNum++;
            }
        }
        // choose those whose time array is positive
        for (int j = 0; j < positiveNum; j++) {
            int i;
            flag = -20;
            for (i = 0; i < length; i++) {
                if (time[i] < 0 || status[i] != 0) {
                    continue;
                }
                if (flag < moreTime - print[i]) {
                    flag = moreTime - print[i];
                    index = i;
                }
            }
            order[j] = index;
            status[index] = 1;
            if (j == 0) {
                moreTime += bookBind[index];
            } else {
                moreTime += time[index];
            }
        }
        // choose those whose time array is negative
        spaceBetween = print[order[0]];
        for (int j = positiveNum; j < length; j++) {
            int i;
            flag = -20;
            for (i = 0; i < length; i++) {
                if (time[i] >= 0 || status[i] != 0) {
                    continue;
                }
                /* 因为moreTime - print[i]越大越好,time[i]也越大越好
                 * 因为(∑a_(i-1)-第i个作业印刷车间时间)的值越大，空闲时间越短，优先选择；
                 * a_i的值越大，消耗多余时间越少，优先选择。
                 */
                if (flag < moreTime - print[i] + time[i]) {
                    flag = moreTime - print[i] + time[i];
                    index = i;
                }
            }
            order[j] = index;
            status[index] = 1;
            if (moreTime - print[index] < 0) {
                spaceBetween -= (moreTime - print[index]);
            }
            moreTime += time[index];
        }
        // calculate time
        for (int i = 0; i < length; i++) {
            spaceBetween += bookBind[i];
        }
        System.out.println("the shortest time is " + spaceBetween);
        System.out.print("the order is");
        for (int i = 0; i < length; i++) {
            System.out.print(" " + (order[i] + 1));
        }
    }
}
