package Jan_16.quiz02;

public class Quiz02_2 {
    public static void main(String[] args) {
        int balls = 136;//보유한 공의 개수
        int cap = 10;//상자당 담을 수 있는 공의 개수

        //상자에 공을 나눠 담으려면 최소 몇 개의 상자가 필요합니까?
        //3항연산자 사용
        int result = (balls%cap)==0 ? (int)(balls/cap) : (int)(balls/cap)+1;
        System.out.println(balls+"개의 공을 "+cap+"개 씩 담으려면 \n최소 "+result+" 개의 상자가 필요하다.");
    }
}
