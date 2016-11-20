package po;

import javax.swing.ImageIcon;

import util.UserType;

public class PersonListPO {
	/**
	 * 用户列表信息的po类，职责为实现逻辑层和数据层之间用户详细信息的交互
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
	// 所在酒店名称
	private String hotelName;
	// 用户种类
	private UserType userType;

	public PersonListPO(){
			
		}


	public PersonListPO(int Id,String Name,ImageIcon Image,String telephone,String hotelName,UserType userType){

			this.Id=Id;
			this.Name=Name;
			this.Image=Image;
			this.telephone=telephone;
			this.hotelName=hotelName;
			this.setUserType(userType);
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
