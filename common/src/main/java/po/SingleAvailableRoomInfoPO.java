package po;

import java.io.Serializable;

import util.BedType;


/**
 * 某种类型住房的po类
 * @author CLL
 *
 */
public class SingleAvailableRoomInfoPO implements Serializable{
	private String  hotelNumber;//酒店编号
	private String roomType;//房型
	private BedType bedType;//床型
	private double originalPrice;//原始价格
	private double lowestPrice;//最低价格
	
	public SingleAvailableRoomInfoPO(){
		
	}
	
	public SingleAvailableRoomInfoPO(String hotelNumber,String roomType,BedType bedType,double originalPrice,double lowestPrice){
		this.hotelNumber=hotelNumber;
		this.roomType=roomType;
		this.bedType=bedType;
		this.originalPrice=originalPrice;
		this.lowestPrice=lowestPrice;
	}
	
	public String getHotelNumber() {
		return hotelNumber;
	}
	public void setHotelNumber(String hotelNumber) {
		this.hotelNumber = hotelNumber;
	}
	
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public BedType getBedType() {
		return bedType;
	}
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}
	public double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public void setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
	}
}
