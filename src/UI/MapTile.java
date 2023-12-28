package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

import javax.swing.JPanel;

public class MapTile extends JPanel {
    private final Color defaultColor = Color.darkGray;
    private final int[][] mapMatrix = {
            { 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
            { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0 },
            { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 },
    };

    MapTile() {
        addMouseListener(new HoverListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int[] originalXPoints = { 0, 0, 25, 50, 50, 25, 0 };
        int[] originalYPoints = { 50, 25, 0, 25, 50, 75, 50 };

        for (int Y_Coord = 0; Y_Coord < mapMatrix.length; Y_Coord++) {

            // Set initial Coords when changing the row
            int[] yPoints = Arrays.copyOf(originalYPoints, originalYPoints.length);

            // Increment by 50 points the YPoints for eachrow
            final int Yvalue = (Y_Coord + 1) * 50;
            Arrays.setAll(yPoints, indexX -> yPoints[indexX] + Yvalue);

            for (int X_Coord = 0; X_Coord < mapMatrix[0].length; X_Coord++) {
                // Increment by 25 points the XPoints for each column
                final int Xvalue = (X_Coord + 1) * 25;

                // Create a copy of original and add increment
                int[] xPoints = Arrays.copyOf(originalXPoints, originalXPoints.length);
                Arrays.setAll(xPoints, indexX -> xPoints[indexX] + Xvalue);

                if (mapMatrix[Y_Coord][X_Coord] == 0) {
                    continue;
                }

                g2d.setColor(defaultColor);
                g2d.fillPolygon(xPoints, yPoints, 7);

                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawPolygon(xPoints, yPoints, 7);
            }
        }
        g2d.dispose();
    }

    private class HoverListener extends MouseAdapter {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            // Handle hover effect, e.g., change the color
            setBackground(Color.lightGray);
        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {
            // Reset to the default color when the mouse exits
            setBackground(null);
        }
    }
}
