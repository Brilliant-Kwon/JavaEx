package Jan_21.Practice03_1.problem02;

public class Friend {
    private String name;
    private String hp;
    private String school;

    public Friend(){
        this.name ="김";
        this.hp = "010";
        this.school = "유";
    }

    public void setBasic(){
        setName("a");
        setHp("0");
        setSchool("");
    }

    public Friend(String name, String hp, String school) {
        this.name = name;
        this.hp = hp;
        this.school = school;
    }
    //필요한 메소드 작성

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    //친구 정보 출력
    public void showInfo() {
        System.out.println("이름:" + name + "  핸드폰:" + hp + "  학교:" + school);
    }
}
