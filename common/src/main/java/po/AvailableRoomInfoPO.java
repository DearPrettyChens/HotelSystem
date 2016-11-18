package po;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import util.BedType;



public class AvailableRoomInfoPO implements Serializable {
	
	/**
	 * 当前可用客房信息（AvailableroomPO)
	 * 房型、床型、各房型总数量、可用客房数量、原始价格、最低价格、酒店编号
	 * 
	 * @author Cy
	 * @virsion 1.0
	 * */
	private int  hotelNumber;//酒店编号
	private String roomType;//房型
	private BedType bedType;//床型
	private double originalPrice;//原始价格
	private double lowestPrice;//最低价格
	private int originalNumber;//各房型总数量
	private int currentNumber;//当前数量
	
	public AvailableRoomInfoPO(){
		
	}
	
    public AvailableRoomInfoPO(int  hotelNumber,String roomType
    		,BedType bedType,double originalPrice,double lowestPrice,int originalNumber,int currentNumber){
		this.hotelNumber=hotelNumber;
		this.roomType=roomType;
		this.bedType=bedType;
		this.originalPrice=originalPrice;
		this.lowestPrice=lowestPrice;
		this.originalNumber=originalNumber;
		this.currentNumber=currentNumber;
	}
 
	public int getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(int hotelNumber) {
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

	public int getOriginalNumbers() {
		return originalNumber;
	}

	public void setOriginalNumbers(int originalNumber) {
		this.originalNumber = originalNumber;
	}

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}


}

