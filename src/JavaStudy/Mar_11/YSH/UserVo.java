package JavaStudy.Mar_11.YSH;

import java.util.Date;

public class UserVo {
	private Long no;
	private String id;
	private String name;
	private String password;
	private Date created_at;
	UserVo(String id,String name,String password){
		
		this.id=id;
		this.name=name;
		this.password=password;

	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", created_at="
				+ created_at + "]";
	}
	public Long getNo() {
		return no;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
}
