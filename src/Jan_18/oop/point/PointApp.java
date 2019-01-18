package Jan_18.oop.point;

class Point {
    //필드 선언
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //Methods
    public void draw() {
        System.out.printf("점 [x = %d, y=%d]를 그렸습니다\n", x, y);
    }
}

public class PointApp {
    public static void main(String[] args) {
        Point p1 = new Point();
        p1.setX(10);
        p1.setY(20);
        p1.draw();

        Point p2 = new Point();
        p2.setX(30);
        p2.setY(40);
        p2.draw();
    }
}
