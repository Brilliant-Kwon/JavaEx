package JavaStudy.Jan_29.NSH;

public class CompactDisc extends Product{
	private String albumtitle;
	private String singer;
	


	public CompactDisc(String id, String explain, String name, int price, String albumtitle, String singer) {
		super(id, explain, name, price);
		this.albumtitle = albumtitle;
		this.singer = singer;
	}

	public String getAlbumtitle() {
		return albumtitle;
	}

	public String getSinger() {
		return singer;
	}
	
	@Override
	public void showInfo() {
		System.out.println("상품ID>>"+id+
				"\n상품 설명>>"+explain+
				"\n생산자>>"+name+
				"\n가격>>"+price+
				"\n앨범 제목>>"+albumtitle+
				"\n가수>>"+singer
				);
		
	}
	
	
}
