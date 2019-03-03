package JavaStudy.Mar_03.KCK;

import javax.swing.*;
import java.awt.*;

public class ChattingGUI_Ex extends JFrame {
    private ChattingGUI_Ex() {
        Container con = getContentPane();
        setTitle("서버 GUI 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가 끝나도록 설정

        setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

        JLabel title = new JLabel("채팅 : 서버");
        title.setBackground(Color.ORANGE);
        title.setOpaque(true);
        con.add(title, BorderLayout.NORTH);

        JTextArea getChat = new JTextArea();
        JScrollPane Dialog = new JScrollPane(getChat);
        Dialog.setBackground(Color.ORANGE);
        Dialog.setOpaque(true);
        con.add(Dialog, BorderLayout.CENTER);

        getChat.setText("1, ");

        for (int i = 0; i < 40; i++)
            getChat.setText(getChat.getText() + "2\n");

        JTextField input = new JTextField();
        con.add(input, BorderLayout.SOUTH);

        con.setSize(300, 500);
        setSize(300, 500);//창 크기 설정
        setVisible(true);//창 보이게 설정
    }

    public static void main(String[] args) {
        ChattingGUI_Ex a = new ChattingGUI_Ex();
    }
}
