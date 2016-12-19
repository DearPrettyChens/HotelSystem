package vo.hotelvo;

import java.util.Date;

import common.Children;
import common.OrderState;
/**
 * 酒店看到的订单详细信息vo
 * @author CYF
 * @version 1.0
 */
public class HotelOrderInfoVO {
	    //订单编号
		private String orderId;
		//顾客用户名
		private String customerName;
		//订单价格
		private double price;
		//入住人姓名
		private String lodgerName;
		//入住人联系方式11位
		private String lodgerTel;
		//预计入住时间
		private Date expectedCheckInTime;
		//预计退房时间
		private Date expectedCheckOutTime;
		//实际入住时间
		private Date actualCheckInTime;
		//实际退房时间
		private Date actualCheckOutTime;
		//订单状态
		private OrderState orderState;
		//房间类型
		private String roomType;
		//房间数量
		private int roomNumber;
		//入住人数
		private int numOfPeople;
		//有无儿童
		private Children hasChild;
		//生成订单时间
		private Date orderTime;
		//最晚入住时间
		private Date lateCheckInTime;
		
		//空方法
		public HotelOrderInfoVO(){
			
		}
		//酒店看到的本酒店的订单信息
		public HotelOrderInfoVO(String orderId,String customerName,double price,
				String lodgerName,String lodgerTel,Date expectedCheckInTime,Date expectedCheckOutTime,
				String roomType,int roomNumber,int numberOfPeople,Children hasChild,Date actualCheckInTime,
				Date actualCheckOutTime,Date orderTime,OrderState orderState,String hotelName,
				String hotelTel,Date lateCheckInTime){
			this.setOrderId(orderId);
			this.setCustomerName(customerName);
			this.setPrice(price);
			this.setLodgerName(lodgerName);
			this.setLodgerTel(lodgerTel);
			this.setExpectedCheckInTime(expectedCheckInTime);
			this.setExpectedCheckOutTime(expectedCheckOutTime);
			this.setRoomType(roomType);
			this.setRoomNumber(roomNumber);
			this.setNumOfPeople(numberOfPeople);
			this.setHasChild(hasChild);
			this.setActualCheckInTime(actualCheckInTime);
			this.setActualCheckOutTime(actualCheckOutTime);
			this.setOrderTime(orderTime);
			this.setOrderState(orderState);
			this.setLateCheckInTime(lateCheckInTime);
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

		public Date getExpectedCheckInTime() {
			return expectedCheckInTime;
		}

		public void setExpectedCheckInTime(Date expectedCheckInTime) {
			this.expectedCheckInTime = expectedCheckInTime;
		}

		public Date getExpectedCheckOutTime() {
			return expectedCheckOutTime;
		}

		public void setExpectedCheckOutTime(Date expectedCheckOutTime) {
			this.expectedCheckOutTime = expectedCheckOutTime;
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

		public String getRoomType() {
			return roomType;
		}

		public void setRoomType(String roomType) {
			this.roomType = roomType;
		}

		public int getRoomNumber() {
			return roomNumber;
		}

		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}

		public int getNumOfPeople() {
			return numOfPeople;
		}

		public void setNumOfPeople(int numOfPeople) {
			this.numOfPeople = numOfPeople;
		}

		public Date getOrderTime() {
			return orderTime;
		}

		public void setOrderTime(Date orderTime) {
			this.orderTime = orderTime;
		}

		public Date getLateCheckInTime() {
			return lateCheckInTime;
		}

		public void setLateCheckInTime(Date lateCheckInTime) {
			this.lateCheckInTime = lateCheckInTime;
		}

		public Children getHasChild() {
			return hasChild;
		}

		public void setHasChild(Children hasChild) {
			this.hasChild = hasChild;
		}

	
		
}
