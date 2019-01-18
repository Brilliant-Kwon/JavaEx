package Jan_18.oop.goods;
//v3 - 생성자 추가
//클래스의 선언, 필드 추가
class Goods3 {
    private String name;
    private int price;
    //생성자
/*    public Goods3(){
        //기본 생성자
    }*/
public Goods3(String name, int price){
    this.name = name;
    this.price = price;
}

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

    //메서드
    public void showInfo() {
        System.out.println("상품명 : " + name);
        System.out.println("가격 : " + price);
    }
}

public class GoodsApp3 {
    public static void main(String[] args) {
        Goods2 notebook = new Goods2();
        notebook.setName("Samsung Notebook 9");
        notebook.setPrice(1800000);

        Goods2 camera = new Goods2();
        camera.setName("Nikon");
        camera.setPrice(700000);

//        System.out.println(notebook.getName() + " : " + notebook.getPrice());
//        System.out.println(camera.getName() + " : " + camera.getPrice());
        notebook.showInfo();
        camera.showInfo();
    }
}
