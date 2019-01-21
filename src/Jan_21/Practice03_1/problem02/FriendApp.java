package Jan_21.Practice03_1.problem02;

import java.util.Scanner;

public class FriendApp {
    public static void main(String[] args) {

        Friend[] friendArray = new Friend[3];
        Scanner sc = new Scanner(System.in);

//        System.out.println("0 번째 : "+);
//        friendArray[0].showInfo();

        System.out.println("친구를 3명 등록해 주세요(이름 전화번호 학교 순)");


        // 친구정보 입력받기
        // 입력받은 친구정보를 공백으로 분리
        for(int i = 0;i<3;i++){
//            System.out.print((i+1)+" 번째 친구의 정보를 입력하세요(이름 전화번호 학교 순) : ");
            String result = sc.nextLine();
            String[] split = result.split("\\s");
//            System.out.println(i+" 번째 : "+friendArray[i].getName()+friendArray[i].getHp()+friendArray[i].getSchool());
            for(int k = 0; k<3 ;k++)
                System.out.println(k+" 번째 : "+split[k]);
//            System.out.println(i+" 번째 : "+friendArray[i].getName()+friendArray[i].getHp()+friendArray[i].getSchool());
            friendArray[i] = new Friend(split[0],split[1],split[2]);
//            friendArray[i].setName(split[0]);
//            friendArray[i].setName(split[1]);
//            friendArray[i].setName(split[2]);

//            System.out.print((i+1)+" 번째 친구의 이름을 입력하세요 : ");
//            friendArray[i].setName(sc.nextLine());
//            System.out.print((i+1)+" 번째 친구의 전화번호를 입력하세요 : ");
//            friendArray[i].setHp(sc.nextLine());
//            System.out.print((i+1)+" 번째 친구의 학교를 입력하세요 : ");
//            friendArray[i].setSchool(sc.nextLine());
        }

        // Friend 객체 생성하여 데이터 넣기

        // 배열에 추가하기


        // 친구정보 출력
        for (int i = 0; i < friendArray.length; i++) {
            //친구정보 출력 메소드 호출
            friendArray[i].showInfo();
        }

        sc.close();
    }
}
