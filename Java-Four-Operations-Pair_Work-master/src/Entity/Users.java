package Entity;

public class Users {
	
	
	/*
	 * 用户类：用于管理用户
	 * */
	private int id;
	private String nickName;
	private String password;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", nickName=" + nickName + ", password=" + password + ", email=" + email + "]";
	}


}
