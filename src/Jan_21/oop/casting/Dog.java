package Jan_21.oop.casting;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    public void bark(){
        System.out.println(name + "이(가) 멍멍 짖었습니다.");
    }
}
