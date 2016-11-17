package vo.ordervo;

import java.util.Date;

import javax.swing.ImageIcon;

import po.OrderListPO;
import util.OrderState;

/**
 * 订单列表信息的vo类
 * @author CLL
 * @version1.0
 */
public class OrderListVO {
	//订单编号
	private String orderNumber;
	//酒店ID
	private String hotelID;
	//酒店名称
	private String hotelName;
	//顾客ID
	private String customerID;
	//顾客用户名
	private String customerName;
	//顾客预定时间
	private Date reserveTime;
	//订单状态
	private OrderState state;
	//酒店图片
	private ImageIcon hotelIcon;
	//空方法
	public OrderListVO(){
		
	}
	//显示给顾客看的订单列表信息
	public OrderListVO(String orderNumber,String hotelID,String hotelName,String customerName,Date reserveTime,OrderState state,ImageIcon hotelIcon){
		this.setOrderNumber(orderNumber);
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
		this.setHotelIcon(hotelIcon);
	}
	/**
	 * po to 所有列表信息的vo
	 * @param po
	 */
	public OrderListVO(OrderListPO po){
		this.orderNumber=po.getOrderNumber();
		this.hotelID=po.getHotelID();
		this.hotelName=po.getHotelName();
		this.customerName=po.getCustomerName();
		this.customerID=po.getCustomerID();
		this.reserveTime=po.getReserveTime();
		this.state=po.getState();
		//this.hotelIcon=po.getHotelIcon();
	}
	//显示给酒店看的订单列表信息，需求规格上没有写
	public OrderListVO(String orderNumber,String customerID,String customerName, Date reserveTime,OrderState state){
		this.setOrderNumber(orderNumber);
		this.setCustomerID(customerID);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
	}
	//网站营销人员看到的订单列表信息，需求规格上没有写
	public OrderListVO(String orderNumber,String hotelID,String hotelName,String customerID,String customerName,Date reserveTime,OrderState state){
		this.setOrderNumber(orderNumber);
		this.setHotelID(hotelID);
		this.setHotelName(hotelName);
		this.setCustomerID(customerID);
		this.setCustomerName(customerName);
		this.setReserveTime(reserveTime);
		this.setState(state);
	}
	/**
	 * vo to po
	 * @return OrderListPO
	 */
	public OrderListPO toPO(){
		return new OrderListPO(this.orderNumber,this.hotelID,this.hotelName,this.customerName,this.reserveTime,this.state,this.hotelIcon);
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Date getReserveTime() {
		return reserveTime;
	}
	public void setReserveTime(Date reserveTime) {
		this.reserveTime = reserveTime;
	}
	public OrderState getState() {
		return state;
	}
	public void setState(OrderState state) {
		this.state = state;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ImageIcon getHotelIcon() {
		return hotelIcon;
	}
	public void setHotelIcon(ImageIcon hotelIcon) {
		this.hotelIcon = hotelIcon;
	}
	/**
	 * 编号string转化成int
	 */
	private static int idToInt(String id){
		String temp="";
		for(int i=0;i<id.length();i++){
			if(id.charAt(i)!='0'){
				temp=temp+id.charAt(i);
			}
		}
		return Integer.parseInt(temp);
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
}
