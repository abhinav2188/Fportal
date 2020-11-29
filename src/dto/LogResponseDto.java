package dto;

public class LogResponseDto {

	public LogResponseDto() {
		this.uid = -1;
		this.errorMsg = null;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private int uid;
	private String errorMsg;
	private String fullName;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "LogResponseDto [uid=" + uid + ", errorMsg=" + errorMsg + ", fullName=" + fullName + "]";
	}

}
