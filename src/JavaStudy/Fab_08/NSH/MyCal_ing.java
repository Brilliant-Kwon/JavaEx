package JavaStudy.Fab_08.NSH;
//성헌

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCal_ing extends JFrame implements ActionListener {
    /*
     * 표준 계산기 만들기
     * 구현해야 할 기능
     * 1. 사칙연산(이어서 연산도 가능해야함 2+5-3*6 = ?)
     * 2. =을 눌렀을 때 결과값에서 숫자를 누르면 새로운 연산을 시작하고, 연산자를 누르면 결과값에 이어서 연산
     * 3. 연산자를 눌렀다가 바꾸면 바꾼 연산자로 작동
     * 4. 연산자 우선 순위는 없고 입력한 순서대로 연산
     *
     * 해결하지 못한 부분
     * 1. 숫자가 들어갈 때 마다 연산을 실행하는데, 한자리 숫자이면 문제 없는데 두 자리수 이상부터는 문제
     * 2. 0으로 나누는 부분 try catch? 일단 0으로 나누었을 때는 결과를 0으로 만드는 것으로 해둠.
     * 3. GUI 구현 부분
     */

    JTextField T1;    // 결과를 띄울 텍스트 필드 생성
    JTextField T2;    // 계산 과정을 띄울 텍스트 필드 생성
    JButton Button[] = new JButton[16];    // 0~9, +,-,*,/ 넣을 버튼 생성
    JPanel P1, P2; // 공간 2개 생성
    int num, temp, result;    // 숫자들을 담을 정수 선언
    int tt;
    String oper = "";
    String next = "";    // 연산자, 다음숫자, 과정을 받을 스트링 선언
    String process = "";
    boolean opState = false;    // 연산자가 들어가 있는지 확인하는 플래그
    boolean numCom = false;        // 숫자가 완성되었는지 확인하는 플래그
    boolean numState = false;
    boolean isfinish = false;

    MyCal_ing() {    // 계산기 생성자
        setTitle("나의 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        T1 = new JTextField("", 15);
        T2 = new JTextField("", 15);
        P1 = new JPanel();
        P2 = new JPanel();

        P1.setLayout(new GridLayout(2, 1));    // 결과창 들어갈 판넬 P1
        P2.setLayout(new GridLayout(4, 4, 10, 10));    // 숫자들 들어갈 판넬 P2

        P1.add(T2);
        P1.add(T1);    // 텍스트파일 T1,T2을 판넬 P1에 추가

        String btnVal[] = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/"};    // 버튼 16개 생성
        for (int i = 0; i <= 15; i++) {
            Button[i] = new JButton(btnVal[i]);
            P2.add(Button[i]);
            Button[i].addActionListener(this);
        }
        // 각각 판넬을 컴포넌트에 추가
        add("North", P1);
        add("Center", P2);

        setSize(300, 400);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();    // 버튼을 누르면 이벤트가 input에 저장
        if (input.equals("+")) {    //	각각 기호에 맞게 연산자를 정하고 다음 받을 숫자를 비움
            if (opState) {        // ★ 연산자가 중복되었으면 과정을 띄우는 string에서 마지막 인덱스를 없애줌.
                process = process.substring(0, process.length() - 1);
            }
            opState = true;    //	연산자가 들어오면 opState = true
            numState = false;
            oper = "+";
            next = "";
            if (result == 0) {
                T1.setText(String.valueOf(num));
            } else {
                T1.setText(String.valueOf(result));
            }
            process += e.getActionCommand();    // 방금 비운 process string에 현재 oper를 넣어줌
            T2.setText(process);    //	과정 띄우는 창에 출력
        } else if (input.equals("-")) {
            if (opState) {
                process = process.substring(0, process.length() - 1);
            }
            opState = true;
            numState = false;
            oper = "-";
            next = "";
            if (result == 0) {
                T1.setText(String.valueOf(num));
            } else {
                T1.setText(String.valueOf(result));
            }
            process += e.getActionCommand();
            T2.setText(process);
        } else if (input.equals("*")) {
            if (opState) {
                process = process.substring(0, process.length() - 1);
            }
            opState = true;
            numState = false;
            oper = "*";
            next = "";
            if (result == 0) {
                T1.setText(String.valueOf(num));
            } else {
                T1.setText(String.valueOf(result));
            }
            process += e.getActionCommand();
            T2.setText(process);
        } else if (input.equals("/")) {
            if (opState) {
                process = process.substring(0, process.length() - 1);
            }
            opState = true;
            numState = false;
            oper = "/";
            next = "";
            if (result == 0) {
                T1.setText(String.valueOf(num));
            } else {
                T1.setText(String.valueOf(result));
            }
            process += e.getActionCommand();
            T2.setText(process);
        } else if (input.equals("C")) {    //	C가 입력되면 초기화
            next = "";
            temp = 0;
            num = 0;
            oper = "";
            result = 0;
            process = "";
            tt = 0;
            T1.setText("0");
            T2.setText("");
        } else if (input.equals("=")) {    // 연산은 밑에서 작동하므로 =의 역할은 그냥 결과값을 출력해주는 용도
            T1.setText(String.valueOf(result));
            next = "";
            process = "";
            oper = "";
            T2.setText("");
            isfinish = true;

        } else {    // 입력받은 input이 숫자일 경우(연산자,=,C가 다 아닌경우)
            if (isfinish) {
                result = 0;
            }
            next += e.getActionCommand();    // 연산자가 아니라 숫자가 들어오면 계속 이어서 붙임
            T1.setText(next);
            process += e.getActionCommand();    // 숫자, 연산자 다 붙임 이것은 맨위에 input을 받을 때 써도 관계 없을 듯
            T2.setText(process);
            temp = Integer.parseInt(next);    // 그 붙인것들을 정수형으로 변환하여 temp에 임시 저장

            opState = false;    // 숫자를 받았으니 opState = false;

            if ((oper == "+" | oper == "-" | oper == "*" | oper == "/")) {
                if (oper.equals("+")) {
                    if (numState) {
                        result = num + temp - tt;
                    } else {
                        result = num + temp;
                    }
                    num = result;

                } else if (oper.equals("-")) {
                    if (numState) {
                        result = num - temp + tt;
                    } else {
                        result = num - temp;
                    }
                    num = result;
                } else if (oper.equals("*")) {
                    if (numState) {
                        result = num * temp / tt;
                    } else {
                        result = num * temp;
                    }
                    num = result;
                } else if (oper.equals("/")) {
                    if (temp == 0) {    //	0으로 나누면 에러인데 그냥 결과를 0으로 넣음
                        result = 0;
                    } else {
                        if (numState) {
                            result = num / temp * tt;
                        } else {
                            result = num / temp;
                        }
                    }
                    num = result;
                }

            } else {
                num = temp;
            }

            tt = temp;
            numState = true;
            isfinish = false;
        }


    }

    public static void main(String[] args) {
        new MyCal_ing();
    }
}
