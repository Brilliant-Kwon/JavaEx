package Fab_GUI.Fab_12;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
    FlowLayoutEx(){
        setTitle("FlowLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
        add(new JButton("add"));
        add(new JButton("sub"));
        add(new JButton("mul"));
        add(new JButton("div"));
        add(new JButton("calculate"));

        setSize(300, 250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlowLayoutEx();

    }
}
