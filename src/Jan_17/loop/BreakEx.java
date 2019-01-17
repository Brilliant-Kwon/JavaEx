package Jan_17.loop;

public class BreakEx {
    public static void main(String[] args) {
        // 양의 정수 중에서
        //6의 배수이고 14의 배수인 가장 작은 정수
        int i = 1;
        while(true){
            if(i%6==0&&i%14==0){
                System.out.println("6의 배수이고 14의 배수인 가장 작은 정수 : "+i);
                break;
            }
            i++;
        }
    }
}
