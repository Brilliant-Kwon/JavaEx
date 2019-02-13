package Fab_GUI.Fab_12;

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame { // 클래스 자체가 일단 JFrame임
    ContentPaneEx() { // 생성자
        setTitle("ContentPane과 JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //취소버튼누를 때
        //Exit_on_close의 역할을 수행 - 프레임 닫고, 응용 프로그램 종료

        Container contentPane = getContentPane(); //컨텐트 팬 알아내서 저장 - 프레임
        contentPane.setBackground(Color.ORANGE);//배경색 지정
        contentPane.setLayout(new FlowLayout()); //레이아웃 형식 지정
        contentPane.add(new JButton("OK")); //버튼 추가
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));

        setSize(400, 300);//프레임 사이즈 설정
        setVisible(true);//보이게 설정

    }

    public static void main(String[] args) {
        new ContentPaneEx();
    }
}
