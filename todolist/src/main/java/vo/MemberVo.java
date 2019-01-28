package vo;

public class MemberVo {
	private int id;
	private String userName;
	private String password;
	
	public MemberVo() {}

	public MemberVo(int id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", userName=" + userName + ", password=" + password + "]";
	}
}
