package businesslogic.bl.availableroombl;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import util.BedType;
import util.ResultMessage;
import vo.availableroomvo.AvailableRoomInfoVO;
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
	private int originalNum;//房间原始数量
//	private AvailableRoomDao availableRoomDao;//数据层的引用
	
	public SingleAvailableRoomInfo(){
		
	}
	public SingleAvailableRoomInfo(String hotelNumber,String roomType,BedType bedType,
			double originalPrice,double lowestPrice,int roomNum,int originalNum){
		this.hotelNumber=hotelNumber;
		this.roomNum=roomNum;
		this.roomType=roomType;
		this.bedType=bedType;
		this.originalPrice=originalPrice;
		this.lowestPrice=lowestPrice;
		this.originalNum=originalNum;
	}
	public SingleAvailableRoomInfo(AvailableRoomInfoVO vo){
		this.hotelNumber=vo.getHotelNumber();
		this.roomType=vo.getRoomType();
		this.bedType=vo.getBedType();
		this.originalPrice=vo.getOriginalPrice();
		this.lowestPrice=vo.getLowestPrice();
		this.roomNum=vo.getCurrentNumber();
		this.originalNum=vo.getOriginalNumbers();
	}
	/**
	 * 获得房间的可用信息
	 * @param 
	 * @return AvailableRoomInfoVO
	 */
	public AvailableRoomInfoPO getAvailableRoomInfo(){
		return new AvailableRoomInfoPO(idToInt(this.hotelNumber),this.roomType,this.bedType
				,this.originalPrice,this.lowestPrice,this.originalNum,this.roomNum);
	}
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
	/**
	 * 编号string转化成int
	 */
	private static int idToInt(String id){
		int i=0;
		for(i=0;i<id.length();i++){
			if(id.charAt(i)!='0'){
				break;
			}
		}
		return Integer.parseInt(id.substring(i));
	}
	/**
	 * id to string
	 */
	private static String idToString(int id){
		String result=String.valueOf(id);
		while(result.length()<6){
			result="0"+result;
		}
		return result;
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
