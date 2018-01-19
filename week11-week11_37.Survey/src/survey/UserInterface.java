package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(300, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(new JLabel("Are you?"));

        container.add(new JCheckBox("Yes!"));
        container.add(new JCheckBox("No!"));

        container.add(new JLabel("Why?"));
        ButtonGroup btnGroup = new ButtonGroup();

        JRadioButton no = new JRadioButton("No reason.");
        JRadioButton fun = new JRadioButton("Because it is fun!");

        btnGroup.add(no);
        btnGroup.add(fun);

        container.add(no);
        container.add(fun);
        container.add(new JButton("Done!"));
    }

    public JFrame getFrame() {
        return frame;
    }
}
