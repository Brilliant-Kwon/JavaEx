package Jan_21.Practice03_1.problem01;

public class Member {
    private String id;
    private String name;
    private int point;

    public Member(String id, String name, int point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
