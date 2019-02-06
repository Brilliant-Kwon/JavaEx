package JavaStudy.Jan_31.Phone;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneApp {
    public static void main(String[] args) {
        HashMap<String, Phone> map = new HashMap<String, Phone>();
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================");
        System.out.println("전화번호 관리 프로그램");
        System.out.println("=========================");

        while (true) {
            System.out.print("삽입:0 / 삭제:1 / 찾기:2 / 전체보기:3 / 종료:4 >> ");
            int num = sc.nextInt();

            switch (num) {
                case 0://삽입
                    sc.nextLine();//오류방지용
                    System.out.print("이름>>");
                    String putName = sc.nextLine();
                    System.out.print("주소>>");
                    String putAddr = sc.nextLine();
                    System.out.print("전화번호>>");
                    String putNum = sc.nextLine();

                    map.put(putName, new Phone(putName, putAddr, putNum));

                    break;
                case 1:
                    sc.nextLine();//오류방지용
                    System.out.print("이름>>");
                    String delName = sc.nextLine();
                    if (map.containsKey(delName)) {
                        map.remove(delName);
                        System.out.println(delName + "은 삭제되었습니다.");
                    } else
                        System.out.println(delName + "는(은) 등록되지 않은 사람입니다.");
                    break;
                case 2:
                    sc.nextLine();//오류방지용
                    System.out.print("이름>>");
                    String srcName = sc.nextLine();

                    if (map.containsKey(srcName))
                        System.out.println(map.get(srcName).name + " " + map.get(srcName).address + " " + map.get(srcName).number);
                    else
                        System.out.println(srcName + "는(은) 등록되지 않은 사람입니다.");

                    break;
                case 3:
//                    for (int i = 0; i < map.size(); i++) {
//                        System.out.println(map.get(i).name + " " + map.get(i).address + " " + map.get(i).number);
//                    }
                    Set set = map.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext())
                        System.out.println(iterator.next());
//                    System.out.println(map.values());
                    break;
                case 4:
                    System.out.println("종료합니다..");
                    break;


            }
            if (num == 4) {
                break;
            }

        }


    }
}
