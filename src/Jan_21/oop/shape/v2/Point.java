package Jan_21.oop.shape.v2;

public class Point implements Drawable{
    protected int x;
    protected int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.printf("%d, %d 좌표에 점을 찍었습니다.",x,y);
    }
}
