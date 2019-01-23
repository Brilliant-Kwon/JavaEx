package Jan_23.collection.practice.extra02.problem04;

public class RectTriangle extends Shape {
    double width;
    double height;

    public RectTriangle(double width, double height) {
        super.countSides = 3;
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return this.height*this.width/2;
    }

    @Override
    double getPerimeter() {
        return Math.sqrt(Math.pow(this.height,2.0)+Math.pow(this.width,2.0))+this.width+this.height;
    }
}
