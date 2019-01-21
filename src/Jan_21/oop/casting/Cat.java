package Jan_21.oop.casting;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    public void meow(){
        System.out.println(name + "이(가) 야옹 울었습니다.");
    }
}
