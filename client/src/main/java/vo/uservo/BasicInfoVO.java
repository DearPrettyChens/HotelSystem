package vo.uservo;

import javax.swing.ImageIcon;

import util.UserType;
/**
 * 用户基本信息
 * @author CYF
 * @version 1.0
 */
public class BasicInfoVO {
	//用户名
	private String userName;
	//用户头像
	private ImageIcon userImage;
	//用户ID
	private String userID;
	//用户种类
	private UserType userType;
	
	public BasicInfoVO(String userName, ImageIcon userImage, String userID, UserType userType) {
		super();
		this.userName = userName;
		this.userImage = userImage;
		this.userID = userID;
		this.userType = userType;
	}

	
	public BasicInfoVO(String userName,String userID,UserType userType){
		this.setUserName(userName);
		this.setUserID(userID);
		this.setUserType(userType);
	}

	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ImageIcon getUserImage() {
		return userImage;
	}
	public void setUserImage(ImageIcon userImage) {
		this.userImage = userImage;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
