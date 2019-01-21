package Jan_21.oop.casting;

public class Animal {
    protected String name;
    public Animal(String name){
        this.name = name;
    }

    public void eat(){
        System.out.println(name + "이(가) 먹었습니다.");
    }
    public void walk(){
        System.out.println(name + "이(가) 한발짝 걸었습니다.");
    }
}
