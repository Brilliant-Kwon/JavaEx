package Jan_22.api.generic.ex1;
//Generic 타입 클래스 연습
/*class Box {
    Object content;//   자료형을 Object로 하면

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}*/

class Box <T> {
    T content;

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}

public class BoxApp {
    public static void main(String[] args) {
        //  Box 하나 만들고 int 담아봅시다.
        Box intBox = new Box();
        intBox.setContent(123);

        //값을 꺼내어 봅시다.
        System.out.println("intBox : " + intBox.getContent());

        Box strBox = new Box();
        strBox.setContent("Java");//오류
        System.out.println("strBox : "+strBox.getContent());
//        String content =  strBox.getContent();
        String content = (String) strBox.getContent();
        System.out.println(content.toUpperCase());
        //Object를 자료형으로 사용해서 설계하면 되긴 되지만
        //Object형을 String으로 담을때는 다운캐스팅 형 변환을 해주어야한다.
//
//        content = (String) intBox.getContent();
//        System.out.println(content.toUpperCase());
        //int타입 같은 다른 타입이 들어올 경우 실행 시 오류가 나고 잡을 수가 없다.
        // 그래서 필요한 것이 제네릭 타입

        //Generic타입을 이용하여 설계를 다시 해보자.
        Box<Integer> intBox1 = new Box<>();//앞에서 자료형을 쓰면 뒤에는 생략해도됨
        intBox1.setContent(123);
        System.out.println("intBox1 : " + intBox1.getContent());

        Box<String> strBox1 = new Box<>();
        strBox1.setContent("Java");//오류
        System.out.println("strBox1 : "+strBox1.getContent());

        String content1 = strBox1.getContent();
        System.out.println(content1.toUpperCase());

    }
}
