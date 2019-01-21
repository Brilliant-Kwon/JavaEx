package Jan_21.oop.shape.v2;

public class ShapeApp {
    public static void main(String[] args) {
        //Shape s = new Shape(10,20);
        Rectangle r = new Rectangle(10, 20, 100, 50);
        r.draw();

        Circle c = new Circle(30,40,20);
        c.draw();

        //인터페이스는 그 자체로 참조타입으로 사용할 수 있다.
        Drawable obj;
        obj = r;
        r.draw();
        obj = c;
        c.draw();

        Point p = new Point(10, 20);
        obj = p;
        p.draw();
//        System.out.println(obj.toString());

    }
}
