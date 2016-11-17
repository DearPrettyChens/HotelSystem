package vo.uservo;

import java.util.Date;

import javax.swing.ImageIcon;

import po.PersonDetailPO;
import util.UserType;

/**
 * 个人详细信息
 * 
 * @author CYF
 * @version 1.0 
 */
public class DetailInfoVO {
	// 用户名
	private String userName;
	// 联系方式
	private String telephone;
	// 用户头像
	private ImageIcon userImage;
	// 用户种类
	private UserType userType;
	// 所属企业
	private String enterprise;
	// 生日
	private Date birth;
	// 用户ID
	private String userID;

	public DetailInfoVO() {
	}

	/**
	 * po to vo
	 * @param PersonDetailPO po
	 */
	public DetailInfoVO(PersonDetailPO po){
		this.setBirth(po.getBirthday());
		this.setEnterprise(po.getEnterpriseName());
		this.setTelephone(po.getTelephone());
		this.setUserID(idToString(po.getId()));
		this.setUserImage(po.getImage());
		this.setUserName(po.getName());
		this.setUserType(po.getVIPType());
		
	}
	
	/**
	 * vo to po
	 * @return PersonDetailPO
	 */
	public PersonDetailPO toPO() {
		return new PersonDetailPO(idToInt(userID), userName, userImage, telephone, 0, birth, null, null, enterprise,null);
	}
	
	public DetailInfoVO(String userName, String telephone, ImageIcon userImage, UserType userType, String enterprise,String id) {
		this.setUserName(userName);
		this.setTelephone(telephone);
		this.setUserImage(userImage);
		this.setUserType(userType);
		this.setEnterprise(enterprise);
		this.setUserID(id);
	}
	public DetailInfoVO(String userName, String telephone, ImageIcon userImage, UserType userType, String enterprise) {
		this.setUserName(userName);
		this.setTelephone(telephone);
		this.setUserImage(userImage);
		this.setUserType(userType);
		this.setEnterprise(enterprise);
	}

	// 普通会员的构造vo
	public DetailInfoVO(String userName, String telephone, ImageIcon userImage, UserType userType, Date birth,String id) {
		this.setUserName(userName);
		this.setTelephone(telephone);
		this.setUserImage(userImage);
		this.setUserType(userType);
		this.setBirth(birth);
		this.setUserID(id);
	}
	public DetailInfoVO(String userName, String telephone, ImageIcon userImage, UserType userType, Date birth) {
		this.setUserName(userName);
		this.setTelephone(telephone);
		this.setUserImage(userImage);
		this.setUserType(userType);
		this.setBirth(birth);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public ImageIcon getUserImage() {
		return userImage;
	}

	public void setUserImage(ImageIcon userImage) {
		this.userImage = userImage;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * 编号string转化成int
	 */
	private static int idToInt(String id){
		String temp="";
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)!='0'){
				temp=temp+id.charAt(i);
			}
		}
		return Integer.parseInt(temp);
	}
	/**
	 * id to string
	 */
	private static String idToString(int id){
		String result=String.valueOf(id);
		while(result.length()<6){
			result="0"+result;
		}
		return result;
	}
}
