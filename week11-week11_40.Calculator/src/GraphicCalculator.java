
import logic.AddButtonClick;
import logic.ResetButtonClick;
import logic.SubtractButtonClick;

import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(500, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        LayoutManager layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JTextField result = new JTextField("0");
        result.setEnabled(false);
        JTextField input = new JTextField();

        container.add(result);
        container.add(input);
        container.add(createJPanel(input, result));
    }

    private JPanel createJPanel(JTextField input, JTextField result) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton addBTN = new JButton("+");
        JButton subtractBTN = new JButton("-");
        JButton resetBTN = new JButton("Z");

        AddButtonClick addClick = new AddButtonClick(input, result, resetBTN);
        addBTN.addActionListener(addClick);

        SubtractButtonClick subClick = new SubtractButtonClick(input, result, resetBTN);
        subtractBTN.addActionListener(subClick);

        ResetButtonClick resetClick = new ResetButtonClick(input, result, resetBTN);
        resetBTN.addActionListener(resetClick);
        resetBTN.setEnabled(false);

        panel.add(addBTN);
        panel.add(subtractBTN);
        panel.add(resetBTN);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}