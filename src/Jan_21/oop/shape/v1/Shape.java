package Jan_21.oop.shape.v1;

public abstract class Shape {
    protected int x;
    protected int y;

    public Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    //추상 메서드
    //구현부 없음, 상속받은 클래스는 추상 메서드를 반드시 구현해야 합니다.
    public abstract void draw();
    public abstract double area();
}
