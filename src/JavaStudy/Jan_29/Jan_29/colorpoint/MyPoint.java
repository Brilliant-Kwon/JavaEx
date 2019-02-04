package JavaStudy.Jan_29.Jan_29.colorpoint;

abstract class MyPoint {
    int x;
    int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected abstract void move(int x, int y);//새로운 x,y위치로 이동

    protected abstract void reverse();

    protected void show() {
        System.out.println(x + ", " + y);
    }
}
