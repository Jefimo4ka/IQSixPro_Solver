import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SolverUI {
    SolverUI() {
        start();
    };

    void start() {
        JPanel main = new JPanel();
        main.setBounds(0, 0, 150, 150);;
        main.setBackground(Color.BLACK);
        


        JFrame frame = new JFrame();
        frame.setTitle("SOLVER");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(420, 420);
        frame.setVisible(true);
        frame.add(main);
    };
}