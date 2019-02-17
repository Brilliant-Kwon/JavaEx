package JavaStudy.Fab_17;

import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    public Calculator() {
        JButton button[] = new JButton[16];

        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout grid = new GridLayout(4, 4);
        grid.setVgap(0);
        setLayout(grid);
        add(button[7] = new JButton("7"));
        add(button[8] = new JButton("8"));
        add(button[9] = new JButton("9"));
        add(button[10] = new JButton("+"));
        add(button[4] = new JButton("4"));
        add(button[5] = new JButton("5"));
        add(button[6] = new JButton("6"));
        add(button[11] = new JButton("-"));
        add(button[1] = new JButton("1"));
        add(button[2] = new JButton("2"));
        add(button[3] = new JButton("3"));
        add(button[12] = new JButton("*"));
        add(button[0] = new JButton("0"));
        add(button[15] = new JButton("C"));
        add(button[14] = new JButton("="));
        add(button[13] = new JButton("/"));

        setSize(300, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
