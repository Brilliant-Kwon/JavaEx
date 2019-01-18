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
    public Goods3(String name) {
        super();//object
        this.name = name;
    }

    public Goods3(String name, int price) {
        this(name);//생성자 호출
        this.price = price;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    //메서드
    public void showInfo() {
        System.out.println("상품명 : " + name);
        System.out.println("가격 : " + price);
    }
}

public class GoodsApp3 {
    public static void main(String[] args) {
        Goods3 notebook = new Goods3("Samsung Notebook 9", 1800000);

        Goods3 camera = new Goods3("Nikon", 700000);

//        System.out.println(notebook.getName() + " : " + notebook.getPrice());
//        System.out.println(camera.getName() + " : " + camera.getPrice());
        notebook.showInfo();
        camera.showInfo();
    }
}
