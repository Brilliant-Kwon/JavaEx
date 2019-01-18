package Jan_18.oop.methods;

public class MethodEx {
    public static void main(String[] args) {
        System.out.println("sum 호출 : "+sum(new double[]{ 10,20,3,5}));
        System.out.println("sumVar 호출 : "+sumVar(10,20,3,5));
        printTotal("print total : ",1,2,3,4,5,6,7,8,9,10);
        System.out.println("divide 호출 : "+divide(10,5));
    }

    //넘겨줄 인수 개수가 정해져 있지 않을 때 : 배열을 이용한 전달
    public static double sum(double[] values){
        double total = 0;
        for(double num:values)
            total+=num;
        return total;
    }

    //넘겨줄 인수 개수가 정해져 있지 않을 때 : 가변 인수 활용
    public static double sumVar (double ... values){
        double total = 0;
        //Enhanced For
        for(double num:values)
            total+=num;
        return total;
        //return sum(values)
    }
    //고정 인수와 가변 인수를 동시에 사용할 때
    //순서에 유의 : 고정인수 선언 -> 가변인수
    public static void printTotal(String message,//고정인수
                                  double ... values){
        double total = 0;
        for(double num:values)
            total+=num;
        System.out.println(message+total);
    }
    //메서드 기본 작성 형태
    public static double divide(double num1, double num2){
        return num1/num2;
    }
}
