package Jan_21.api.objectclass.ex2;

public class Point implements Cloneable {//복제 메서드 구현
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "Point("+x+", "+y+")"; // Point클래스 만의 toString()
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point){
            Point other = (Point)obj;
            return x == other.x && y == other.y;
        }
        return super.equals(obj);
    }

    public Point getClone() {
        Point clone = null;

        try {
            clone = (Point)clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
