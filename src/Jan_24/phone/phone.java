package Jan_24.phone;

public class phone {            //전화번호 정보를 담고 있는 클래스 phone
    String name;    //이름
    String hp;      //휴대전화
    String company; //집전화

    public phone(String name, String hp, String company) {//생성자
        this.name = name;
        this.hp = hp;
        this.company = company;
    }

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "phone{" +
                "name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
