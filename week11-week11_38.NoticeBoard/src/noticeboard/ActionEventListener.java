package noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventListener implements ActionListener {

    private JTextField from;
    private JLabel to;

    public ActionEventListener(JTextField from, JLabel to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        to.setText(from.getText());
        from.setText("");
    }
}
