package po;


import java.io.Serializable;
import java.util.ArrayList;

public class HotelWorkerListPO implements Serializable {
	
	/**
	 * 
	 * 
	 * 记录酒店工作人员列表信息
	 * @author CY
	 * @virsion 1.0
	 *  
	 * 
	 */
	private String ID;
	private String name;
	private String hotelName;
	public  HotelWorkerListPO(){
		
	}
public  HotelWorkerListPO(String ID,String name,String hotelName){
		this.ID=ID;
		this.name=name;
		this.hotelName=hotelName;
	
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
}