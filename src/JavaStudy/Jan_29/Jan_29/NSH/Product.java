package JavaStudy.Jan_29.Jan_29.NSH;

public class Product {
	protected String id;
	protected String explain;
	protected String name;
	protected int price;
	
	public Product(String id, String explain, String name, int price) {
		super();
		this.id = id;
		this.explain = explain;
		this.name = name;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public String getExplain() {
		return explain;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
	public void showInfo() {};

}
