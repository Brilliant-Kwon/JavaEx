package JavaStudy.Mar_11.KCK.vo;

public class Chat_Vo {
    private Long no;
    private String id;
    private String password;
    private String nickname;

    public Chat_Vo(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }

    public Chat_Vo(Long no, String id, String password, String nickname) {
        this.no = no;
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
