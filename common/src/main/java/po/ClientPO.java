package po;

import java.io.Serializable;

/**
 * 获取当前用户的用户名和密码
 * @author CLL
 * @version 1.0
 */
public class ClientPO implements Serializable{
	private String userName;
	private String password;
	private String userID;
	
	public ClientPO(String userName,String password,String userID){
		this.userName=userName;
		this.password=password;
		this.userID=userID;
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
}
