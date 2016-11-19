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
	private String id;
	// 用户名名称
	private String name;

	// 头像
	private ImageIcon image;
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
	
	
	

	public PersonDetailVO() {

	}
	/**
	 * vo的构造函数
	 * 
	 * @param PersonDetailPO
	 */
	public PersonDetailVO(PersonDetailPO po) {
		this.setId(idToString(po.getId()));
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
		this.name = customername;
		this.image = customerimage;
		this.telephone = telephone;
		this.credit = credit;
		this.birthday = birthday;

		this.id = customerId;
		this.password = password;
		this.hotelName = hotelName;
	}
 
	public PersonDetailPO toPO(){
		return new PersonDetailPO(TransHelper.idToInt(id), name, image, telephone,credit, birthday,
				enterpriseName, VIPType,password, hotelName, userType);
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ImageIcon getImage() {
		return image;
	}
	public void setImage(ImageIcon image) {
		this.image = image;
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
