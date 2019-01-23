package Jan_23.collection.practice.extra02.problem04;

public abstract class Shape {
    int countSides;

    public void Shape(int countSides) {
        this.countSides = countSides;
    }

    public int getCountSides() {
        return countSides;
    }

    abstract double getArea();
    abstract double getPerimeter();
}
