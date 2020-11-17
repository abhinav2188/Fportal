package beans;

public class LoginBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private String username,password;
	public void setUsername(String name) {
		this.username = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean validate() {
		if(password.matches("1234")) {
			System.out.println("password match");
			return true;
		}
		else {
			System.out.println("password not matched");
			return false;
		}
	}
}