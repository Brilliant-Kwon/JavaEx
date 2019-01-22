package Jan_22.arrays;

import java.util.Arrays;
import java.util.Collections;

class Member implements Comparable {
    //  CompareTo를 위한 인터페이스 Comparable
    String name;

    public Member(String name) {
        this.name = name;
    }

    //인터페이스니까 당연히 메서드 오버라이드 해줘야함
    @Override
    public int compareTo(Object a) {
        if (a instanceof Member) {
            return name.compareTo(((Member) a).name);
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                '}';
    }

}

public class ArraysEx {
    public static void main(String[] args) {
        //배열복사
//        arrayCopyEx();
        //배열검색
//        binarySearch();
        //배열정렬
//        basicSortEx(); //기본정렬
//        basicSortDescEx();//역순정렬
        //사용자 정의 클래스 정렬
        customClassSortEx();
    }

    private static void arrayCopyEx() {
        char[] src = "Java Programming".toCharArray();

        //System.arraycopy를 이용한 복사
        char target[] = new char[src.length];
        System.arraycopy(src, 0, target, 0, src.length);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(target));

        //  Arrays.copyOf 메서드
        target = Arrays.copyOf(src, src.length);
        System.out.println(Arrays.toString(target));

        //  일부 복제 : 범위지정 copyOfRange
        target = Arrays.copyOfRange(src, 5, src.length);
        System.out.println(Arrays.toString(target));
    }

    private static void binarySearch() {
        //기본 타입 검색
        int[] nums = {1, 5, 6, 7, 4, 2, 6, 9, 10, 14};

        //  binarySearch 우선 정렬이 되어 있어야 합니다.
        Arrays.sort(nums);
        System.out.println("원본 배열 : " + Arrays.toString(nums));
        System.out.println("6의 인덱스 : " + Arrays.binarySearch(nums, 6));

        //  String 검색
        String[] str = {"Java", "C", "C++", "Python", "Linux"};
        //  우선 정렬 부터
        Arrays.sort(str);
        System.out.println(Arrays.binarySearch(str, "Python"));


    }

    //기본형을 오름차순 정렬
    private static void basicSortEx() {
        int[] scores = {80, 50, 70, 90, 85, 75};
        System.out.println("배열 원본 : " + Arrays.toString(scores));
        Arrays.sort(scores);
        System.out.println("기본 정렬 : " + Arrays.toString(scores));
    }

    private static void basicSortDescEx() {
        Integer[] scores = {80, 50, 70, 90, 85, 75};
        System.out.println("배열 원본 : " + Arrays.toString(scores));
        Arrays.sort(scores, Collections.reverseOrder());
        System.out.println("역순 정렬 : " + Arrays.toString(scores));
    }

    //  사용자 정의 클래스의 정렬
    private static void customClassSortEx(){
        Member[] members = {
                new Member("손건우"),
                new Member("권찬근"),
                new Member("좐준형")
        };
        System.out.println("원본 배열 : "+ Arrays.toString(members));
        Arrays.sort(members);
        System.out.println("정렬 : "+Arrays.toString(members));
    }

}
