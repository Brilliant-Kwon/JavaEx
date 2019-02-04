package JavaStudy.Jan_29.YSH;

public class MyColorPoint extends MyPoint{
	String color;
	int temp;
	public MyColorPoint(int x, int y, String color) {
		super(x, y);
		this.color=color;
	}

	@Override
	protected void move(int x, int y) {
		// TODO Auto-generated method stub
		super.x=x;
		super.y=y;
	}

	@Override
	protected void reverse() {
		// TODO Auto-generated method stub
		temp=super.x;
		super.x=super.y;
		super.y=temp;
	}

	@Override
	protected void show() {
		// TODO Auto-generated method stub
		System.out.println(super.x+","+super.y+","+this.color);
	}
	

}
