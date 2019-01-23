package Jan_23.collection.practice.extra02.problem03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodsApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Goods> lst = new ArrayList<>();
        int total =0;
        System.out.println("상품 3개를 입력해주세요.");
        for(int i =0;i<3;i++) {
            String line = sc.nextLine();
            String[] data = line.split(" ");
            lst.add(new Goods(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2])));
        }
//        System.out.println(lst);
        for(int i =0;i<3;i++){
            System.out.println(lst.get(i).getName() + "(가격:" + lst.get(i).getPrice() + ")이 " + lst.get(i).getCount() + " 개 입고 되었습니다.");
            total+=lst.get(i).getCount();
        }
        System.out.println("총 갯수 : " + total);
    }

}
