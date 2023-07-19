package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class MemberDTO {
	String id, name;
	int pw;
	String phone, email, regtime;
	
	MemberDTO(String id, int pw) {
		this.id = id;
		this.pw = pw;
	}
	
	MemberDTO(String id, String name, int pw, String phone, String email, String regtime) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
		this.regtime = regtime;
	}

	MemberDTO() {}
	
	@Override
	public String toString() {
		return id + ":" + name + ":" + pw + ":" + phone + ":" + email + ":" + regtime;
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
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
}
