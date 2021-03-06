package dto;

public class LoginRequestDto implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	private String email,password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginRequestDto [email=" + email + ", password=" + password + "]";
	}

}