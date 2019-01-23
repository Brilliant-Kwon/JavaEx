package Jan_23.collection.hash;

import java.util.Hashtable;

class ClassRoom{
    private String subject;
    private String rommName;

    //생성자

    public ClassRoom(String subject, String rommName) {
        this.subject = subject;
        this.rommName = rommName;
    }

    public ClassRoom(String subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        return subject.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ClassRoom) {
            return obj.hashCode() == this.hashCode();
        }

        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "subject='" + subject + '\'' +
                ", rommName='" + rommName + '\'' +
                '}';
    }
}
public class HashTableEx {
    public static void main(String[] args) {
        //HashTable 생성
        Hashtable<String, ClassRoom> map = new Hashtable<>();

        //맵에 데이터 넣기
        map.put("101", new ClassRoom("Java", "101"));
        map.put("202", new ClassRoom("C", "202"));
        map.put("303", new ClassRoom("Python", "303"));

        System.out.println(map);

        //맵에서 데이터 가져오기 : get
        System.out.println(map.get("303"));

        //맵의 데이터 변경
        map.put("202", new ClassRoom("C#", "R202"));
        System.out.println(map);

        //특정 키가 맵 안에 있는지 확인
        System.out.println(map.containsKey("202"));//키는 결국 스트링값이니까 비교가 잘 된다.
        System.out.println(map.containsKey("502"));

        //subject가 Java인 ClassRoom을 받아와 봅시다.
        System.out.println(map.containsValue("Java"));
        System.out.println(map.containsValue(new ClassRoom("Java"))); // 생성자 추가 및 equals, hashcode 수정해야함.
        //value는 String으로 선언한게 아니라 객체로 선언했기 때문에 equals 수정해주는게 맞다.
//       Hashtable<String, ClassRoom>으로 선언했다.

        map.clear();//비워봅시다.
        System.out.println(map);
    }
}
