package a_firstexp;

import java.util.Scanner;

public class JudgeInPolygonBeta {
    // 凸多边形：任意两点形成的直线，所有点在这条直线的一边。

    private static double[][] arr;
    private static int num;
    private static double[][] point = new double[1][2];
    private static int flagz = 0, flagy = 0, flagMid = 0; // 检验该点在各个向量左边或右边或过该向量

    public static void main(String[] args) {

        // 输入凸多边形的点
        System.out.println("输入点的数量：");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        arr = new double[num][2];
        for (int i = 0; i < num; i++) {
            arr[i][0] = scanner.nextDouble();
            arr[i][1] = scanner.nextDouble();
        }
        point[0][0] = scanner.nextDouble();
        point[0][1] = scanner.nextDouble();

        // 检查是否是凸多边形
        // 循环，从第一个顶点出发，找到另一个点组成的线，使所有的点在这条线的一边，之后通过另一个点再找一个点也满足上述条件，一直将N个点找完
        // 如果找完并满足条件则这就是个凸多边形
        Integer lastPoint = null, i = 0, j;
        int flag;
        int[] used = new int[num];//经过这个点后，这个点就不能再用了
        for (int k = 0; k < num; k++) {
            flag = 0;
            for (j = 0; j < num; j++) {
                if (i.equals(j) || used[j] == 1 || j.equals(lastPoint)) {//这个点不能找自己也不能找上一个点
                    continue;
                } else if (checkPolygon(arr[i][0], arr[i][1], arr[j][0], arr[j][1])) {
                    checkPoint(arr[i][0], arr[i][1], arr[j][0], arr[j][1], point[0][0], point[0][1]);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                used[j] = 1;
                lastPoint = i;
                i = j;
            } else {
                //System.out.print(j + " ");
                System.out.println("不能构成凸多边形");
                return;
            }
            /*System.out.print(j + " ");
            for (int m = 0; m < num; m++) {
                System.out.print(used[m] + " ");
            }
            System.out.println();*/
        }
        System.out.println("可构成凸多边形");

        if ((flagz == 0 && flagy != 0) || (flagz != 0 && flagy == 0)) {
            if (flagMid == 2) {
                System.out.println("点在凸多边形顶点上");
            } else if (flagMid == 1) {
                System.out.println("点在凸多边形边上");
            } else {
                System.out.println("点在凸多边形内部");
            }
        } else {
            System.out.println("点在凸多边形外部");
        }
        // 检查点是否在凸多边形内

    }

    //检查点是否在线的一边
    private static boolean checkPolygon(double x1, double y1, double x2, double y2) {
        double k, b; // k为斜率
        int flag1 = 0, flag2 = 0;
        if (x1 == x2) {
            for (int i = 0; i < num; i++) {
                if (arr[i][0] < x1) {
                    flag1++;
                } else if (arr[i][0] > x1) {
                    flag2++;
                }
            }
        } else {
            k = (y1 - y2) / (x1 - x2);
            b = y1 - k * x1;
            for (int i = 0; i < num; i++) {
                if (arr[i][1] < k * arr[i][0] + b) {
                    flag1++;
                } else if (arr[i][1] > k * arr[i][0] + b) {
                    flag2++;
                } else {
                    continue;
                }
            }
        }
        if (flag1 == 0 && flag2 == 0) {
            return false;
        } else if (flag1 == 0 || flag2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //检查个这点在向量的左边或右边
    private static void checkPoint(double x1, double y1, double x2, double y2, double x3, double y3) {
        // 分四个区域讨论
        Double k1 = (y2 - y1) / (x2 - x1);
        Double k2 = (y3 - y1) / (x3 - x1);
        if (y1 == y2 && x1 < x2) { // x轴正方向
            if (y1 < y3) {
                flagz++;
            } else if (y1 == y3) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 < x2 && y1 < y2) { //第一象限
            if (k1 < k2) {
                flagz++;
            } else if (k1.equals(k2)) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 == x2 && y1 < y2) { // y轴正方向
            if (x1 > x3) {
                flagz++;
            } else if (x1 == x3) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 > x2 && y1 < y2) { // 第二象限
            if (k1 < k2) {
                flagz++;
            } else if (k1.equals(k2)) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 > x2 && y1 == y2) { // x轴负半轴
            if (y1 > y3) {
                flagz++;
            } else if (y1 == y3) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 > x2 && y1 > y2) { // 第三象限
            if (k1 < k2) {
                flagz++;
            } else if (k1.equals(k2)) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 == x2 && y1 > y2) { // y轴负半轴
            if (x1 < x3) {
                flagz++;
            } else if (x1 == x3) {
                flagMid++;
            } else {
                flagy++;
            }
        } else if (x1 < x2 && y1 > y2) { // 第四象限
            if (k1 < k2) {
                flagz++;
            } else if (k1.equals(k2)) {
                flagMid++;
            } else {
                flagy++;
            }
        }
    }
}
