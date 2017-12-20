package h_eighthexp.defectivechessboard;

import javax.swing.*;
import java.awt.*;

public class Paints extends JPanel {

    private int[][] chess;

    Paints(int[][] chess) {
        this.chess = chess;
    }

    protected void paintComponent(Graphics g) {
        for (int i = 1; i < chess.length; i++) {
            for (int j = 1; j < chess.length; j++) {
                Color color = new Color(chess[i][j] + 20, chess[i][j] * 10 + 10, chess[i][j] * 5 + 10);
                g.setColor(color);
                g.fillRect(10 + 50 * (j - 1), 10 + 50 * (i - 1), 50, 50);
            }
        }
    }
}
