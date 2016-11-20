package vo.personnelvo;

import java.util.Date;

import javax.swing.ImageIcon;

import po.PersonDetailPO;
import util.CustomerType;
import util.TransHelper;
import util.UserType;

public class PersonDetailVO {

	/**
	 * 用户详细信息的vo类，职责为实现逻辑层和界面层之间详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	private String userId;
	// 用户名名称
	private String userName;
	// 密码
	private String password;
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

	// 所在酒店名称
	private String hotelName;
	// 用户种类
	private UserType userType;
	
	
	

	public PersonDetailVO() {

	}
	/**
	 * vo的构造函数
	 * 
	 * @param PersonDetailPO
	 */
	public PersonDetailVO(PersonDetailPO po) {
		this.setId(TransHelper.idToString(po.getId(),6));
		this.setName(po.getName());
		this.setImage(po.getImage());
		this.setTelephone(po.getTelephone());
		this.setCredit(po.getCredit());
		this.setBirthday(po.getBirthday());
		this.setEnterpriseName(po.getEnterpriseName());

		this.setVIPType(po.getVIPType());
		this.setPassword(po.getPassword());
		this.setHotelName(po.getHotelName());
        this.setUserType(po.getUserType());;
	}

	/**
	 * vo的构造函数
	 * 
	 * @param customerId
	 * @param customername
	 * @param customerimage
	 * @param telephone
	 * @param credit
	 * @param birthday
	 * @param VIPgrade
	 * @param password
	 */
	public PersonDetailVO(String customerId, String customername, ImageIcon customerimage, String telephone, int credit,
			Date birthday, String password, String hotelName) {
		this.userName = customername;
		this.userImage = customerimage;
		this.telephone = telephone;
		this.credit = credit;
		this.birthday = birthday;

		this.userId = customerId;
		this.password = password;
		this.hotelName = hotelName;
	}
 
	public PersonDetailPO toPO(){
		return new PersonDetailPO(TransHelper.idToInt(userId), userName, userImage, telephone,credit, birthday,
				enterpriseName, VIPType,password, hotelName, userType);
	}

	public String getId() {
		return userId;
	}
	public void setId(String id) {
		this.userId = id;
	}
	public String getName() {
		return userName;
	}
	public void setName(String name) {
		this.userName = name;
	}
	public ImageIcon getImage() {
		return userImage;
	}
	public void setImage(ImageIcon image) {
		this.userImage = image;
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

	
	public CustomerType getVIPType() {
		return VIPType;
	}
	public void setVIPType(CustomerType vIPType) {
		VIPType = vIPType;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
}
