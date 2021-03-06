package JavaStudy.Jan_31.EYR.addressprogram;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class AddressProgram extends Program {

	public static void main(String[] args) throws IOException {

		Program pg = new Program();
		System.out.println("-------------------------------------");
		System.out.println("전화번호 관리 프로그램을 시작합니다.");
		System.out.println("-------------------------------------");

		while(true) {

			System.out.print("삽입:0. 삭제:1, 찾기:2, 전체보기:3, 종료:4>>");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();

			switch(num) {

			case 0:
				pg.Register();
				break;
			case 1:
				pg.Delete();
				break;
			case 2:
				pg.Search();
				break;
			case 3:
				pg.List();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다...");
				break;
			default:
				System.out.println("다시 입력해주세요");
				break;
			}//switch

			if(num==4) {
				break;
			}
		}//while
	}
}
class Program{
	private static final String Iterator = null;
	Scanner sc = new Scanner(System.in);
	HashMap<String, Address> AddressMap = new HashMap<String, Address>();

	public void Register() {

		Address address = new Address();
		System.out.print("이름>>");
		address.setName(sc.next());
		System.out.print("주소>>");
		address.setHome(sc.next());
		System.out.print("번호>>");
		address.setPhoneNum(sc.next());
		AddressMap.put(address.getName(), address);
		
	}

	public void Delete() {
		//			Scanner sc = new Scanner(System.in);
		//			HashMap<String, Address> AddressMap = new HashMap<String, Address>();
		System.out.print("이름>>");
		String name = sc.next();
		if(AddressMap.containsKey(name)== true) {
			AddressMap.remove(name);
			System.out.println(name + "은(는) 삭제되었습니다.");
		}
		else
			System.out.println(name + "은(는) 등록되지 않은 사람입니다.");
	}

	public void Search() {
		//			Scanner sc = new Scanner(System.in);
		//			HashMap<String, Address> AddressMap = new HashMap<String, Address>();
		System.out.print("이름>>");
		String name = sc.next();
		if(AddressMap.containsKey(name)== true) {
			Address address = AddressMap.get(name);
			address.Member();
		}
		else
			System.out.println(name + "은(는) 등록되지 않은 사람입니다.");
	}
	public void List() {
		//			HashMap<String, Address> AddressMap = new HashMap<String, Address>();
		
//		Set<Entry<String, Address>> set = AddressMap.entrySet(); 
//		Iterator<Entry<String, Address>> itr = set.iterator();
//		while(itr.hasNext())
//		{
//			Map.Entry<String, Address> e = (Map.Entry<String, Address>)itr.next();
//			System.out.println(e.getKey()+e.getValue());
		
		Set<String> names = AddressMap.keySet();
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Address address = AddressMap.get(name);
			address.Member();
		}
	}



}


