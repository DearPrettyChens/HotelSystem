package po;

import java.io.Serializable;

import java.util.Date;


import javax.swing.ImageIcon;

import util.UserType;



/**
 * 传递顾客信息的po类，职责是实现数据层和逻辑层顾客信息的交互
 * @author CLL
 * @version1.0
 */
public class CustomerDetailPO implements Serializable{
	//顾客id
	private String customerId;
	//用户名名称，暂定为真实姓名
	private String customerName;
	//头像
	private ImageIcon customerImage;
	//联系方式11位
	private String telephone;
	//信用值
	private int credit;
	//生日
	private long birthdayStamp;
	//企业名称
	private String enterpriseName;
	//会员等级
	private int VIPgrade;
	//会员类型（企业会员和普通会员两种）
	private UserType VIPType;
	//密码
	private String password;
	public CustomerDetailPO(){
		
	}
	/**
	 * 普通会员vo的构造函数
	 * @param customerId
	 * @param customername
	 * @param customerimage
	 * @param telephone
	 * @param credit
	 * @param birthday
	 * @param VIPgrade
	 * @param password
	 */
	public CustomerDetailPO(String customerId,String customername,ImageIcon customerimage,String telephone,int credit,Date birthday,int VIPgrade,String password){
		this.customerName=customername;
		this.customerImage=customerimage;
		this.telephone=telephone;
		this.credit=credit;
		this.birthdayStamp=birthday.getTime();
		this.VIPgrade=VIPgrade;
		this.customerId=customerId;
		this.password=password;
	}
	/**
	 * 企业会员vo的构造函数
	 * @param customerId
	 * @param customername
	 * @param customerimage
	 * @param enterprisename
	 * @param telephone
	 * @param credit
	 * @param VIPgrade
	 * @param password
	 */
	public CustomerDetailPO(String customerId,String customername,ImageIcon customerimage,String enterprisename,String telephone,int credit,int VIPgrade,String password){
		this.customerName=customername;
		this.customerImage=customerimage;
		this.telephone=telephone;
		this.credit=credit;
		this.enterpriseName=enterprisename;
		this.VIPgrade=VIPgrade;
		this.customerId=customerId;
		this.password=password;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public ImageIcon getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(ImageIcon customerImage) {
		this.customerImage = customerImage;
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
		return new Date(birthdayStamp);
	}

	public void setBirthday(Date birthday) {
		this.birthdayStamp = birthday.getTime();
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
	
	public void setVIPType(UserType VIPType) {
		this.VIPType = VIPType;
	}

	public UserType getVIPType() {
		return VIPType;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
