package JavaStudy.Fab_17;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        JLabel label = (JLabel) e.getSource();
        if (btn.getText().equals("0")) {
            label.setText(label.getText()+"0");
        }
    }
}
