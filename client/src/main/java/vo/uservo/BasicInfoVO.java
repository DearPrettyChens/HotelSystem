package vo.uservo;

import javax.swing.ImageIcon;

import po.PersonDetailPO;
import util.TransHelper;
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
	
	private UserType userType;
	
	public BasicInfoVO(){
	}
	
	public BasicInfoVO(String userName,String userID,UserType userType){
		this.setUserName(userName);
		this.setUserID(userID);
		this.setUserType(userType);
	}

	/**
	 * po to vo //?这里是从PersonDetailVO那里来还是从PO那里拿过来信息？
	 * @param personDetailPO
	 */
	public BasicInfoVO (PersonDetailPO personDetailPO) {
		this.setUserName(personDetailPO.getName());
		this.setUserImage(personDetailPO.getImage());
		this.setUserID(TransHelper.idToString(personDetailPO.getId(),6));
	    this.setUserType(personDetailPO.getUserType());
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
