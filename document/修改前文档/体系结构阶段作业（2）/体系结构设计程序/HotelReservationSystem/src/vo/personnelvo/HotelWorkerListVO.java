package vo.personnelvo;

/**
 * 酒店工作人员列表信息的vo类，职责为实现逻辑层和界面层之间酒店工作人员列表信息的交互
 * @author CLL
 * @version 1.0
 */
public class HotelWorkerListVO {
	//用户名（真实姓名）
	private String name;
	//联系方式11位
	private String telephone;
	//所在酒店名称
	private String hotelName;
	//所在酒店编号
	private String hotelId;
	
	public HotelWorkerListVO(){
		
	}
	/**
	 * 酒店工作人员列表信息vo的构造函数
	 * @param name
	 * @param telephone
	 * @param hotelName
	 * @param hotelId
	 */
	public HotelWorkerListVO(String name,String telephone,String hotelName,String hotelId){
		this.setHotelName(hotelName);
		this.setHotelId(hotelId);
		this.setName(name);
		this.setTelephone(telephone);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
