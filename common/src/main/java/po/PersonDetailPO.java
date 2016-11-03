package po;

import java.util.Date;

import javax.swing.ImageIcon;

import util.UserType;

public class PersonDetailPO {
	/**
	 * 用户详细信息的po类，职责为实现逻辑层和数据层之间详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	private String Id;
	// 用户名名称
	private String Name;
	// 头像
	private ImageIcon Image;
	// 联系方式11位
	private String telephone;
	// 信用值
	private int credit;
	// 生日
	private Date birthday;
	// 企业名称
	private String enterpriseName;
	// 会员等级
	private int VIPgrade;
	// 会员类型（企业会员和普通会员两种）
	private UserType VIPType;
	// 密码
	private String password;
	// 所在酒店名称
	private String hotelName;

	public PersonDetailPO() {

	}
  //  public PersonDetailPO(PersonDetailVO vo){
    	
 //   }
    /**
	 * po的构造函数
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
	public PersonDetailPO(String customerId, String customername, ImageIcon customerimage, String telephone, int credit,
			Date birthday, int VIPgrade, String password, String hotelName,String enterprise) {
		this.Name = customername;
		this.Image = customerimage;
		this.telephone = telephone;
		this.credit = credit;
		this.birthday = birthday;
		this.VIPgrade = VIPgrade;
		this.Id = customerId;
		this.password = password;
		this.hotelName = hotelName;
		this.enterpriseName = enterprise;
	}
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ImageIcon getImage() {
		return Image;
	}

	public void setImage(ImageIcon image) {
		Image = image;
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

	public int getVIPgrade() {
		return VIPgrade;
	}

	public void setVIPgrade(int vIPgrade) {
		VIPgrade = vIPgrade;
	}

	public UserType getVIPType() {
		return VIPType;
	}

	public void setVIPType(UserType vIPType) {
		VIPType = vIPType;
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
}
