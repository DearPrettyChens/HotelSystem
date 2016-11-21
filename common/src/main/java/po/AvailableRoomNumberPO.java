package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import util.BedType;

public class AvailableRoomNumberPO  implements Serializable{
	/**
	 * 
	 * 
	 * 实现对某一天房间类型的修改
	 * @author Cy
	 * @virsion 1.0
	 */
	
	private int number;//房间数量
	private BedType bedType;//床型
	private long dateStamp;//日期
	private int hotelNumber;//酒店编号
//	private String hotelName;//酒店名字
	
	
	
	
	public AvailableRoomNumberPO(){
		
	}
    public AvailableRoomNumberPO(int number,BedType bedType,Date date,int hotelNumber){
		this.number=number;
		this.bedType=bedType;
		this.dateStamp=date.getTime();
		this.hotelNumber=hotelNumber;
//		this.hotelName=hotelName;
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
		return new Date(dateStamp);
	}
	public void setDate(Date date) {
		this.dateStamp = date.getTime();
	}
	public int getHotelNumber() {
		return hotelNumber;
	}
	public void setHotelNumber(int hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	
	 
	
}
