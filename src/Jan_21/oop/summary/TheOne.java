package Jan_21.oop.summary;

public class TheOne extends Human implements Flyable, KungfuSkill{

    public TheOne(String name, int age) {
        super(name, age);
    }

    @Override
    public void fly() {
        System.out.println("펄~럭!");
    }

    @Override
    public void kungfu() {
        System.out.println("아뵤~!");
    }
}
