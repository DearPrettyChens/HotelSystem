package vo.ordervo;

import javax.swing.ImageIcon;

/**
 * 订单列表信息的vo类
 * @author CLL
 * @version1.0
 */
public class OrderVO {
    //订单号
	private String orderID;
	//订单状态
	private String orderState;
	//顾客用户名
	private String customerName;
	//酒店名称
	private String hotelName;
	//酒店图片
	private ImageIcon hotelIcon;
	
	public OrderVO(){
		
	}
	
	public OrderVO(String orderID,String orderState,String customerName,String hotelName,ImageIcon hotelIcon){
		this.orderID=orderID;
		this.orderState=orderState;
		this.customerName=customerName;
		this.hotelName=hotelName;
		this.hotelIcon=hotelIcon;
	}



	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public ImageIcon getHotelIcon() {
		return hotelIcon;
	}

	public void setHotelIcon(ImageIcon hotelIcon) {
		this.hotelIcon = hotelIcon;
	}
}
