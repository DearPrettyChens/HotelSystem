package po;

import java.io.Serializable;

import util.UserType;

/**
 * 获取当前用户的用户名和密码
 * 
 * @author CLL
 * @version 1.0
 */
public class ClientPO implements Serializable {
	private String userName;
	private String password;
	private int userID;
	private UserType type;

	public ClientPO(String userName, String password, int userID) {
		this.userName = userName;
		this.password = password;
		this.userID = userID;
	}

	public ClientPO(String userName, String password, int userID, UserType type) {
		this.userName = userName;
		this.password = password;
		this.userID = userID;
		this.type = type;
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

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
}
