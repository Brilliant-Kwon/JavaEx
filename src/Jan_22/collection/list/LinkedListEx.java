package Jan_22.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {
        //생성
        List<String> lst = new LinkedList<>();

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

        //비워봅시다.
        lst.clear();
        System.out.println(lst);
    }
}
