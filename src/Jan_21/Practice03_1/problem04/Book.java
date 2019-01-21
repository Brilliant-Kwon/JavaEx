package Jan_21.Practice03_1.problem04;

public class Book {
    private int bookNo;
    private String title;
    private String author;
    private int stateCode;

    public Book(int bookNo, String title, String author){
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.stateCode = 1;
    }

    public void rent(){
        if(this.stateCode==1) {
            this.stateCode = 0;
            System.out.println(this.title+"가 대여 됐습니다.");
        }else if(this.stateCode==0){
            System.out.println("죄송합니다\n"+this.title+"가 대여 중입니다.");
        }
    }

    public void print(){
        if(this.stateCode==1) {
            System.out.println(this.bookNo+"\t책 제목: "+this.title+"\t작가: "+this.author+"\t"+"대여유무: 재고있음");
        }
        if(this.stateCode==0) {
            System.out.println(this.bookNo+"\t책 제목: "+this.title+"\t작가: "+this.author+"\t"+"대여유무: 대여중");
        }
    }



    public int getBookNo() {
        return bookNo;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getStateCode() {
        return stateCode;
    }
}
