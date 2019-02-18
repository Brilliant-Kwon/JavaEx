package JavaStudy.Fab_17;
//찬근
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class CalApp extends JFrame {
    private ArrayList<String> arrayList = new ArrayList<>();//계산기 내의 String 을 분리하여 계산하기 위해 ArrayList 에 저장
    private int index = 0;//입력받은 문자열을 분리할 때 인덱스를 이용하기 위해 인덱스 선언

    private CalApp() {//자체가 JFrame 을 내장하고 있음.

        setTitle("사칙 연산 계산기");//JFrame 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//X를 눌렀을 때 프로세스가 끝나도록 설정

        setLayout(new BorderLayout());//JFrame 전체적인 레이아웃 설정

        JLabel showResult = new JLabel("");//계산기 출력창 JLabel 선언
        showResult.setFont(new Font("D2Coding", Font.BOLD, 40));//폰트 설정
        showResult.setHorizontalAlignment(JTextField.CENTER);//글자가 가운데 오도록 정렬

        JButton button[] = new JButton[16];//계산기 버튼 배열로 선언

        JPanel p_show = new JPanel(new GridLayout(1, 1));//계산기 출력창 JLabel 이 들어갈 JPanel 선언
        p_show.add(showResult);//JLabel 추가

        JPanel p = new JPanel(new GridLayout(4, 4, 0, 0)); //계산기 버튼이 들어갈 JPanel 선언

        //TODO: 실행하자마자 키보드 입력가능하게 만들기.
        requestFocus(); // 안 됨

        //TODO: 각각 JPanel 의 크기 조정가능하게 만들기
        p.setPreferredSize(new Dimension(300, 400)); //안 됨
        p_show.setPreferredSize(new Dimension(300, 100)); //안 됨


        //각 버튼에 내용 추가해서 JPanel 에 추가
        p.add(button[7] = new JButton("7"));
        p.add(button[8] = new JButton("8"));
        p.add(button[9] = new JButton("9"));
        p.add(button[10] = new JButton("+"));
        p.add(button[4] = new JButton("4"));
        p.add(button[5] = new JButton("5"));
        p.add(button[6] = new JButton("6"));
        p.add(button[11] = new JButton("-"));
        p.add(button[1] = new JButton("1"));
        p.add(button[2] = new JButton("2"));
        p.add(button[3] = new JButton("3"));
        p.add(button[12] = new JButton("*"));
        p.add(button[0] = new JButton("0"));
        p.add(button[15] = new JButton("C"));
        p.add(button[14] = new JButton("="));
        p.add(button[13] = new JButton("/"));

        for (int i = 0; i < 16; i++) {//버튼이 16개이므로 16번 반복
            button[i].setBackground(Color.DARK_GRAY); // 배경색
            button[i].setForeground(Color.white);   //글자색
            button[i].setFont(new Font("Consoles", Font.BOLD, 25));//폰트지정
            button[i].addActionListener(e -> {//각 버튼 별 액션 지정
                JButton btn = (JButton) e.getSource();  //버튼의 소스를 받아와서
                String str = btn.getText(); //버튼의 텍스트를 받아와서 str 문자열에 저장

                switch (str) {//받아온 텍스트로 switch 를 통해 행동 지정
                    case "0":
                        showResult.setText(showResult.getText() + "0");//숫자일 경우 출력창 기존 문자열 뒤에 숫자 더해줌
                        break;
                    case "1":
                        showResult.setText(showResult.getText() + "1");
                        break;
                    case "2":
                        showResult.setText(showResult.getText() + "2");
                        break;
                    case "3":
                        showResult.setText(showResult.getText() + "3");
                        break;
                    case "4":
                        showResult.setText(showResult.getText() + "4");
                        break;
                    case "5":
                        showResult.setText(showResult.getText() + "5");
                        break;
                    case "6":
                        showResult.setText(showResult.getText() + "6");
                        break;
                    case "7":
                        showResult.setText(showResult.getText() + "7");
                        break;
                    case "8":
                        showResult.setText(showResult.getText() + "8");
                        break;
                    case "9":
                        showResult.setText(showResult.getText() + "9");
                        break;
                    case "+":
                        if (showResult.getText().length() > 0 &&        //연산자일 경우 현재 출력창에 첫번째 문자가 연산자이면 안되고
                                showResult.getText().charAt(showResult.getText().length() - 1) != '+' && //연산자가 두번연속으로 나오면 안된다.
                                showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                            arrayList.add(showResult.getText().substring(index, showResult.getText().length()));        //arrayList 에 인덱스부터 연산자 앞의 숫자까지 잘라서 추가해주고
                            arrayList.add("+"); //연산자도 집어넣어준다.
                            showResult.setText(showResult.getText() + "+");//출력창에 연산자 붙혀준다.
                            index = showResult.getText().length();//현재 출력창 길이를 받아서 인덱스를 바꿔준다.
                        }
                        break;
                    case "-":
                        if (showResult.getText().length() > 0 &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                            arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                            arrayList.add("-");
                            showResult.setText(showResult.getText() + "-");
                            index = showResult.getText().length();
                        }
                        break;
                    case "*":
                        if (showResult.getText().length() > 0 &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                            arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                            arrayList.add("*");
                            showResult.setText(showResult.getText() + "*");
                            index = showResult.getText().length();
                        }
                        break;
                    case "/":
                        if (showResult.getText().length() > 0 &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                            arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                            arrayList.add("/");
                            showResult.setText(showResult.getText() + "/");
                            index = showResult.getText().length();
                        }
                        break;
                    case "C"://초기화
                        showResult.setText("");//출력창 지워주고
                        arrayList = new ArrayList<>();//어레이리스트까지 초기화
                        index = 0;//물론 인덱스도
                        break;
                    case "="://연산 결과 출력
                        if (showResult.getText().length() > 0 &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                                showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                            arrayList.add(showResult.getText().substring(index, showResult.getText().length()));//일단 마지막 숫자들 넣어주면
                            //arrayList 의 구성은 0,2,4... 짝수는 전부 숫자가 들어가있고,
                            // 홀수는 연산자가 들어가있음
                            for (int oper = 1; oper < arrayList.size(); oper += 2) {//연산자부터 전부 반복해줌 (곱셈 나눗셈이 우선이므로 먼저 반복)
                                if (arrayList.get(oper) != null) {//연산자가 들어있으면 null 이 아님
                                    if (arrayList.get(oper).equals("*")) {//곱셈일 경우
                                        arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) * Integer.parseInt(arrayList.get(oper + 1))));
                                        //연산자 뒷쪽의 list 에 연산값 저장
                                        arrayList.set(oper, null); //나머지 널 지정
                                        arrayList.set(oper - 1, null);
                                    } else if (arrayList.get(oper).equals("/")) {//나눗셈일 경우 똑같음
                                        arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) / Integer.parseInt(arrayList.get(oper + 1))));
                                        arrayList.set(oper, null);
                                        arrayList.set(oper - 1, null);
                                    }
                                }
                            }
                            ArrayList<String> tempList = new ArrayList<>();//tempList 를 만들고
                            for (String anArrayList : arrayList) {  //앞에서 곱셈 나눗셈 연산을 통해 null 이 많이 생겼기에
                                                                        //null 들을 전부 제거하고 다시 arrayList 를 만드는 작업
                                if (anArrayList != null) {              //null 이 아닌 것만
                                    tempList.add(anArrayList);          //tempList 에 저장해준다.
                                }
                            }
                            arrayList = tempList;                       //그리고 그 tempList 를 arrayList 에 다시 저장하면 null 제거 완료
                            for (int oper = 1; oper < arrayList.size(); oper += 2) {    //이제 덧셈 나눗셈 작업
                                if (arrayList.get(oper) != null) {                      //null 이 아닐 경우 (이 조건문 여기서는 빼도 될 것 같지만 일단 나뒀다.)
                                    if (arrayList.get(oper).equals("+")) {              //연산하여 뒷 인덱스에 저장.
                                        arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) + Integer.parseInt(arrayList.get(oper + 1))));
                                        arrayList.set(oper, null);
                                        arrayList.set(oper - 1, null);
                                    } else if (arrayList.get(oper).equals("-")) {
                                        arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) - Integer.parseInt(arrayList.get(oper + 1))));
                                        arrayList.set(oper, null);
                                        arrayList.set(oper - 1, null);
                                    }
                                }
                            }
                            tempList = new ArrayList<>();//똑같이 tempList 이용하여 새로 저장
                            for (String anArrayList : arrayList) {
                                if (anArrayList != null) {
                                    tempList.add(anArrayList);
                                }
                            }
                            arrayList = tempList;   //이렇게 하면 연산이 제대로 됬을 때 arrayList 는 0인덱스만 남을 것이다.
