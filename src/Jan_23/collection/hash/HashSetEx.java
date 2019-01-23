package Jan_23.collection.hash;

import java.util.HashSet;

class Student {
    //필드
    String name;
    int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() { //id 값 중복으로 판단하기 위해 변경
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            return name.equals(other.name) && id == other.id;
        }
        return super.equals(obj);
    }
}

public class HashSetEx {
    public static void main(String[] args) {
//        hashSetBasic();
        hashSetCustom();
    }

    private static void hashSetBasic() {
        //해시셋 선언
        HashSet<String> hs = new HashSet<>();

        //객체 추가
        hs.add("Java");
        hs.add("C");
        hs.add("C++");
        hs.add("Python");

        System.out.println(hs);
        System.out.println("HS size : " + hs.size());

        //객체 삭제
        hs.remove("C++");
        System.out.println(hs);

        //객체 포함 여부
        System.out.println(hs.contains("Python"));
        System.out.println(hs.contains("Linux"));
    }

    //사용자 정의 객체의 hash
    public static void hashSetCustom() {
        //해시셋 선언
        HashSet<Student> hs = new HashSet<>();

        Student s1 = new Student("홍길동", 10);
        Student s2 = new Student("전우치", 20);
        Student s3 = new Student("홍길동", 10);//같은 이름을 넣었을 때 어떻게 되나?

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        System.out.println("학생 명부 : " + hs);
        System.out.println("학생 수 : " + hs.size());


    }
}
