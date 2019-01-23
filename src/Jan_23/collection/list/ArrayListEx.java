package Jan_23.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Iterator 연습

public class ArrayListEx {
    public static void main(String[] args) {
        //생성
//        List<String> lst = new LinkedList<>();
        List<String> lst = new ArrayList<>();
        //어떤 자료 구조를 선택할 것인지는 프로그래머의 선택
        //중간에 추가 삭제가 빈번한 경우 ArrayList는 적합하지 않음

        //객체 추가 : add
        lst.add("Java");
        lst.add("Python");
        lst.add("C");
        lst.add("C++");

        //객체 삽입
        lst.add(2, "C#");

        //List 중복 삽입 허용
        lst.add("Java");

        System.out.println(lst);
        System.out.println("총 객체 수 : " + lst.size());

        //객체를 지워봅시다 : remove
        lst.remove(2);
        lst.remove("Python");
        System.out.println(lst);

        //TODO : Iterator를 이용한 루프
        Iterator<String> iter = lst.iterator();
        while (iter.hasNext()) {
            String item = iter.next();
            System.out.println("item : " + item);
        }

        //비워봅시다.
        lst.clear();
        System.out.println(lst);
    }
}
