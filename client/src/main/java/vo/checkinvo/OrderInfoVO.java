package vo.checkinvo;

import java.util.Date;

import po.OrderInfoPO;
import util.BedType;
import util.Children;
import util.OrderState;
/**
 * 订单详细信息的vo类
 * @author Cy 
 * @version 1.0
 */
public class OrderInfoVO {
	//订单编号
	private String orderId;
	//顾客用户名
	private String customerName;
	//订单价格（保留整数）
	private double price;
	//入住人姓名
	private String lodgerName;
	//入住人联系方式11位
	private String lodgerTel;
	//预计入住时间（年月日）
	private Date expectCheckInTime;
	//预计退房时间（年月日）
	private Date expectCheckOutTime;
	//实际入住时间（年月日）
	private Date actualCheckInTime;
	//实际退房时间（年月日）
	private Date actualCheckOutTime;
	//订单状态
	private OrderState orderState;
	//酒店名称
	private String hotelName;
	//酒店联系方式（4位区号＋8位数字）
	private String hotelTel;
	//房间类型
	private String roomType;
	//房间数量
	private int roomNum;
	//入住人数
	private int lodgerNum;
	//有无儿童
	private Children children;
	//生成订单时间（年月日时分）
	private Date orderTime;
	//最晚入住时间（年月日时分）
	private Date latestCheckInTime;
	//是否评价
		private boolean hasRemarked;
	
	public OrderInfoVO(){
		
	}
    public OrderInfoVO(OrderInfoPO po){
    	this.orderId=po.getOrderID();
    	//顾客用户名
    	this.customerName=po.getCustomerID();
    	//订单价格（保留整数）
    	this.price=po.getPrice();
    	//入住人姓名
    	this.lodgerName=po.getLiveinPersonName();
    
    	this.lodgerTel=po.getLiveinPersonTelephone();
    	//预计入住时间（年月日）
    	this.expectCheckInTime=po.getExpectedCheckInTime();
    	//预计退房时间（年月日）
    	this.expectCheckOutTime=po.getExpectedCheckOutTime();
    	//实际入住时间（年月日）
    	this.actualCheckInTime=po.getActualCheckInTime();
    	//实际退房时间（年月日）
    	this.actualCheckOutTime=po.getActualCheckOutTime();
    	//订单状态
    	this. orderState=po.getState();
    	//酒店名称
    	this.hotelName=po.getHotelName();
    	//酒店联系方式（4位区号＋8位数字）
    	this.hotelTel=po.getHotelTelephone();
    	//房间类型
    	this.roomType=po.getRoomType();
    	//房间数量
    	//this.roomNum=po.get;
    	//入住人数
    	this.lodgerNum=po.getNumberOfPeople();
    	//有无儿童
    	this.children=po.getHasChild();
    	//生成订单时间（年月日时分）
    	this.orderTime=po.getOrderTime();
    	//最晚入住时间（年月日时分）
    	this.latestCheckInTime=po.getLateCheckInTime();
    	
		
	}
	
	public OrderInfoVO(String orderId,String customerName,double price,
			String lodgerName,String lodgerTel,Date expectCheckInTime,Date expectCheckOutTime,
			String roomType,int roomNum,int lodgerNum,Children children,Date actualCheckInTime,
			Date actualCheckOutTime,Date orderTime,OrderState orderState,String hotelName,
			String hotelTel,Date latestCheckInTime){
		this.orderId=orderId;
		this.customerName=customerName;
		this.price=price;

		this.lodgerName=lodgerName;
		this.lodgerTel=lodgerName;
		this.expectCheckInTime=expectCheckInTime;
		this.expectCheckOutTime=expectCheckOutTime;
		this.setRoomType(roomType);
		this.setRoomNum(roomNum);
		this.setLodgerNum(lodgerNum);
		this.setChildren(children);
		this.actualCheckInTime=actualCheckInTime;
		this.actualCheckOutTime=actualCheckOutTime;
		this.orderTime=orderTime;
		this.orderState=orderState;
		this.hotelName=hotelName;
		this.hotelTel=hotelTel;
		this.latestCheckInTime=latestCheckInTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


	public String getLodgerName() {
		return lodgerName;
	}

	public void setLodgerName(String lodgerName) {
		this.lodgerName = lodgerName;
	}

	public String getLodgerTel() {
		return lodgerTel;
	}

	public void setLodgerTel(String lodgerTel) {
		this.lodgerTel = lodgerTel;
	}

	public Date getExpectCheckInTime() {
		return expectCheckInTime;
	}

	public void setExpectCheckInTime(Date expectCheckInTime) {
		this.expectCheckInTime = expectCheckInTime;
	}

	public Date getExpectCheckOutTime() {
		return expectCheckOutTime;
	}

	public void setExpectCheckOutTime(Date expectCheckOutTime) {
		this.expectCheckOutTime = expectCheckOutTime;
	}

	public Date getActualCheckInTime() {
		return actualCheckInTime;
	}

	public void setActualCheckInTime(Date actualCheckInTime) {
		this.actualCheckInTime = actualCheckInTime;
	}

	public Date getActualCheckOutTime() {
		return actualCheckOutTime;
	}

	public void setActualCheckOutTime(Date actualCheckOutTime) {
		this.actualCheckOutTime = actualCheckOutTime;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelTel() {
		return hotelTel;
	}

	public void setHotelTel(String hotelTel) {
		this.hotelTel = hotelTel;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getLatestCheckInTime() {
		return latestCheckInTime;
	}

	public void setLatestCheckInTime(Date latestCheckInTime) {
		this.latestCheckInTime = latestCheckInTime;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getLodgerNum() {
		return lodgerNum;
	}

	public void setLodgerNum(int lodgerNum) {
		this.lodgerNum = lodgerNum;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public OrderInfoPO votopo(){
		return new OrderInfoPO(null, this.orderId, this.customerName, this.lodgerName,this.lodgerTel,
				this.hotelName,null, this.hotelTel, this.roomType, null, this.roomNum,
				this. orderTime, this.lodgerNum, this.children, this.hasRemarked, this.expectCheckInTime,
				this.expectCheckOutTime, this.latestCheckInTime, this. actualCheckInTime, this.actualCheckOutTime,
				this. price, this.orderState,this.orderTime);
		
	}
}
