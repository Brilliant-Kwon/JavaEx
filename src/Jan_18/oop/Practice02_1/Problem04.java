package Jan_18.oop.Practice02_1;

//1~45까지의 배열 중 임의의 숫자 6개 출력 - 로또
//중복체크 필요
public class Problem04 {
    public static void main(String[] args) {
        int[] arr;
        arr = new int[6];
//        for(int i = 0;i<45;i++){
//            arr[i] = i+1;
//        }
        for (int i = 0; i < 6; i++) {
            if (i != 0) {
                arr[i] = (int) (Math.random() * 45) + 1;
                for(int j = 0; j<=i-1;j++){
                    if(arr[i]==arr[j])
                        arr[i] = (int) (Math.random() * 45) + 1;
                }
            } else
                arr[i] = (int) (Math.random() * 45) + 1;
            System.out.print(arr[i]+"\t");
        }
    }
}
