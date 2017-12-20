package c_thirdexp.hanoi;

/*
 *
 * @程序名: Paints.java
 * @编程人: 陈若楠 (学号: 1512480434)
 * @编程日期: 2017-10-21
 * @修改日期: 2017-10-21
 *
 */

import javax.swing.*;
import java.awt.*;

public class Paints extends JPanel {
    protected void paintComponent(Graphics g) {

        // Hanoi塔底座
        g.setColor(Color.gray); // 底座的颜色
        g.fillRect(100, 300, 250, 10); // x = x + width/2
        g.fillRect(450, 300, 250, 10);
        g.fillRect(800, 300, 250, 10);

        // 移动的矩形（其实是和已有的重合了，所以看不到）
        g.drawRect(Var.rectX1, Var.rectY, Var.rectX2 - Var.rectX1, 10);

        // Hanoi塔的初始化
        int rectYInit = 290;
        for (int i = 0; i <= Var.numOfTowerA; i++)
            g.drawRect(225 - (24 - Var.towerA[i]) * 5, rectYInit - 10 * i, (24 - Var.towerA[i]) * 10, 10);
        for (int i = 0; i <= Var.numOfTowerB; i++)
            g.drawRect(575 - (24 - Var.towerB[i]) * 5, rectYInit - 10 * i, (24 - Var.towerB[i]) * 10, 10);
        for (int i = 0; i <= Var.numOfTowerC; i++)
            g.drawRect(925 - (24 - Var.towerC[i]) * 5, rectYInit - 10 * i, (24 - Var.towerC[i]) * 10, 10);
    }
}