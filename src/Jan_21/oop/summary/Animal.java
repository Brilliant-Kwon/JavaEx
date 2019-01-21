package Jan_21.oop.summary;

public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public abstract void say();

    public void eat(){
        System.out.println(name+"이(가) 먹고 있습니다.");
    }
}
