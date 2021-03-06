package clicker.ui;

import clicker.applicationlogic.Calculator;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel numberDisplay = new JLabel("0");
        JButton counter = new JButton("Click!");

        counter.addActionListener(new ClickListener(calculator, numberDisplay));
        container.add(numberDisplay);
        container.add(counter, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
