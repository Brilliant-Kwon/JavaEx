package Jan_21.oop.summary;

public class Panda extends Animal {

    public Panda(String name, int age) {
        super(name, age);
    }


    @Override
    public void say() {//추상 메서드로 선언된 메서드는 반드시 구현해 주어야 한다.
        System.out.println("판다.");
    }
}
