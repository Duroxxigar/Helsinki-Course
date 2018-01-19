package logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonClick implements ActionListener {

    private JTextField input, output;
    private JButton button;

    public AddButtonClick(JTextField input, JTextField output, JButton button) {
        this.input = input;
        this.output = output;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int inputNumber = Integer.parseInt(input.getText());
            int outputNumber = Integer.parseInt(output.getText());
            int sum = inputNumber + outputNumber;
            output.setText(String.valueOf(sum));
        } catch (NumberFormatException exception) {
            System.out.println("Input is not a number");
        } finally {
            input.setText("");
            button.setEnabled(true);
        }
    }
}
