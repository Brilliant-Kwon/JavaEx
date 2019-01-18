package Jan_18.oop.point;

class Point3 {
    //필드 선언
//    private int x;
//    private int y;
    protected int x;
    protected int y;

    //생성자
    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    //메서드 오버로딩(Overloading : 초과적재)
    public void draw(boolean show) {
        //show -> true => 그렸습니다.
        //      -> false => 지웠습니다.
        String message = String.format("점 [x = %d, y=%d]를 ", x, y);
        message += show ? "그렸습니다." : "지웠습니다.";
        System.out.println(message);
    }
}

class ColorPoint extends Point3 {
    //필드
    private String color;

    //생성자
    public ColorPoint(int x, int y) {
        super(x, y);
    }

    public ColorPoint(int x, int y, String color) {
        this(x, y);
        this.setColor(color);
    }

    //getter/setter
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //draw 메서드 오버라이딩
    public void draw() {
//        String message = String.format("색깔점 [x=%d, y=%d, color=%s]을 그렸습니다.\n", getX(), getY(), getColor());
        String message = String.format("색깔점 [x=%d, y=%d, color=%s]을 그렸습니다.\n", x, y, getColor());

        System.out.println(message);
    }
}

public class PointApp3 {
    public static void main(String[] args) {
        Point3 p1 = new Point3(10, 20);
//        p1.setX(10);
//        p1.setY(20);
        p1.draw();
        p1.draw(true);
        p1.draw(false);

        Point3 p2 = new Point3(30, 40);
//        p2.setX(30);
//        p2.setY(40);
        p2.draw();
        p2.draw(true);
        p2.draw(false);

        ColorPoint cp = new ColorPoint(10, 10, "RED");
        cp.draw();

    }
}

