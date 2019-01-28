package JavaStudy.Jan26.ifandscan;

import java.util.Scanner;

//점이 직사각형 안쪽인지?
public class problem07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("점 (x,y)의 좌표를 입력하시오>>");
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x>=50&&x<=100) {
            if (y >= 50 && y <= 100) {
                System.out.println("사각형 안에 점이 있습니다.");
            }else {
                System.out.println("사각형 안에 없습니다.");
            }
        }else {
            System.out.println("사각형 안에 없습니다.");
        }
    }
}
