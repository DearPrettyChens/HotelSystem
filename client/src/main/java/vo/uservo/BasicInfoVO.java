package vo.uservo;

import java.awt.Image;

import javax.swing.ImageIcon;
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
	
	public BasicInfoVO(){
	}
	
	public BasicInfoVO(String userName,ImageIcon userImage,String userID){
		this.setUserImage(userImage);
		this.setUserName(userName);
		this.setUserID(userID);
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

}
