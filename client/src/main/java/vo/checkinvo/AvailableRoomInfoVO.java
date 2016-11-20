package vo.checkinvo;

import java.io.Serializable;

import po.AvailableRoomInfoPO;
import util.BedType;
import util.TransHelper;

public class AvailableRoomInfoVO implements Serializable {
	
	/**
	 * 当前可用客房信息（AvailableroomPO)
	 * 房型、床型、各房型总数量、可用客房数量、原始价格、最低价格、酒店编号
	 * @author CLL
	 * @version 1.0 
	 */
	private String  hotelNumber;//酒店编号
	private String roomType;//房型
	private BedType bedType;//床型
	private double originalPrice;//原始价格
	private double lowestPrice;//最低价格
	private int originalNumber;//各房型总数量
	private int currentNumber;//当前数量
	
	public AvailableRoomInfoVO(){
		
	}
	
    public AvailableRoomInfoVO(String hotelNumber,String roomType
    		,BedType bedType,double originalPrice,double lowestPrice,int originalNumber,int currentNumber){
		this.hotelNumber=hotelNumber;
		this.roomType=roomType;
		this.bedType=bedType;
		this.originalPrice=originalPrice;
		this.lowestPrice=lowestPrice;
		this.originalNumber=originalNumber;
		this.currentNumber=currentNumber;
	}
    
	public AvailableRoomInfoVO(AvailableRoomInfoPO po){
		this.hotelNumber=TransHelper.idToString(po.getHotelNumber(),6);
		this.roomType=po.getRoomType();
		this.bedType=po.getBedType();
		this.originalPrice=po.getOriginalPrice();
		this.lowestPrice=po.getLowestPrice();
		this.originalNumber=po.getOriginalNumbers();
		
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


	public AvailableRoomInfoPO votopo(){
		
		return new AvailableRoomInfoPO(TransHelper.idToInt(this.hotelNumber),this.roomType
	    		,this.bedType,this.originalPrice,this.lowestPrice,this.originalNumber,
	    		this.currentNumber);
		
	}


}

