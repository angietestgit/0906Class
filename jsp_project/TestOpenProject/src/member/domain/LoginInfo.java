package member.domain;

public class LoginInfo {
	
	private String userId;
	private String userName;
	private String photo;
	
	public LoginInfo(String userId, String userName, String photo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.photo = photo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "LoginInfo [userId=" + userId + ", userName=" + userName + ", photo=" + photo + "]";
	}
	
	public LoginInfo getLoginInfo() {
		return new LoginInfo(this.userId, this.userName, this.photo);
	}
	
}
