package JavaStudy.Fab_19;

import javax.swing.*;
import java.awt.*;

class chickThread extends JFrame implements Runnable {

    JLabel chicklabel;
    Point max = new Point(800, 0);
    Point min = new Point(0, 0);
    int x = 0;
    int y = 0;

    Container contentPane = getContentPane();

    public chickThread(JLabel chicklabel) {
        this.chicklabel = chicklabel;
        this.chicklabel.setLocation(x, y);
        setContentPane(contentPane);
        contentPane.add(chicklabel);
    }

    @Override
    public void run() {
        while (true) {
            if (!chicklabel.getLocation().equals(max)) {
                chicklabel.setLocation(x++, y);
            }
        }
    }
}

public class ShootingApp extends JFrame {

    JLabel textlabel = new JLabel("맞췄습니다.");

    ImageIcon source = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
    Image before = source.getImage();
    Image after = before.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon chick = new ImageIcon(after);
    JLabel resizedlabel = new JLabel(chick, SwingConstants.LEFT);

    public ShootingApp() {
        setTitle("사격 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        textlabel.setFont(new Font("Consoles", Font.BOLD, 15));
        textlabel.setLocation(350, 130);
        textlabel.setSize(100, 20);

        resizedlabel.setLocation(0, 0);
        resizedlabel.setSize(100, 100);

        contentPane.add(textlabel);
        contentPane.add(resizedlabel);

        contentPane.setBackground(Color.ORANGE);

        Thread a = new Thread(new chickThread(resizedlabel));
        a.start();

        setSize(800, 500);
        setVisible(true);
        requestFocus();
    }

    public static void main(String[] args) {
        new ShootingApp();
    }


}
