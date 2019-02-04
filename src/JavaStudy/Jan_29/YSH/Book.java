package JavaStudy.Jan_29.YSH;

public class Book extends Product{
	private int isbn;
	private String writer;
	private String bookName;
	public Book(int sik, String info, String producer, int price,int isbn,String writer,String bookName) {
		super(sik, info, producer, price);
		this.isbn=isbn;
		this.writer=writer;
		this.bookName=bookName;
	}
	public int getIsbn() {
		return isbn;
	}
	public String getWriter() {
		return writer;
	}
	public String getBookName() {
		return bookName;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("isbn>>"+isbn);
		System.out.println("작가>>"+writer);
		System.out.println("책이름>>"+bookName);
	}
	
}
