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
	private int Id;
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

	// 会员类型（企业会员和普通会员两种）
	private UserType VIPType;
	// 密码
	private String password;
	// 所在酒店名称
	private String hotelName;
	//标签
	private String tab;
	

	

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
	 * @param password
	 */

	public PersonDetailPO(int customerId, String customername, ImageIcon customerimage, String telephone, int credit,
			Date birthday, String password, String hotelName,String enterprise,String tab) {

		this.Name = customername;
		this.Image = customerimage;
		this.telephone = telephone;
		this.credit = credit;
		this.birthday = birthday;
		this.Id = customerId;
		this.password = password;
		this.hotelName = hotelName;
		this.enterpriseName = enterprise;
		this.tab=tab;
		
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
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
	public String getTab() {
		return tab;
	}

	public void setTab(String tab) {
		this.tab = tab;
	}

	
}
