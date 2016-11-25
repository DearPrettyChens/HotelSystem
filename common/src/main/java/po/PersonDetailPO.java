package po;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

import util.CustomerType;
import util.UserType;

@Entity
@Table(name = "new_user")
public class PersonDetailPO {
	/**
	 * 用户详细信息的po类，职责为实现逻辑层和数据层之间详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	// 用户名名称
	@Column(name = "user_name")
	private String userName;
	// 头像
	@Column(name = "user_image")
	private String userImagePosition;
	@Transient
	private ImageIcon userImage;
	// 联系方式11位
	@Column(name = "user_telephone")
	private String telephone;
	// 信用值
	@Column(name = "customer_credit")
	private int credit;
	// 生日
	@Column(name = "user_birthday")
	private java.sql.Date birthdayStamp;
	// 企业名称
	@Column(name = "enterprise_name")
	private String enterpriseName;
	// 会员类型（企业会员和普通会员两种）
	@Column(name = "customer_type")
	private String vipTypeInSQL;
	// 密码
	@Column(name = "user_password")
	private String password;
	// 所在酒店名称
	@Column(name = "hotelworker_hotelname")
	private String hotelName;
	// 用户种类
	@Column(name = "user_type")
	private String userTypeInSQL;

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
			String enterpriseName, CustomerType viptype, String password, String hotelName, UserType userType) {
		super();
		this.setId(id);
		this.setName(name);
		this.setImage(image);
		this.setTelephone(telephone);
		this.setCredit(credit);
		this.setBirthday(birthday);
		this.setEnterpriseName(enterpriseName);
		this.setVIPType(viptype);
		this.setPassword(password);
		this.setHotelName(hotelName);
		this.setUserType(userType);
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
		if (birthdayStamp == null)
			return null;
		return new Date(birthdayStamp.getTime());
	}

	public void setBirthday(Date birthday) {
		if (birthday != null)
			this.birthdayStamp = new java.sql.Date(birthday.getTime());
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public CustomerType getVIPType() {
		CustomerType customerType = null;
		switch (vipTypeInSQL) {
		case "INDIVIDUAL":
			customerType = CustomerType.INDIVIDUAL;

			break;
		case "ENTERPRISE":
			customerType = CustomerType.ENTERPRISE;
			break;
		default:
			break;
		}
		return customerType;
	}

	public void setVIPType(CustomerType type) {
		if (type != null)
			vipTypeInSQL = type.getString();
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
		UserType userType = null;
		switch (userTypeInSQL) {
		case "Customer":
			userType = UserType.Customer;
			break;
		case "HotelWorker":
			userType = UserType.HotelWorker;
			break;
		case "Manager":
			userType = UserType.Manager;
			break;
		case "WebMarketMan":
			userType = UserType.WebMarketMan;
			break;
		default:
			break;
		}
		return userType;
	}

	public void setUserType(UserType userType) {
		if (userType != null)
			this.userTypeInSQL = userType.getString();
	}

	public PersonDetailPO copy() {
		return new PersonDetailPO(getId(), getName(), getImage(), getTelephone(), getCredit(), getBirthday(),
				getEnterpriseName(), getVIPType(), getPassword(), getHotelName(), getUserType());
	}
}
