package UI;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class MapGeneration extends JPanel {
    private final int[][] mapMatrix = {
            { 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
            { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 },
    };

    int[][] previousHexPoints = {
            {}
    };

    public MapGeneration() {
        initialize();
    };

    void initialize() {
        setBackground(Color.gray);
        setLayout(new BorderLayout());

        // for (int[] row : mapMatrix) {
        //     for (int value : row) {
        //         if (value == 1) {
        //             System.out.print('|');
        //         } else {
        //             System.out.print(' ');
        //         }
        //     }
        //     System.out.println(); // Move to the next line after each row
        // }

        add(new HexagonPanel());
    };

    private class HexagonPanel extends JPanel {
        private final Color defaultColor = Color.darkGray;
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            int[] xPoints = { 75, 75, 100, 125, 125, 100, 75 };
            int[] yPoints = { 50, 25, 0, 25, 50, 75, 50 };

            g2d.setColor(defaultColor); // Set the border color (you can change it to your desired color)
            g2d.fillPolygon(xPoints, yPoints, 7);

            // Draw the border of the polygon
            g2d.setColor(Color.BLACK); // Set the border color (you can change it to your desired color)
            g2d.setStroke(new BasicStroke(2));
            g2d.drawPolygon(xPoints, yPoints, 7);
            g2d.dispose();

        }
    };


}
