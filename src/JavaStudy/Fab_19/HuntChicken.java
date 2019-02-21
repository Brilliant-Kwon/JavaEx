package JavaStudy.Fab_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class missileThread extends JFrame implements Runnable {
    Container container; //상속받은 미사일을 담는 컨테이너
    static JLabel missile;  //미사일 라벨
    int miss_y = 440; // 미사일 y좌표 시작점

    public missileThread(JLabel misslabel, Container container) { //미사일 쓰레드 생성자
        this.container = container; //컨테이너와
        this.missile = misslabel;   //미사일 라벨을 상속 받는다.
        this.missile.setSize(20, 20);       //미사일의 크기를 지정해주고
        this.missile.setLocation(390, 450);         //미사일의 시작 좌표를 지정해준다.
        this.container.add(this.missile);                   //미사일을 컨테이너에 추가해준다.
    }

    @Override
    public void run() {         //쓰레드 시작시 돌아가는 메서드
        System.out.println("미사일 발사 시작");        //콘솔창 확인용 출력 문구
        while (true) {      //무한 반복한다.
            try {
                Thread.sleep(10);       //0.01초 간격으로 미사일이 움직이게 설정했다.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            miss_y -= 10;               //미사일이 움직이는 y좌표 간격 10
            missile.setLocation(390, miss_y);       //미사일의 좌표를 반영하여 설정해준다. (움직임 표현)
            if (miss_y < -10) {         //미사일이 -10보다 작으면 반복문을 멈춤
                break;
            }
        }
        System.out.println("미사일 발사 끝");         //확인용 콘솔 문구
    }
}

public class HuntChicken extends JFrame implements Runnable {       //메인 메서드 포함된 클래스 (닭이 움직이는 쓰레드 포함)
    Container contentPane = getContentPane();               //메인 컨테이너 contentPane을 명시하기 위해 getContentPane을 이용하여 변수로 지정

    JLabel textlabel = new JLabel();                        //맞췄을 때 뜨는 텍스트 문구 라벨
    JLabel rectlabel = new JLabel("나는 탱크다.");     //미사일을 발사할 발사대 탱크 라벨
    JLabel missile = new JLabel();                          //미사일 라벨

    //닭/치킨 이미지를 포함한 사이즈 조정 라벨 100x100으로 사이즈 지정하기 위한 과정
    ImageIcon source = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\chicken.png");
    ImageIcon fried = new ImageIcon("C:\\Users\\k1212\\bitacademy\\Java_Ex\\src\\JavaStudy\\Fab_19\\images\\fried.jpg");
    Image before = source.getImage();
    Image after = before.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    ImageIcon chick = new ImageIcon(after);
    JLabel resizedlabel = new JLabel(chick, SwingConstants.LEFT);
    int x = 0;//닭이 움직이는 x, y 좌표  초기값 0, 0
    int y = 0;

    public HuntChicken() {          //생성자
        setTitle("사격 게임");          //타이틀 지정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         //종료 지정

        setContentPane(contentPane);        //컨테이너 지정 및 명시
        contentPane.setLayout(null);        //레이아웃 매니저 없음 지정

        textlabel.setFont(new Font("Consoles", Font.BOLD, 15));     //문구 폰트 지정
        textlabel.setLocation(350, 130);        //문구 위치 지정
        textlabel.setSize(100, 20);     //문구 라벨의 사이즈 지정 (폰트 사이즈 아님 )

        //나는 탱크다
        rectlabel.setHorizontalAlignment(SwingConstants.CENTER);    //'나는 탱크다' 문구의 정렬을 가운데로 지정
        rectlabel.setSize(100, 50);                 //탱크 라벨의 사이즈 지정
        rectlabel.setLocation(350, 462);                    //탱크 라벨의 위치 지정
        rectlabel.setBackground(Color.GREEN);                       //탱크 라벨의 배경 색 지정
        rectlabel.setOpaque(true);                                  //배경색을 불투명하게 지정
                            // (기본값이 투명값 = false로 설정되어 있어서 true를 하면 불투명하게 바꿀 수 있다.)

        //미사일
        missile.setLocation(390, 450);                      //미사일의 시작점 지정 (미사일 쓰레드와 어느정도 중복)
        missile.setBackground(Color.red);                       //미사일의 배경색 지정
        missile.setOpaque(true);                                //미사일의 배경색 불투명 지정

        //닭
        resizedlabel.setLocation(1, 0);                 //닭의 출발점 지정
        resizedlabel.setSize(100, 100);         //닭의 사이즈 지정

        contentPane.add(textlabel);                         //각 라벨들 추가 (미사일은 쓰레드 내에서 추가했다. )
        contentPane.add(rectlabel);
        contentPane.add(resizedlabel);

        contentPane.setBackground(Color.ORANGE);            //게임의 배경색 지정

        addKeyListener(new KeyAdapter() {                   //엔터키 인식을 위한 키 리스터 지정
            @Override
            public void keyTyped(KeyEvent e) {//키보드 입력
                char keyChar = e.getKeyChar();          //키보드에 입력된 키 값이
                if (keyChar == '\n') {                  //엔터일 경우
                    //미사일 - 스레드
                    Thread missThread = new Thread(new missileThread(missile, contentPane)); //미사일 쓰레드 객체 선언
                    if (missThread.getState() == Thread.State.NEW) {            //미사일 쓰레드가 중복되지 않게 해보려
                                                    //했으나... 실패한 부분
                        System.out.println("엔터키 입력받음."); //콘솔 확인용 출력
                    }
                    missThread.start();                 //미사일 쓰레드 실행
                }
            }
        });
        //JFrame 설정
        setSize(800, 550); // 게임 화면 사이즈
        setResizable(false);            //게임 화면 사이즈 마우스로 조정 불가능하게 설정
        setVisible(true);               //게임 화면을 띄워주게 함
    }

    int go = 1; // 닭 움직이는 방향 설정
    //1 : 오른쪽 0 : 왼쪽

    @Override
    public void run() {         //닭이 움직이는 쓰레드 메서드 (따지자면 메인 쓰레드 )
        while (true) {  //무한 반복
            double miss_x = missile.getLocation().getX();      //미사일과 닭의 각 좌표를 분리해서 변수로 설정했다.
            double miss_y = missile.getLocation().getY();
            double chick_x = resizedlabel.getLocation().getX();
            double chick_y = resizedlabel.getLocation().getY();
            boolean hit = false;                                    //맞았을 때 true 안 맞았을 때 false
            System.out.println("chick) x : " + chick_x + "y :" + chick_y);//확인용 콘솔 문구
            System.out.println("miss) x : " + miss_x + "y :" + miss_y);
            if ((miss_x >= chick_x && miss_x <= (chick_x + 100)) && (miss_x + 20) <= (chick_x + 100)) {
                if (miss_y >= chick_y && miss_y <= (chick_y + 100)) {       //미사일 박스와 닭 박스가 겹쳤을 때
                    hit = true;             //충돌했다고 설정
                } else {
                    hit = false;
                }
            } else {
                hit = false;
            }

            if (hit == true) {              //충돌했을 때
                textlabel.setText("맞췄습니다.");        //맞췄다는 문구 출력

                before = fried.getImage();                  //이미지를 치킨으로 바꿔주기 위한 과정
                after = before.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                chick = new ImageIcon(after);
                resizedlabel.setIcon(chick);
                try {
                    Thread.sleep(2000);             //2초동안 멈추게 함.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                x = 0;                                      //다시 닭의 위치를 원상 복구 시켜준다.
                y = 0;
                resizedlabel.setLocation(x, y);

                textlabel.setText("");                      //텍스트 문구를 없애주고

                before = source.getImage();                 //닭의 이미지를 돌려준다.
                after = before.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                chick = new ImageIcon(after);
                resizedlabel.setIcon(chick);
            }

            if (resizedlabel.getLocation().equals(new Point(700, 0))) { //닭이 오른쪽 끝에 도달하면 방향 바꿔줌
                go = 0;
            } else if (resizedlabel.getLocation().equals(new Point(0, 0))) {//왼쪽 끝에 도달하면 다시 원래방향
                go = 1;
            }
            try {
                Thread.sleep(10); // 닭 움직이는 속도
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(resizedlabel.getLocation().toString());
            if (go == 1) {
                x += 5; //닭이 한번에 움직이는 좌표 값
                resizedlabel.setLocation(x, y);     //닭위치 조정
            } else if (go == 0) {
                x -= 5;
                resizedlabel.setLocation(x, y);
            }
        }
    }
    public static void main(String[] args) {
        Thread a = new Thread(new HuntChicken());   //메인 객체 생성
        a.start();//쓰레드 시작
    }
}
