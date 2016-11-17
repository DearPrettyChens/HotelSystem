package po;

import java.io.Serializable;
/**
 * 酒店评论
 * @author CYF
 * @version 1.0
 */
public class RemarkPO implements Serializable{
	//酒店id
	private int hotelID;
	//用户id
	private int customerID;
	//订单号
	private String orderID;
	//给酒店的打分
	private double score;
	//酒店的评论
	private String remark;
	//空方法
	public RemarkPO(){
		
	}
	// 酒店评价
	public RemarkPO(int hotelID,String orderId,int customerID,double score,String remark){
		this.setHotelID(hotelID);
		this.setCustomerID(customerID);
		this.setScore(score);
		this.setRemark(remark);	
		this.orderID=orderId;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

}
