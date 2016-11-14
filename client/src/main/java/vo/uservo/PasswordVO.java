package vo.uservo;

import po.ClientPO;

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
	//用户名
	private String userName;
	
	
	public PasswordVO(){
	}
	
	/**
	 * po to vo
	 * @param clientPO
	 */
	public PasswordVO(ClientPO clientPO) {
		this.setUserID(clientPO.getUserID());
		this.setPassword(clientPO.getPassword());
		this.setUserName(clientPO.getUserName());
	}
	
	
	/**
	 * vo to po
	 * @return clientpo
	 */
	private ClientPO toPO() {
		return new ClientPO(userName, password, userID);
	}
	
	public PasswordVO(String userID,String password,String userName){
		this.setUserID(userID);
		this.setPassword(password);
		this.setUserName(userName);
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
