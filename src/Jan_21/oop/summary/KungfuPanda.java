package Jan_21.oop.summary;

public class KungfuPanda extends Panda implements KungfuSkill {

    public KungfuPanda(String name, int age) {
        super(name, age);
    }

    @Override
    public void kungfu() {
        System.out.println("아뵤~!");
    }
}
