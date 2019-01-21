package Jan_21.oop.shape.v2;

public class ShapeApp {
    public static void main(String[] args) {
        //Shape s = new Shape(10,20);
        Rectangle r = new Rectangle(10, 20, 100, 50);
        r.draw();

        Circle c = new Circle(30,40,20);
        c.draw();
    }
}
