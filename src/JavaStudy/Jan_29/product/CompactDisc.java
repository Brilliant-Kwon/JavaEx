package JavaStudy.Jan_29.product;

public class CompactDisc extends Product {
    private String albumTitle;
    private String singer;

    public CompactDisc(int identifier, String introduce, String made, int price, String albumTitle, String singer) {
        super(identifier, introduce, made, price);
        this.albumTitle = albumTitle;
        this.singer = singer;
    }

    public void showInfo() {
        System.out.println("상품 ID : " + super.getIdentifier());
        System.out.println("앨범 설명 : " + super.getIntroduce());
        System.out.println("앨범 생산자 : " + super.getMade());
        System.out.println("앨범 가격 : " + super.getPrice());
        System.out.println("앨범 제목 : " + this.getAlbumTitle());
        System.out.println("앨범 가수 : " + this.getSinger());
        System.out.println("=====================================");
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getSinger() {
        return singer;
    }
}
