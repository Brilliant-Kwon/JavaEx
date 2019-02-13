package Fab_GUI.Fab_12;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    BorderLayoutEx(){
        setTitle("BorderLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        add(new JButton("add"),BorderLayout.NORTH);
        add(new JButton("sub"),BorderLayout.SOUTH);
        add(new JButton("mul"),BorderLayout.EAST);
        add(new JButton("div"),BorderLayout.WEST);
        add(new JButton("calculate"),BorderLayout.CENTER);

        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}
