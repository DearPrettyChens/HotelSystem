package businesslogic.bl.availableroombl;

import dao.availableroomdao.AvailableRoomDao;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.SingleAvailableRoomInfoVO;
/**
 * 某一种客房的类
 * @author CLL
 * @version 1.0
 */
public class SingleAvailableRoomInfo {
	private String  hotelNumber;//酒店编号
	private String roomType;//房型
	private BedType bedType;//床型
	private double originalPrice;//原始价格
	private double lowestPrice;//最低价格
	private int roomNum;//房间数量
	private AvailableRoomDao availableRoomDao;//数据层的引用
	
	public SingleAvailableRoomInfo(){
		
	}
	public SingleAvailableRoomInfo(String hotelNumber,String roomType,BedType bedType,
			double originalPrice,double lowestPrice,int roomNum){
		this.hotelNumber=hotelNumber;
		this.roomNum=roomNum;
		this.roomType=roomType;
		this.bedType=bedType;
		this.originalPrice=originalPrice;
		this.lowestPrice=lowestPrice;
	}
	public SingleAvailableRoomInfo(SingleAvailableRoomInfoVO vo){
		this.hotelNumber=vo.getHotelNumber();
		this.roomType=vo.getRoomType();
		this.bedType=vo.getBedType();
		this.originalPrice=vo.getOriginalPrice();
		this.lowestPrice=vo.getLowestPrice();
		this.roomNum=vo.getRoomNum();
	}
	/**
	 * 获得某种类型房间的可用信息
	 * @param hotelID
	 * @return AvailableRoomInfoVO
	 */
/*	public AvailableRoomInfoVO getAvailableRoomInfo(String hotelID){
		return null;
	}*/
	/**
	 * 修改数据库中的可用房间信息
	 * @param vo
	 * @return ResultMessage
	 */
/*	public ResultMessage confirmAvailableRoomInfo (AvailableRoomInfoVO vo){
		return null;
	}*/
	/**
	 * 修改房间最低价格
	 * @param lowestPrice
	 * @return null
	 */
	public void setDiscount(double discount) {
		this.lowestPrice = discount*this.lowestPrice;
	}
	public double getLowestPrice() {
		return 0;
	}
	//以下get,set都是和数据层的交互
/*	private String getHotelNumber() {
		return null;
	}

	private String getRoomType() {
		return null;
	}

	private ResultMessage setRoomType(String roomType) {
		this.roomType = roomType;
		return null;
	}

	private BedType getBedType() {
		return null;
	}

	private ResultMessage setBedType(BedType bedType) {
		this.bedType = bedType;
		return null;
	}

	private double getOriginalPrice() {
		return 0;
	}

	private ResultMessage setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
		return null;
	}



	private ResultMessage setLowestPrice(double lowestPrice) {
		this.lowestPrice = lowestPrice;
		return null;
	}

	private int getRoomNum() {
		return 0;
	}

	private ResultMessage setRoomNum(int roomNum) {
		this.roomNum = roomNum;
		return null;
	}
	*/
}
