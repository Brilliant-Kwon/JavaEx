package Jan_21.oop.shape.v1;

public class Rectangle extends Shape {
    //추가 필드
    private int width;
    private int height;

    //생성자
    public Rectangle(int x, int y) {
        super(x, y);
    }

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.printf("%d , %d 좌표에 %.2f의 넓이를 가진 사각형을 그렸습니다.\n",x,y,area());
    }

    @Override
    public double area() {//넓이를 구해주는 메서드
        return width*height;
    }
}
