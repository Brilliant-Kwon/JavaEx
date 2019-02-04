package JavaStudy.Jan_29.Jan_29.NSH;

public class MyColorPoint extends MyPoint{
	private String color;
	
	public MyColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	@Override
	protected void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	protected void reverse() {
		int tmp = x;
		x = y;
		y = tmp;
	}


	@Override
	protected void show() {
		// TODO Auto-generated method stub
		System.out.println(x + "," + y + "," + color);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPoint p = new MyColorPoint(2, 3, "blue");
		p.move(3, 4);
		p.reverse();
		p.show();
	}
}