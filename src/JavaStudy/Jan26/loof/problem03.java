package JavaStudy.Jan26.loof;

import java.util.Scanner;

//정수 - > 2진수로 출력 -> 1의 갯수 출력
public class problem03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 >> ");
        int dec = sc.nextInt();
        String bin = Integer.toBinaryString(dec);

        System.out.println(bin);
        int count = 0;
        for(int i = 0;i<bin.length();i++){
            if(bin.charAt(i)=='1')
                count++;
        }
        System.out.println("1의 갯수 : "+count);

        //2진수를 메서드 사용 없이 만들어 보자?
//        int temp=0;
//        while(dec==0){
//            if(dec%Math.pow(2,temp++)!=0)
//        }
    }
}
