package Jan_21.oop.shape.v2;

public class Circle extends Shape implements Drawable {
    //추가 필드
    private int radius;
    private double PI = 3.141592;

    public Circle(int x, int y) {
        super(x, y);
    }

    public Circle(int x, int y, int r) {
        super(x, y);
        this.radius = r;
    }

    @Override
    public void draw() {
        System.out.printf("%d , %d 좌표에 %.2f의 넓이를 가진 원을 그렸습니다.\n", x, y, area());
    }

    @Override
    public double area() {
        return radius * Math.pow(PI, 2);
    }
}
