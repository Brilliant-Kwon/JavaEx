package JavaStudy.Jan_29.NSH;

public class Book extends Product{
	protected String ISBN;
	protected String author;
	protected String booktitle;
	
//	public Book(String id, String explain, String name) {
//		super(id, explain, name);
//		// TODO Auto-generated constructor stub
//	}


	public String getISBN() {
		return ISBN;
	}

	@Override
	public void showInfo() {
		System.out.println("상품ID>>"+id+
				"\n상품 설명>>"+explain+
				"\n생산자>>"+name+
				"\n가격>>"+price+
				"\nISBN>>"+ISBN+
				"\n저자>>"+author+
				"\n책 제목>>"+booktitle);
		
	}

	public Book(String id, String explain, String name, int price, String iSBN, String author, String booktitle) {
	super(id, explain, name, price);
	this.ISBN = iSBN;
	this.author = author;
	this.booktitle = booktitle;
}

	public String getAuthor() {
		return author;
	}

	public String getBooktitle() {
		return booktitle;
	}
	
	
	
}
