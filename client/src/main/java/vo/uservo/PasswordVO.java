package vo.uservo;
/**
 * 密码vo
 * @author CYF
 * @version 1.0
 */
public class PasswordVO {
	//用户ID
	private String userID;
	//用户密码
	private String password;
	
	public PasswordVO(){
	}
	
	public PasswordVO(String userID,String password){
		this.setUserID(userID);
		this.setPassword(password);
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
