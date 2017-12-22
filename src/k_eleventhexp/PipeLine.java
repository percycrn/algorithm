package k_eleventhexp;

import java.io.*;

// 编程实现三条流水线的汽车装配流水线问题（输入从文本文件中导入）
public class PipeLine {

    public static void main(String[] args) {
        int[] line1, line2; // 流水线生产作业的时间
        int[] line1to2, line2to1; // 流水线转换的时间
        int[] line1SE, line2SE; // 流水线
        int[] f1, f2;
        int[][] ll = new int[2][];
        int f, l;
        int[] path;
        try {
            BufferedReader reader = new BufferedReader(new FileReader
                    (new File("F:\\30 IntelliJ IDEA JavaSrc\\algorithm\\src\\k_eleventhexp\\data")));
            line1 = strToInt(reader.readLine().split(" "));
            line2 = strToInt(reader.readLine().split(" "));
            line1to2 = strToInt(reader.readLine().split(" "));
            line2to1 = strToInt(reader.readLine().split(" "));
            line1SE = strToInt(reader.readLine().split(" "));
            line2SE = strToInt(reader.readLine().split(" "));
            f1 = new int[line1.length];
            f2 = new int[line1.length];
            ll[0] = new int[line1.length];
            ll[1] = new int[line1.length];
            path = new int[line1.length];
            f1[0] = line1SE[0] + line1[0];
            f2[0] = line2SE[0] + line2[0];
            // 假设到n-1时已经是最优选择了，现在选择第n个.
            // 分两种情况: 1 从己方流水线上来，时间为 f1[n-1] + line1[n]
            //            2 从对方流水线上来，时间为 f2[n-1] + line2To1[n-1] + line1[n]
            for (int i = 1; i < line1.length; i++) {
                if (f1[i - 1] + line1[i] <= f2[i - 1] + line2to1[i - 1] + line1[i]) {
                    f1[i] = f1[i - 1] + line1[i];
                    ll[0][i] = 1;
                } else {
                    f1[i] = f2[i - 1] + line2to1[i - 1] + line1[i];
                    ll[0][i] = 2;
                }
                if (f2[i - 1] + line2[i] <= f1[i - 1] + line1to2[i - 1] + line2[i]) {
                    f2[i] = f2[i - 1] + line2[i];
                    ll[1][i] = 2;
                } else {
                    f2[i] = f1[i - 1] + line1to2[i - 1] + line2[i];
                    ll[1][i] = 1;
                }
            }
            if (f1[line1.length - 1] + line1SE[1] <= f2[line1.length - 1] + line2SE[1]) {
                f = f1[line1.length - 1] + line1SE[1];
                l = 1;
            } else {
                f = f2[line1.length - 1] + line2SE[1];
                l = 2;
            }
            System.out.println("min " + f);
            path[line1.length - 1] = l;
            // ll数组中的值决定它来自于哪一个流水线
            for (int i = line1.length - 1; i >= 1; i--) {
                path[i - 1] = ll[path[i] - 1][i];
            }
            System.out.print("path: ");
            for (int i = 0; i < line1.length; i++) {
                System.out.print(path[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] strToInt(String[] str) {
        int[] ints = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            ints[i] = Integer.parseInt(str[i]);
        }
        return ints;
    }
}
