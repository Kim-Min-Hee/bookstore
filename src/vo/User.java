package vo;

public class User {
	private String userId;
	private String userName;
	private String contact;
	
	public User(String userId, String userName, String contact) {
		this.userId = userId;
		this.userName= userName;
		this.contact = contact;
		
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	

}
