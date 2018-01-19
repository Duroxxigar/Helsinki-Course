package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubtractButtonClick implements ActionListener {

    private JTextField input, output;
    private JButton button;

    public SubtractButtonClick(JTextField input, JTextField output, JButton button) {
        this.input = input;
        this.output = output;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int inputNumber = Integer.parseInt(input.getText());
            int outputNumber = Integer.parseInt(output.getText());
            int difference = outputNumber - inputNumber;
            output.setText(String.valueOf(difference));
        } catch (NumberFormatException exception) {
            System.out.println("Input is not a number");
        } finally {
            input.setText("");
            button.setEnabled(true);
        }
    }
}