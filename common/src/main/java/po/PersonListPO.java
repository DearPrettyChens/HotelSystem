package po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.swing.ImageIcon;

import util.UserType;

@Entity
@Table(name = "new_user")
public class PersonListPO {
	/**
	 * 用户列表信息的po类，职责为实现逻辑层和数据层之间用户详细信息的交互
	 * 
	 * @author Cy
	 * @version 1.0
	 */

	// id
	@Id
	@Column(name = "user_id")
	private int Id;
	// 用户名名称
	@Column(name = "user_name")
	private String Name;
	// 头像
	@Column(name = "user_image")
	private String imageInSQL;
	@Transient
	private ImageIcon Image;
	// 联系方式11位
	@Column(name = "user_telephone")
	private String telephone;
	// 所在酒店名称
	@Column(name = "hotelworker_hotelname")
	private String hotelName;
	// 用户种类
	@Column(name = "user_type")
	private String userTypeInSQL;
	@Version
	@Column(name = "version")
	private int version;
	public PersonListPO() {

	}

	public PersonListPO(int Id, String Name, ImageIcon Image, String telephone, String hotelName, UserType userType) {

		this.Id = Id;
		this.Name = Name;
		this.Image = Image;
		this.telephone = telephone;
		this.hotelName = hotelName;
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

	public PersonListPO copy() {
		return new PersonListPO(getId(), getName(), getImage(), getTelephone(), getHotelName(), getUserType());
	}

	public String getImageInSQL() {
		return imageInSQL;
	}

	public void setImageInSQL(String imageInSQL) {
		this.imageInSQL = imageInSQL;
	}

}
