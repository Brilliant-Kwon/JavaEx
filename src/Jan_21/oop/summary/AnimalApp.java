package Jan_21.oop.summary;

public class AnimalApp {
    public static void main(String[] args) {
        KungfuSkill[] masters;

        Human him = new Human("권찬근", 27);
        Human man = new TheOne("아이언맨", 40);
        Panda that = new Panda("그냥판다", 1);
        Panda it = new KungfuPanda("포", 5);

        fight(him);
        fight(man);
        fight(that);
        fight(it);

        //쿵후를 할 수 있는 객체만 master에 담아 봅시다.
        masters = new KungfuSkill[]{
                (KungfuSkill)man,(KungfuSkill)it
        };

        for(KungfuSkill master:masters)
            master.kungfu();


    }

    public static void fight(Animal animal) {
        if (animal instanceof KungfuSkill) {
            ((KungfuSkill) animal).kungfu();
        } else {
//            System.out.println(animal.name + ": 저는 쿵후 못해요.");
        }
    }
}
