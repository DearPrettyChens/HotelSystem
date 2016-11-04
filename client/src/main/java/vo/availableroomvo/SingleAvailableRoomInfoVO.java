package vo.availableroomvo;

import po.SingleAvailableRoomInfoPO;
import util.BedType;

public class SingleAvailableRoomInfoVO {
	private String  hotelNumber;//酒店编号
	private String roomType;//房型
	private BedType bedType;//床型
	private double originalPrice;//原始价格
	private double lowestPrice;//最低价格
	private int roomNum;//房间数量
	
	public SingleAvailableRoomInfoVO(){
		
	}
	
	public SingleAvailableRoomInfoVO(String hotelNumber,String roomType,BedType bedType,double originalPrice,double lowestPrice){
		this.hotelNumber=hotelNumber;
		this.roomType=roomType;
		this.bedType=bedType;
		this.originalPrice=originalPrice;
		this.lowestPrice=lowestPrice;
	}
	/**
	 * po to vo
	 * @param singleAvailableRoomInfoPO
	 */
	public SingleAvailableRoomInfoVO(SingleAvailableRoomInfoPO singleAvailableRoomInfoPO){
		this.hotelNumber=singleAvailableRoomInfoPO.getHotelNumber();
		this.roomType=singleAvailableRoomInfoPO.getRoomType();
		this.bedType=singleAvailableRoomInfoPO.getBedType();
		this.originalPrice=singleAvailableRoomInfoPO.getOriginalPrice();
		this.lowestPrice=singleAvailableRoomInfoPO.getLowestPrice();
	}
	/**
	 * vo to po
	 * @return SingleAvailableRoomInfoPO
	 */
	public SingleAvailableRoomInfoPO toPO(){
		return new SingleAvailableRoomInfoPO(this.hotelNumber,this.roomType,this.bedType,
				this.originalPrice,this.lowestPrice);
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

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
}
