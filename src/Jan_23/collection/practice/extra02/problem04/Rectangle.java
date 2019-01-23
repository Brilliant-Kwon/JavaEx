package Jan_23.collection.practice.extra02.problem04;

public class Rectangle extends Shape implements Resizeable{

    double width;
    double height;

    public Rectangle(double width, double height) {
        super.countSides = 4;
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return this.height * this.width;
    }

    @Override
    double getPerimeter() {
        return (this.height*2) + (this.width*2);
    }

    @Override
    public void resize(double s) {
        this.width = this.width*s;
        this.height = this.height*s;
    }
}
