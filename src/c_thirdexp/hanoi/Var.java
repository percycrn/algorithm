package c_thirdexp.hanoi;

/*
 *
 * @程序名: Var.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-21
 * @修改日期: 2017-10-21
 *
 */

class Var {

    // tower中积木的数量
    static int numOfTowerA = 0, numOfTowerB = -1, numOfTowerC = -1, numOfTower = 0;

    // 待移动Hanoi塔的中间值及目标Hanoi塔的中间值，用于计算更新移动时积木的大小
    static int rectStartMid, rectEndMid;

    // 用于指示待移动Hanoi塔的积木数量及目标Hanoi塔的积木数量
    static int moveStartT, moveEndT;

    // tower中每层积木的编码，用于计算长度
    static int towerA[] = new int[23], towerB[] = new int[23], towerC[] = new int[23];

    // 用于中间变量
    static int tower[] = new int[23];

    // 待移动的方块
    static int rectX1, rectX2, rectY;

    // 积木移动方向
    static int direction;

    // 控制暂停
    static boolean stop1 = false;

    // 表示开始的标志
    static boolean startFlag = false;

    // 线程睡眠时间
    static int sTime = 7;

}
