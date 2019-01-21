package Jan_21.oop.casting;

public class AnimalMain {
    public static void main(String[] args) {
        Animal cat1 = new Cat("길냥"); // Upcasting (상위 클래스인 Animal로 선언했음)
        cat1.eat();
        cat1.walk();
//        yaong.meow();//못해요
        Animal dog1 = new Dog("절미");
        dog1.eat();
        dog1.walk();
//        mung.bark();//못해요
        //다운 캐스팅 -> 명시적으로 캐스팅
        ((Dog)dog1).bark();
//        ((Cat)cat1).meow;//error
        if(cat1 instanceof Dog){
            ((Dog)cat1).bark();
        }else if (cat1 instanceof Cat){
            ((Cat)cat1).meow();
        }

        //애완동물
        Dog pet = new Dog("아지");
        pet.eat();
        pet.walk();

        pet.bark();

//        pet = new Cat("야옹쓰");//Error
        //Cat type은 Dog type으로 인스턴스화할 수 없음
        //pet을 애초에 Animal로 했으면 가능
    }
}
