package vo.personnelvo;

import javax.swing.ImageIcon;
/**
 * 酒店工作人员详细信息的vo类，职责为实现逻辑层和界面层之间酒店工作人员详细信息的交互
 * @author CLL
 * @version 1.0
 */
public class HotelWorkerDetailVO{
	//头像
	private ImageIcon hotelWorkerImage;
	//用户名（真实姓名）
	private String name;
	//密码
	private String password;
	//联系方式11位
	private String telephone;
	//所在酒店名称
	private String hotelName;
	//所在酒店编号
	private String hotelId;
	
	public HotelWorkerDetailVO(){
		
	}
	/**
	 * 酒店工作人员详细信息vo的构造函数
	 * @param hotelWorkerImage
	 * @param name
	 * @param password
	 * @param telephone
	 * @param hotelName
	 * @param hotelId
	 */
	public HotelWorkerDetailVO(ImageIcon hotelWorkerImage,String name,String password,String telephone,String hotelName,String hotelId){
		this.setHotelName(hotelName);
		this.setHotelWorkerImage(hotelWorkerImage);
		this.setHotelId(hotelId);
		this.setName(name);
		this.setTelephone(telephone);
		this.setPassword(password);
	}

	public ImageIcon getHotelWorkerImage() {
		return hotelWorkerImage;
	}

	public void setHotelWorkerImage(ImageIcon hotelWorkerImage) {
		this.hotelWorkerImage = hotelWorkerImage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
}
