package businesslogic.bl.checkinbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.bl.availableroombl.AvailableRoom;
import businesslogic.bl.orderbl.SingleOrder;
import dao.checkindao.CheckinDao;
import init.RMIHelper;
import po.CheckinInfoPO;
import util.BedType;
import util.ResultMessage;
import util.TransHelper;
import vo.availableroomvo.AvailableRoomInfoVO;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.checkinvo.CheckinInfoVO;

/**
 * 单条住房记录的类
 * @author CLL
 * @version 1.0
 */
public class CheckinInfo {
	private String name;//用户真实姓名
	private String ID;//身份证号（数字
	private String tel;//联系方式（11位手机号）
	private BedType bedType;//床类型
	private String roomType;
	private String roomNumber;//房间号（数字
	private Date checkinTime;//实际入住时间（-年-月-日-时-分）
	private Date checkoutTime;//实际退房时间（-年-月-日-时-分
	private String hotelNumber;//酒店编号
	private String orderNumber;//订单号
	//数据层的引用
	private AvailableRoom availableRoom;
	private CheckinDao checkinDao;
	private SingleOrder singleOrder;
	
	public CheckinInfo(){
		//checkinDao=RMIHelper.getCheckinDao();
		checkinDao=new CheckinDao_Stub();
	}
	
	/**
	 * 构造函数
	 * @param vo
	 */
	public CheckinInfo(CheckinInfoVO vo){
		this.hotelNumber=vo.getHotelnumber();
		this.name=vo.getCostumername();
		this.ID=vo.getID();
		this.tel=vo.getTel();
		this.roomType=vo.getRoomType();
		this.bedType=vo.getBedtype();
		this.roomNumber=vo.getRoomnumber();
		this.checkinTime=vo.getCheckintime();
		this.checkoutTime=vo.getCheckouttime();
		this.orderNumber=vo.getOrdernumber();
		
		//checkinDao=RMIHelper.getCheckinDao();
		checkinDao=new CheckinDao_Stub();
		
	}
	/**
	 * 新增入住信息
	 * @return ResultMessage
	 * @throws RemoteException 
	 */
	public ResultMessage confirmCheckinInfo(){
		//更新订单中的实际入房时间
		singleOrder=new SingleOrder();
		checkinTime=new Date();
		ResultMessage result=singleOrder.setCheckinTime(checkinTime, orderNumber);
		if(result==ResultMessage.FAIL){
			return ResultMessage.FAIL;
		}
		//写入数据库住房信息
		try {
			return checkinDao.addCheckinInfo(new CheckinInfoPO(name,ID,tel,roomType,bedType,
					roomNumber,new Date(),checkoutTime,TransHelper.idToInt(hotelNumber),orderNumber));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	/**
	 * 获取查找到的顾客住房信息
	 * @param orderID
	 * @return CheckinInfo
	 */
	public CheckinInfoVO getCheckinInfo(String orderID){
		try {
			return new CheckinInfoVO(checkinDao.getCheckinInfo(orderID));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 修改顾客住房信息
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage confirmCheckoutInfo(CheckinInfoVO vo){
		//修改数据库中的住房信息
		try {
			ResultMessage result=checkinDao.modifyCheckinInfo(new CheckinInfoPO(
					vo.getCostumername(),vo.getID(),vo.getTel(),vo.getRoomType(),
					vo.getBedtype(),vo.getRoomnumber(),vo.getCheckintime(),
					new Date(),TransHelper.idToInt(vo.getHotelnumber()),vo.getOrdernumber()));
			if(result==ResultMessage.FAIL){
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
			return ResultMessage.FAIL;
		}
		
		//更新房间数量信息
		availableRoom=new AvailableRoom();
		ArrayList<AvailableRoomInfoVO> preRoomInfo=availableRoom.getAvailableRoomInfo(hotelNumber);
		//修改的是当天对应床型客房的数量
		int preRoomNumber=0;
		for(int i=0;i<preRoomInfo.size();i++){
			if(preRoomInfo.get(i).getBedType()==vo.getBedtype()){
				preRoomNumber=preRoomInfo.get(i).getCurrentNumber();
			}
		}
		//该房间数自动加1
		ResultMessage message=availableRoom.setAvailableRoomNumber(new AvailableRoomNumberVO(preRoomNumber+1,bedType,new Date(),hotelNumber));
		if(message==ResultMessage.FAIL){
			return ResultMessage.FAIL;
		}
		
		//更新订单中的实际退房时间
		singleOrder=new SingleOrder();
		ResultMessage result=singleOrder.setCheckoutTime(new Date(), vo.getOrdernumber());
		if(result==ResultMessage.FAIL){
			return ResultMessage.FAIL;
		}
		
		return ResultMessage.SUCCESS;
	}
	
	
	//以下get,set都是和数据层的交互
/*	private String getName() {
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
	}*/

	public String getHotelNumber() {
		return hotelNumber;
	}

	public void setHotelNumber(String hotelID) {
		this.hotelNumber = hotelID;
	}
}
