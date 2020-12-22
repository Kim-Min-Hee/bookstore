package vo;

public class User {
	private String userId;
	private String userName;
	private int contact;
	
	public User(String userId, String userName, int contact) {
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

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}
	
public String getUserIdInfo() {
		
		return "user Info   : "+userId;
		
	}
public String getUserInfo() {
	
	return "user Info   : "+userId+"\t"+userName+"\t"+contact;
	
}

}
