package Jan_23.collection.practice.extra02.problem03;

public class Goods {


    private String name;
    private int price;
    private int count;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public Goods(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
