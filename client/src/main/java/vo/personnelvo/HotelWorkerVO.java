package vo.personnelvo;
/**
 * 新增一个酒店及其工作人员的VO类
 * @author CLL
 *
 */
public class HotelWorkerVO {
	//新增酒店名称
	private String hotelName;
	//新增酒店工作人员用户名
	private String hotelWorkerName;
	//酒店工作人员账户初始密码
	private String password;
	
	public HotelWorkerVO(){
		
	}
	
	public HotelWorkerVO(String hotelName,String hotelWorkerName,String password){
		this.setHotelName(hotelName);
		this.setHotelWorkerName(hotelWorkerName);
		this.setPassword(password);
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelWorkerName() {
		return hotelWorkerName;
	}

	public void setHotelWorkerName(String hotelWorkerName) {
		this.hotelWorkerName = hotelWorkerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
