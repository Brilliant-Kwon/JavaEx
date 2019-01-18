package Jan_18.oop.goods;
//한클래스는 한 파일에 넣자

//클래스의 선언, 필드 추가

class Goods{
    String name;
    int price;
}
public class GoodsApp {
    public static void main(String[] args) {
        Goods notebook = new Goods();
        notebook.name = "Samsung Notebook 9";
        notebook.price = 1800000;

        Goods camera = new Goods();
        camera.name = "Nikon";
        camera.price = 700000;

        System.out.println(notebook.name + " : " + notebook.price);
        System.out.println(camera.name + " : " + camera.price);

    }
}
