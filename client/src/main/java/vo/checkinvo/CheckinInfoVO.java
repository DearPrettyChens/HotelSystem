package vo.checkinvo;

import java.util.Date;

import po.CheckinInfoPO;
import util.BedType;
 
public class CheckinInfoVO {
	/**
	 * 酒店入住信息（CheckinInfoPO）
1）用户真实姓名
2）身份证号（数字）
3）联系方式（11位手机号）
4）房间号（数字）
5）房间类型
6）实际入住时间（-年-月-日-时-分）
7）实际退房时间（-年-月-日-时-分）
8）酒店编号
9）订单号
@author Cy
@virsion 1.0
	 */
	private String costumerName;//用户真实姓名
	private String ID;//身份证号（数字
	private String tel;//联系方式（11位手机号）
	private String roomNumber;//房间号（数字
	private BedType bedType;//房间类型
	private String roomType;
	private Date checkinTime;//实际入住时间（-年-月-日-时-分）
	private Date checkoutTime;//实际退房时间（-年-月-日-时-分）
	private String hotelNumber;//酒店编号
	private String orderNumber;//订单号
	
	public CheckinInfoVO(){
		
	}
    public CheckinInfoVO(CheckinInfoPO po){
    	this.bedType=po.getBedtype();
    	this.setRoomType(po.getRoomtype());
    	this.roomNumber=po.getRoomnumber();
    	this.checkinTime=po.getCheckintime();
    	this.checkoutTime=po.getCheckouttime();
    	this.hotelNumber=po.getHotelnumber();
    	this.orderNumber=po.getOrdernumber();
    	this.costumerName=po.getName();
    	this.roomType=po.getRoomtype();
    	this.ID=po.getID();
    	this.tel=po.getTel();
    	
		
	}
	public CheckinInfoVO( String costumername,String ID, String tel,String roomnumber, String roomType,BedType bedtype,
			Date checkintime, Date checkouttime,String hotelnumber, String ordernumber){
		
		this.costumerName=costumername;
		this. ID= ID;
		this.tel=tel;
		this.roomNumber=roomnumber;
		this.bedType=bedtype;
		this.setRoomType(roomType);
		this.checkinTime=checkintime;
		this.checkoutTime=checkouttime;
		this.hotelNumber=hotelnumber;
		this.orderNumber=ordernumber;
		
		
		
	}
	
	public String getCostumername() {
		return costumerName;
	}
	public void setCostumername(String costumername) {
		this.costumerName = costumername;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRoomnumber() {
		return roomNumber;
	}
	public void setRoomnumber(String roomnumber) {
		this.roomNumber = roomnumber;
	}
	public BedType getBedtype() {
		return bedType;
	}
	public void setBedtype(BedType bedType) {
		this.bedType = bedType;
	}
	public Date getCheckintime() {
		return checkinTime;
	}
	public void setCheckintime(Date checkintime) {
		this.checkinTime = checkintime;
	}
	public Date getCheckouttime() {
		return checkoutTime;
	}
	public void setCheckouttime(Date checkouttime) {
		this.checkoutTime = checkouttime;
	}
	public String getHotelnumber() {
		return hotelNumber;
	}
	public void setHotelnumber(String hotelnumber) {
		this.hotelNumber = hotelnumber;
	}
	public String getOrdernumber() {
		return orderNumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.orderNumber = ordernumber;
	}
	
	public CheckinInfoPO votopo(){
		return new CheckinInfoPO(this.costumerName,this.ID,this.tel,null,this.bedType,this.roomNumber
				,this.checkinTime,this.checkoutTime,this.hotelNumber,this.orderNumber);
		
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
 
	
}
