package beans;

public class LoginBean implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private String name,password;
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
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