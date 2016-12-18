package vo.ordervo;
/**
 * 订单评价信息的vo类
 * @author CLL
 * @version 1.0
 */
public class RemarkVO {
	//订单编号
	private String orderId;
	//酒店编号
	private String hotelId;
	//评分
	private double remarkGrade;
	//评价
	private String remarkInfo;
	
	public RemarkVO(){
		
	}
	
	public RemarkVO(String orderId,String hotelId,double remarkGrade,String remarkInfo){
		this.setHotelId(hotelId);
		this.setOrderId(orderId);
		this.setRemarkGrade(remarkGrade);
		this.setRemarkInfo(remarkInfo);
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public double getRemarkGrade() {
		return remarkGrade;
	}

	public void setRemarkGrade(double remarkGrade) {
		this.remarkGrade = remarkGrade;
	}

	public String getRemarkInfo() {
		return remarkInfo;
	}

	public void setRemarkInfo(String remarkInfo) {
		this.remarkInfo = remarkInfo;
	}
}
