package businesslogic.bl.availableroombl;

import po.AvailableRoomInfoPO;
import util.BedType;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;

/**
 * 某一种客房的类
 * 
 * @author CLL
 * @version 1.0
 */
public class SingleAvailableRoomInfo {
	private String hotelNumber;// 酒店编号
	private String roomType;// 房型
	private BedType bedType;// 床型
	private double originalPrice;// 原始价格
	private double lowestPrice;// 最低价格
	private int roomNum;// 房间数量
	private int originalNum;// 房间原始数量

	public SingleAvailableRoomInfo() {

	}

	public SingleAvailableRoomInfo(String hotelNumber, String roomType, BedType bedType, double originalPrice,
			double lowestPrice, int roomNum, int originalNum) {
		this.hotelNumber = hotelNumber;
		this.roomNum = roomNum;
		this.roomType = roomType;
		this.bedType = bedType;
		this.originalPrice = originalPrice;
		this.lowestPrice = lowestPrice;
		this.originalNum = originalNum;
	}

	public SingleAvailableRoomInfo(AvailableRoomInfoVO vo) {
		this.hotelNumber = vo.getHotelNumber();
		this.roomType = vo.getRoomType();
		this.bedType = vo.getBedType();
		this.originalPrice = vo.getOriginalPrice();
		this.lowestPrice = vo.getLowestPrice();
		this.roomNum = vo.getCurrentNumber();
		this.originalNum = vo.getOriginalNumbers();
	}

	/**
	 * 获得房间的可用信息
	 * 
	 * @param
	 * @return AvailableRoomInfoVO
	 */
	public AvailableRoomInfoPO getAvailableRoomInfo() {
		return new AvailableRoomInfoPO(TransHelper.idToInt(this.hotelNumber), this.roomType, this.bedType,
				this.originalPrice, this.lowestPrice, this.originalNum, this.roomNum);
	}

	/**
	 * 修改房间最低价格
	 * 
	 * @param lowestPrice
	 * @return null
	 */
	public void setDiscount(double discount) {
		this.lowestPrice = discount * this.originalPrice;
	}

	public double getLowestPrice() {
		return this.lowestPrice;
	}

}
