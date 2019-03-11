package JavaStudy.Mar_11.NSH;

import java.util.Date;

public class KakaoVo {
	// 필드
	private Long no;
	private String id;
	private String name;
	private String password;
	private Date createdat;
	
	// 생성자
	public KakaoVo(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public KakaoVo(Long no, String id, String name, String password, Date createdat) {
		this.no = no;
		this.id = id;
		this.name = name;
		this.password = password;
		this.createdat = createdat;
	}

	// getter/setter
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedat() {
		return createdat;
	}

	public void setCreatedat(Date createdat) {
		this.createdat = createdat;
	}
	
	
	
}
