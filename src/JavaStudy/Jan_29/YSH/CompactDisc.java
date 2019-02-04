package JavaStudy.Jan_29.YSH;

public class CompactDisc extends Product{
	private String albumName;
	private String singerName;
	public CompactDisc(int id, String info, String producer, int price,String albumName,String singerName) {
		super(id, info, producer, price);
		this.albumName=albumName;
		this.singerName=singerName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
		System.out.println("앨범이름>>"+albumName);
		System.out.println("가수이름>>"+singerName);
	}
	
}
