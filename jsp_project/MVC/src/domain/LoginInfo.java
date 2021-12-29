package domain;

public class LoginInfo {

	private String uid;
	private String name;
	private String nic;
	private String email;
	
	public LoginInfo(String uid, String name, String nic, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.nic = nic;
		this.email = email;
	}

	// 생성자로 초기화
	
	// 읽기 전용 : getter 만 존재, setter 없다!!
	public String getUid() {
		return uid;
	}

	public String getName() {
		return name;
	}

	public String getNic() {
		return nic;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "LoginInfo [uid=" + uid + ", name=" + name + ", nic=" + nic + ", email=" + email + "]";
	}
	
	
	

}
