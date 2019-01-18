package Jan_18.oop.goods;


//클래스의 선언, 필드 추가
class Goods2{
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class GoodsApp2 {
    public static void main(String[] args) {
        Goods2 notebook = new Goods2();
        notebook.setName("Samsung Notebook 9");
        notebook.setPrice(1800000);

        Goods2 camera = new Goods2();
        camera.setName("Nikon");
        camera.setPrice(700000);

        System.out.println(notebook.getName() + " : " + notebook.getPrice());
        System.out.println(camera.getName() + " : " + camera.getPrice());

    }
}