//                    for (int k = 0; k < arrayList.size(); k++)
//                        showResult.setText(showResult.getText() + "\n " + k + ": " + arrayList.get(k));

                            showResult.setText(arrayList.get(0));//결과를 출력한다.
                            index = 0;//연산이 끝났으므로 인덱스 초기화 해주고
                            arrayList = new ArrayList<>();//arrayList 또한 초기화 해준다.
                        }
                        break;
                }
                requestFocus();//안됨
            });
        }


        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {//키보드 입력
                char keyChar = e.getKeyChar();//키보드 입력받은 문자 하나를 가져와서 조건문으로 비교했다.
                //마우스와 다 같지만, 키보드는 스페이스바 엔터까지 되도록 하였다.
                if (keyChar == '0') {
                    showResult.setText(showResult.getText() + "0");
                } else if (keyChar == '1') {
                    showResult.setText(showResult.getText() + "1");
                } else if (keyChar == '2') {
                    showResult.setText(showResult.getText() + "2");
                } else if (keyChar == '3') {
                    showResult.setText(showResult.getText() + "3");
                } else if (keyChar == '4') {
                    showResult.setText(showResult.getText() + "4");
                } else if (keyChar == '5') {
                    showResult.setText(showResult.getText() + "5");
                } else if (keyChar == '6') {
                    showResult.setText(showResult.getText() + "6");
                } else if (keyChar == '7') {
                    showResult.setText(showResult.getText() + "7");
                } else if (keyChar == '8') {
                    showResult.setText(showResult.getText() + "8");
                } else if (keyChar == '9') {
                    showResult.setText(showResult.getText() + "9");
                } else if (keyChar == '+') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("+");
                        showResult.setText(showResult.getText() + "+");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == '-') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("-");
                        showResult.setText(showResult.getText() + "-");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == '*') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("*");
                        showResult.setText(showResult.getText() + "*");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == '/') {
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        arrayList.add("/");
                        showResult.setText(showResult.getText() + "/");
                        index = showResult.getText().length();
                    }
                } else if (keyChar == 'C') {
                    showResult.setText("");
                    arrayList = new ArrayList<>();//어레이리스트까지 초기화
                    index = 0;
                } else if (keyChar == '=' || keyChar == '\n' || keyChar == ' ') { //엔터나 스페이스바도 인식
                    if (showResult.getText().length() > 0 &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '+' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '-' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '*' &&
                            showResult.getText().charAt(showResult.getText().length() - 1) != '/') {
                        arrayList.add(showResult.getText().substring(index, showResult.getText().length()));
                        for (int oper = 1; oper < arrayList.size(); oper += 2) {
                            if (arrayList.get(oper) != null) {
                                if (arrayList.get(oper).equals("*")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) * Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                } else if (arrayList.get(oper).equals("/")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) / Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                }
                            }
                        }
                        ArrayList<String> tempList = new ArrayList<>();
                        for (String anArrayList : arrayList) {
                            if (anArrayList != null) {
                                tempList.add(anArrayList);
                            }
                        }
                        arrayList = tempList;
                        for (int oper = 1; oper < arrayList.size(); oper += 2) {
                            if (arrayList.get(oper) != null) {
                                if (arrayList.get(oper).equals("+")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) + Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                } else if (arrayList.get(oper).equals("-")) {
                                    arrayList.set(oper + 1, String.valueOf(Integer.parseInt(arrayList.get(oper - 1)) - Integer.parseInt(arrayList.get(oper + 1))));
                                    arrayList.set(oper, null);
                                    arrayList.set(oper - 1, null);
                                }
                            }
                        }
                        tempList = new ArrayList<>();
                        for (String anArrayList : arrayList) {
                            if (anArrayList != null) {
                                tempList.add(anArrayList);
                            }
                        }
                        arrayList = tempList;
//                    for (int k = 0; k < arrayList.size(); k++)
//                        showResult.setText(showResult.getText() + "\n " + k + ": " + arrayList.get(k));

                        showResult.setText(arrayList.get(0));
                        index = 0;
                        arrayList = new ArrayList<>();
                    }
                }
                requestFocus();
            }
        });

        add(p_show, BorderLayout.NORTH);//JFrame 에 JPanel 들 두개 다 추가해주는데, BorderLayout의 북, 가운데 쪽에 붙혔다.
        add(p, BorderLayout.CENTER);

        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 300) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 500) / 2);
        //화면의 중앙에 창위치 설정해줌.

        setSize(300, 500);//창 크기 설정
        setVisible(true);//창 보이게 설정
        requestFocus();//안 됨
    }

    public static void main(String[] args) {
        new CalApp();
    }//메인에서는 클래스 불러오기만 하면 실행 된다.


}

