package UI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class MapGeneration extends JPanel {
   

    public MapGeneration() {
        initialize();
    };

    void initialize() {
        setBackground(Color.gray);
        setLayout(new BorderLayout());

        // for (int[] row : mapMatrix) {
        // for (int value : row) {
        // if (value == 1) {
        // System.out.print('|');
        // } else {
        // System.out.print(' ');
        // }
        // }
        // System.out.println(); // Move to the next line after each row
        // }
        add(new MapTile());
        revalidate();
        repaint();
    };

}
