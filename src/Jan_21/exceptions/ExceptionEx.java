package Jan_21.exceptions;

import java.io.IOException;
import java.util.Scanner;

public class ExceptionEx {
    public static void main(String[] args) {
//        arithException();
//        nullPointerException();
//        arrayException();
        throwsException();
    }

    private static void throwsException() {
        ThrowsException except = new ThrowsException();
        try {
            except.executeException();
        } catch (IOException e) {
            System.out.println("예외 발생:" + e.getMessage());
        }

        try {
            except.executeRuntimeException();
        } catch (RuntimeException e) {
            System.out.println("런타임 예외 발생 : "+e.getMessage());
        }
    }

    private static void arrayException(){
        int[] array = new int[]{3,6,9};
        try {
            System.out.println(array[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("배열 인덱스 벗어남");
            System.out.println("인덱스 : "+e.getMessage());
        }
    }

    private static void nullPointerException() {
        String str = new String("Hello Java");

        str = null;
        try {
            System.out.println(str.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("객체가 할당되지 않았어요.");
        }catch(Exception e){//혹시나 처리되지 않은 Exception 처리 용
            e.printStackTrace();
        }finally {

        }
    }

    //arithmeticException 예제
    private static void arithException() {
        //Scanner로부터 점수를 입력
        //100을 입력받은 정수로 나누기
        double result = 0;
        int num;

        Scanner scanner = new Scanner(System.in);
        try {
            num = scanner.nextInt();
            result = 100 / num;
        } catch (ArithmeticException e) {
            System.out.println("0으로는 나눌 수 없어요.");
            System.out.println("Error Message : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("예외 처리 완료.");

        }
        System.out.println(result);
        scanner.close();
    }
}
