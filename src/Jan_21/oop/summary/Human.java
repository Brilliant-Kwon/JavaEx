package Jan_21.oop.summary;

public class Human extends Animal{

    public Human(String name, int age) {
        super(name,age);
    }
    @Override
    public void say() {
        System.out.println("사람");
    }
}
