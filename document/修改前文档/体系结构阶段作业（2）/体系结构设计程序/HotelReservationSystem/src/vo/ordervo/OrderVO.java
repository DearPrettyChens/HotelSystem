package vo.ordervo;
/**
 * 订单列表信息的vo类
 * @author CLL
 * @version1.0
 */
public class OrderVO {

	//订单状态
	private String orderState;
	//顾客用户名
	private String customerName;
	//酒店名称
	private String hotelName;
	
	public OrderVO(){
		
	}
	
	public OrderVO(String orderState,String customerName,String hotelName){
		this.orderState=orderState;
		this.customerName=customerName;
		this.hotelName=hotelName;
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
}
