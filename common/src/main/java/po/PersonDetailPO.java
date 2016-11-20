package po;

import java.util.Date;

import javax.swing.ImageIcon;

import util.CustomerType;
import util.UserType;

public class PersonDetailPO {
	/**
	 * 用户详细信息的po类，职责为实现逻辑层和数据层之间详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	private int userId;
	// 用户名名称
	private String userName;
	// 头像
	private ImageIcon userImage;
	// 联系方式11位
	private String telephone;
	// 信用值
	private int credit;
	// 生日
	private Date birthday;
	// 企业名称
	private String enterpriseName;
	// 会员类型（企业会员和普通会员两种）
	private CustomerType VIPType;
	// 密码
	private String password;
	// 所在酒店名称
	private String hotelName;
	// 用户种类
	private UserType userType;

	public PersonDetailPO() {

	}

  
	/**
	 * @param id
	 * @param name
	 * @param image
	 * @param telephone
	 * @param credit
	 * @param birthday
	 * @param enterpriseName
	 * @param vIPType
	 * @param password
	 * @param hotelName
	 * @param userType
	 */
	public PersonDetailPO(int id, String name, ImageIcon image, String telephone, int credit, Date birthday,
			String enterpriseName, CustomerType vIPType, String password, String hotelName, UserType userType) {
		super();
		userId = id;
		userName = name;
		userImage = image;
		this.telephone = telephone;
		this.credit = credit;
		this.birthday = birthday;
		this.enterpriseName = enterpriseName;
		VIPType = vIPType;
		this.password = password;
		this.hotelName = hotelName;
		this.userType = userType;
	}


	public int getId() {
		return userId;
	}

	public void setId(int id) {
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

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}


	public CustomerType getVIPType() {
		return VIPType;
	}

	public void setVIPType(CustomerType type) {
		VIPType = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
