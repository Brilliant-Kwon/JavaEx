package JavaStudy.Jan_29.YSH;

public class ConversationBook extends Book{
	private String language;
	public ConversationBook(int sik, String info, String producer, 
			int price, int isbn, String writer,String bookName,String language) {
		super(sik, info, producer, price, isbn, writer, bookName);
		this.language=language;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("언어>>"+language);
	}
}
