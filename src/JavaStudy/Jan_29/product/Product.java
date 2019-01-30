package JavaStudy.Jan_29.product;

public class Product {
    private int identifier;
    private String introduce;
    private String made;
    private int price;

    public Product(int identifier, String introduce, String made, int price) {
        this.identifier = identifier;
        this.introduce = introduce;
        this.made = made;
        this.price = price;
    }

    public void showInfo() {

    }

    public int getIdentifier() {
        return identifier;
    }

    public String getIntroduce() {
        return introduce;
    }

    public String getMade() {
        return made;
    }

    public int getPrice() {
        return price;
    }
}
