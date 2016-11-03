package vo.availableroomvo;

import java.io.Serializable;
import java.util.Date;

import po.AvailableRoomNumberPO;
import util.BedType;

public class AvailableRoomNumberVO  implements Serializable{
	/**
	 * 
	 * 
	 * 实现对某一天房间类型的修改
	 * @author Cy
	 * @virsion 1.0
	 */
	
	private int number;//房间数量
	private BedType bedType;//床型
	private Date date;//日期
	private String hotelNumber;//酒店编号
	private String hotelName;//酒店名字
	
	
	
	
	public AvailableRoomNumberVO(){
		
	}
    public AvailableRoomNumberVO(int number,BedType bedType,Date date,String hotelNumber,String hotelName){
		this.number=number;
		this.bedType=bedType;
		this.date=date;
		this.hotelNumber=hotelNumber;
		this.hotelName=hotelName;
	}
    /**
     * po to vo
     * @param availableRoomNumberPO
     */
    public AvailableRoomNumberVO(AvailableRoomNumberPO availableRoomNumberPO){
    	this.number=availableRoomNumberPO.getNumber();
    	this.bedType=availableRoomNumberPO.getBedType();
    	this.date=availableRoomNumberPO.getDate();
    	this.hotelNumber=availableRoomNumberPO.getHotelNumber();
    	this.hotelName=availableRoomNumberPO.getHotelName();
    }
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public BedType getBedType() {
		return bedType;
	}
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getHotelNumber() {
		return hotelNumber;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	 
	
}
