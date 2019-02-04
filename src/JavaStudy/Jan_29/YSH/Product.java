package JavaStudy.Jan_29.YSH;

public class Product {
	int sik;
	String info;
	String producer;
	int price;
	public Product(int sik, String info, String producer, int price) {
		this.sik = sik;
		this.info = info;
		this.producer = producer;
		this.price = price;
	}
	
	public void showInfo() {
		System.out.println("상품 ID>>"+sik);
		System.out.println("상품 설명>>"+info);
		System.out.println("생산자>>"+producer);
		System.out.println("가격>>"+price);
		
	}
	
}
