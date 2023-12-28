import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import UI.*;

public class SolverUI extends JFrame {
    SolverUI() {
        initialize();
    };

    JLabel title() {
        JLabel title = new JLabel("IQ Six Pro Solver");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);
        return title;
    };

    JPanel figuresList() {
        JPanel figuresList = new JPanel();
        figuresList.setBackground(Color.darkGray);
        figuresList.setPreferredSize(new Dimension(100, 100));

        return figuresList;
    };

    JButton submit() {
        JButton submit = new JButton("SUBMIT");
        submit.setBackground(Color.red);

        return submit;
    };

    void initialize() {
        setTitle("IQSixPro SOLVER");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());
        panel.add(title(), BorderLayout.NORTH);
        panel.add(new MapGeneration(), BorderLayout.CENTER);
        panel.add(figuresList(), BorderLayout.WEST);
        panel.add(submit(), BorderLayout.SOUTH);
        getContentPane().add(panel);
        setVisible(true);
    };
};