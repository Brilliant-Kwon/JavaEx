package JavaStudy.Jan_29.Jan_29.NSH;

public class ConversationBook extends Book {
	private String language;

	public ConversationBook(String id, String explain, String name, int price, String iSBN, String author,
			String booktitle, String language) {
		super(id, explain, name, price, iSBN, author, booktitle);
		this.language = language;
	}

	public String getLanguage() {
		return language;
	}

	@Override
	public void showInfo() {
		System.out.println("상품ID>>"+id+
				"\n상품 설명>>"+explain+
				"\n생산자>>"+name+
				"\n가격>>"+price+
				"\nISBN>>"+ISBN+
				"\n저자>>"+author+
				"\n책 제목>>"+booktitle+
				"\n언어>>"+language
				);
		
	}

	
	
	

}
