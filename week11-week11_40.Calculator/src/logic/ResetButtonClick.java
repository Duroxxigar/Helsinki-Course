package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonClick implements ActionListener {

    private JTextField input, output;
    private JButton button;

    public ResetButtonClick(JTextField input, JTextField output, JButton button) {
        this.input = input;
        this.output = output;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        output.setText(String.valueOf(0));
        input.setText("");
        button.setEnabled(false);
    }
}
