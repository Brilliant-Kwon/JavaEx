package JavaStudy.Jan26.loof;

//369게임 , 반복문 사용
public class problem12 {
    public static void main(String[] args) {

        for (int i = 1; i <= 99; i++) {
            if (((i - (i % 10)) % 30 == 0) && i > 10) {//10의자릿수 먼저 검사
                if ((i % 10) % 3 == 0 && (i % 10) != 0) {
                    System.out.println(i + " : 박수 짝짝");
                } else {
                    System.out.println(i + " : 박수 짝");
                }

            } else if ((i % 10) % 3 == 0 && (i % 10) != 0) {//1의자릿수 검사
                System.out.println(i + " : 박수 짝");

            }


        }

    }
}
