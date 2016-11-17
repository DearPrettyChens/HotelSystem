package po;


import java.io.Serializable;
import java.util.Date;

import util.BedType;



public class CheckinInfoPO implements Serializable{
/**
 * 记录酒店入住信息:
 *1）用户真实姓名
 *2）身份证号（数字）
 *3）联系方式（11位手机号）
 *4）房间号（数字）
 *5）房间类型
 *6）实际入住时间（-年-月-日-时-分）
 *7）实际退房时间（-年-月-日-时-分）
 *8）酒店编号
 *9）订单号
@author Cy
@virSion 1.0


 */
	private String name;//用户真实姓名
	private String ID;//身份证号（数字
	private String tel;//联系方式（11位手机号）
	private BedType bedtype;//床类型
	private String roomtype;
	private String roomnumber;//房间号（数字
	private Date checkintime;//实际入住时间（-年-月-日-时-分）
	private Date checkouttime;//实际退房时间（-年-月-日-时-分
	private int hotelnumber;//酒店编号
	private String ordernumber;//订单号
	public CheckinInfoPO(){
		
	}
	
	public CheckinInfoPO(String name,String ID,String tel,String roomtype,BedType bedtype,String roomnumber
			,Date checkintime,Date checkouttime,int hotelnumber,String ordernumber){
		this.name=name;
		this.ID=ID;
		this.tel=tel;
		this.bedtype=bedtype;
		this.roomnumber=roomnumber;
		this.checkintime=checkintime;
		this.checkouttime=checkouttime;
		this.hotelnumber=hotelnumber;
		this.ordernumber=ordernumber;
		this.roomtype=roomtype;
		
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public BedType getBedtype() {
		return bedtype;
	}
	public void setBedtype(BedType bedtype) {
		this.bedtype = bedtype;
	}
	public String getRoomnumber() {
		return roomnumber;
	}
	public void setRoomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}
	public Date getCheckintime() {
		return checkintime;
	}
	public void setCheckintime(Date checkintime) {
		this.checkintime = checkintime;
	}
	public Date getCheckouttime() {
		return checkouttime;
	}
	public void setCheckouttime(Date checkouttime) {
		this.checkouttime = checkouttime;
	}
	public int getHotelnumber() {
		return hotelnumber;
	}
	public void setHotelnumber(int hotelnumber) {
		this.hotelnumber = hotelnumber;
	}
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	 public String getRoomtype(){
		 return roomtype;
	 }
	
	
	
}
