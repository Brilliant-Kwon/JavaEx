package JavaStudy.Jan_31.YSH.Quiz02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneMain {
	public static void main(String[] args) {
		HashMap<String, Phone> map =new HashMap<String,Phone>();
		for(;;) {
			Scanner sc=new Scanner(System.in);
			Scanner sc2=new Scanner(System.in);
			String name; // 삽입시에 이름
			String addr; // 삽입시에 주소
			String phoneNum; // 삽입시에 전화번호
			int menuNum;
			Iterator<String> keyIterator = map.keySet().iterator();
			System.out.println("------------------------------------------");
			System.out.println("전화번호 관리 프로그램을 시작합니다. 파일로 저장 하지않습니다.");
			System.out.println("------------------------------------------");
			System.out.print("삽입:0, 삭제:1, 찾기:2, 전체보기:3, 종료:4>>");
			menuNum=sc.nextInt();
			if(menuNum==0) {
				System.out.print("이름>>");
				name=sc2.nextLine();
				if(map.containsKey(name)==true) {
					System.out.println("중복된 이름이 있습니다.");
					continue;
				}else {
					System.out.print("주소>>");
					addr=sc2.nextLine();
					System.out.print("전화번호>>");
					phoneNum=sc2.nextLine();
					map.put(name, new Phone(addr,phoneNum));
				}
			}else if(menuNum==1) {
				System.out.print("이름>>");
				name=sc2.nextLine();
				if(map.containsKey(name)==true) {
					System.out.println(name+"은 삭제되었습니다.");
					map.remove(name);
				}else {
					System.out.println(name+"는 등록되지 않은 사람입니다.");
				}

			}else if(menuNum==2){
				System.out.print("이름>>");
				name=sc2.nextLine();
				if(map.containsKey(name)==true) {
					System.out.println(name+" "+map.get(name).addr+" "+map.get(name).phoneNum);
				}else {
					System.out.println(name+"는 등록되지 않은 사람입니다.");
				}

			}else if(menuNum==3) {
				System.out.println("전체보기");
				if(map.isEmpty()==true) {
					System.out.println("전화번호부가 비었습니다.");
				}else {
					while(keyIterator.hasNext()) {
						String key=keyIterator.next();
						System.out.println(key+" "+map.get(key).addr+" "+map.get(key).phoneNum);
					}
				}
			}else if(menuNum==4) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}
		}
	}
}
