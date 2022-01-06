package member.domain;

public class LoginInfo {
	
	private String userId;
	private String username;
	private String photo;
	
	public LoginInfo(String userId, String username, String photo) {
		super();
		this.userId = userId;
		this.username = username;
		this.photo = photo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "LoginInfo [userId=" + userId + ", username=" + username + ", photo=" + photo + "]";
	}
	
	public LoginInfo getLoginInfo() {
		return new LoginInfo(this.userId, this.username, this.photo);
	}
	
}
