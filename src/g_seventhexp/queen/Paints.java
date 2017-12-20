package g_seventhexp.queen;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;

public class Paints extends JPanel {

    private int[][] chessPaint;

    Paints(int[][] chess) {
        this.chessPaint = chess;
    }

    @Override
    public void paintComponent(Graphics g) {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (chessPaint[i][j] == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.black);
                }
                g.fillRect(20 + 20 * i, 20 + 20 * j, 20, 20);
            }
        }
        g.setColor(Color.gray);
        for (int i = 0; i <= 8; i++) {
            g.drawLine(40, 40 + 20 * i, 200, 40 + 20 * i);
            g.drawLine(40 + 20 * i, 40, 40 + 20 * i, 200);
        }
    }
}
