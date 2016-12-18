package po;

import java.io.Serializable;

/**
 * 获取当前用户的用户名和密码
 * @author CLL
 * @version 1.0
 */
public class CilentPO implements Serializable{
	private String userName;
	private String password;
	
	public CilentPO(String userName,String password){
		this.userName=userName;
		this.password=password;
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
}
