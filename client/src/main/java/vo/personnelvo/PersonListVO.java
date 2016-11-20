package vo.personnelvo;

import javax.swing.ImageIcon;

import po.PersonListPO;
import util.TransHelper;
import util.UserType;

public class PersonListVO {

	/**
	 * 用户列表信息的vo类，职责为实现逻辑层和界面层之间顾客详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	private String userId;
	// 用户名名称
	private String userName;
	// 头像
	private ImageIcon userImage;
	// 联系方式11位
	private String telephone;
	// 所在酒店名称
	private String hotelName;
	// 用户种类
	private UserType userType;
	

	public PersonListVO() {

	}
	public PersonListVO(PersonListPO po) {
		this.setId(TransHelper.idToString(po.getId(),6));
		this.setName(po.getName());
		this.setImage(po.getImage());
		this.setTelephone(po.getTelephone());
		this.setHotelName(po.getHotelName());
		this.setUserType(po.getUserType());
	}

	public PersonListVO(String Id, String Name, ImageIcon Image, String telephone, String hotelName,UserType userType) {
		this.userId = Id;
		this.userName = Name;
		this.userImage = Image;
		this.telephone = telephone;
		this.hotelName = hotelName;
		this.setUserType(userType);
	}

	public PersonListPO toPO(){
		
		return new PersonListPO(TransHelper.idToInt(userId),userName,userImage,telephone,hotelName,userType);
	}
	public String getId() {
		return userId;
	}

	public void setId(String id) {
		userId = id;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		userName = name;
	}

	public ImageIcon getImage() {
		return userImage;
	}

	public void setImage(ImageIcon image) {
		userImage = image;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
