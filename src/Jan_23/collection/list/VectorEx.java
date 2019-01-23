package Jan_23.collection.list;

import java.util.Enumeration;
import java.util.Vector;

//Enumeration 연습

public class VectorEx {
    public static void main(String[] args) {
        //벡터의 선언
        Vector<Integer> v = new Vector<>();
        //사이즈와 허용량(10단위로 늘어남)
        System.out.println("SIZE : " + v.size() + ", Capacity : " + v.capacity());

        for (int i = 1; i <= 10; i++) {
            //객체의 추가
            v.addElement(i);
        }

        v.addElement(11);//허용량 초과

        System.out.println("SIZE : " + v.size() + ", Capacity : " + v.capacity());

        //중간에 객체를 넣어봅시다.
        v.insertElementAt(5, 7);
        System.out.println(v);

        //  객체 조회 : indexOf
        int val = v.indexOf(5);
        System.out.println("객체 5의 인덱스 : " + val);

        //없는 객체의 인덱스
        System.out.println("객체 15의 인덱스 : " + v.indexOf(15));//-1

        //객체 포함 여부 판단
        System.out.println("contains 10 ? " + v.contains(10));
        System.out.println("contains 15 ? " + v.contains(15));

        //객체 삭제 : removeElement
        v.removeElement(10);
        System.out.println(v);

//        for (int i = 0; i < v.size(); i++) {
//            Integer item = v.elementAt(i);//특정 인덱스의 객체를 뽑아내 올 수 있음
//            System.out.println(item);
//        }

        //TODO : ENUMERATION으로 루프 돌기
        Enumeration<Integer> e = v.elements();//첫번째 아이템으로 인덱스 설정됨

        while (e.hasMoreElements()) {//그다음 아이템이 있으면 돌아감
            Integer item = e.nextElement();//인덱스 넘어감
            System.out.println(item);
        }

        //버퍼를 비워 봅시다.
        v.clear();
        System.out.println("SIZE : " + v.size() + ", Capacity : " + v.capacity());

        //Generic의 활용
        //Number => int, float, double의 상위
        //<? super Number> : Number를 수퍼로 가지고 있는 어떤 클래스
        Vector<? super Number> v2 = new Vector<>();
        v2.addElement(Integer.valueOf(10));
        v2.addElement(Float.valueOf(3.141592f));
        System.out.println(v2);
    }
}
