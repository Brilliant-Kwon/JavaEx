package Jan_17.conditional;

public class SwitchEx3 {
    //TODO : 나중에 Enum으로 작성할 것
    public static void main(String[] args) {
        String day ="THURSDAY";
        String act ="";

        switch (day){
            case "SUNDAY":
                act = "휴식";
                break;
            case "MONDAY": case "TUESDAY": case "WEDNESDAY": case "THURSDAY":
                act = "공부";
                break;
            case "FRIDAY":
                act = "불금";
                break;
            case "SATURDAY":
                act = "방전";
                break;
        }
        System.out.println(day +" 에는 "+act+" 를 합니다.");
    }
}
