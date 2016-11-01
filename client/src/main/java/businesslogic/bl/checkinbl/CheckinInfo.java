package businesslogic.bl.checkinbl;

import java.util.Date;

import dataservice.availableroomdataservice.AvailableRoomDataService;
import util.BedType;
import util.ResultMessage;
import vo.checkinvo.CheckinInfoVO;

/**
 * 单条住房记录的类
 * @author CLL
 * @version1.0
 */
public class CheckinInfo {
	private String hotelID;//酒店编号
	private String name;//用户真实姓名
	private String ID;//身份证号（数字
	private String tel;//联系方式（11位手机号）
	private BedType bedType;//床类型
	private String roomNumber;//房间号（数字
	private Date checkinTime;//实际入住时间（-年-月-日-时-分）
	private Date checkoutTime;//实际退房时间（-年-月-日-时-分
	private String hotelNumber;//酒店编号
	private String orderNumber;//订单号
	//数据层的引用
	private AvailableRoomDataService availableRoomDataService;
	
	public CheckinInfo(){
		
	}
	
	/**
	 * 新增住房信息的构造函数
	 * @param vo
	 */
	public CheckinInfo(CheckinInfoVO vo){
		this.hotelID=vo.getHotelnumber();
		this.name=vo.getCostumername();
		this.ID=vo.getID();
		this.tel=vo.getTel();
		this.bedType=vo.getBedtype();
		this.roomNumber=vo.getRoomnumber();
		this.checkinTime=vo.getCheckintime();
		this.checkoutTime=vo.getCheckouttime();
		this.hotelNumber=vo.getHotelnumber();
		this.orderNumber=vo.getOrdernumber();
	}
	
	
	/**
	 * 获取查找到的顾客住房信息
	 * @param orderID
	 * @return CheckinInfo
	 */
	public CheckinInfoVO getCheckinInfo(){
		return null;
	}
	
	/**
	 * 修改顾客住房信息
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO vo){
		return null;
	}
	//以下get,set都是和数据层的交互
	private String getName() {
		return null;
	}
	private void setName(String name) {
		
	}
	private String getID() {
		return null;
	}
	private ResultMessage setID(String iD) {
		return null;
		
	}
	private String getTel() {
		return null;
	}
	private ResultMessage setTel(String tel) {
		return null;
		
	}
	private BedType getRoomtype() {
		return null;
	}
	private ResultMessage setRoomtype(BedType roomtype) {
		return null;
		
	}
	private String getRoomnumber() {
		return null;
	}
	private ResultMessage setRoomnumber(String roomnumber) {
		return null;
		
	}
	private Date getCheckintime() {
		return null;
	}
	private ResultMessage setCheckintime(Date checkintime) {
		return null;
		
	}
	private Date getCheckouttime() {
		return null;
	}
	private ResultMessage setCheckouttime(Date checkouttime) {
		return null;
		
	}
	private String getHotelnumber() {
		return null;
	}
	private ResultMessage setHotelnumber(String hotelnumber) {
		return null;
		
	}
	private String getOrdernumber() {
		return null;
	}
	private ResultMessage setOrdernumber(String ordernumber) {
		return null;
		
	}

	private String getHotelID() {
		return hotelID;
	}

	private void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
}
