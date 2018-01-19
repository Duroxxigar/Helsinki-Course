package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Copy");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3,1));
        JTextField writeTo = new JTextField();
        JButton copy = new JButton("Copy!");
        JLabel copied = new JLabel();

        ActionEventListener copier = new ActionEventListener(writeTo, copied);
        copy.addActionListener(copier);

        container.add(writeTo);
        container.add(copy);
        container.add(copied);
    }
}
