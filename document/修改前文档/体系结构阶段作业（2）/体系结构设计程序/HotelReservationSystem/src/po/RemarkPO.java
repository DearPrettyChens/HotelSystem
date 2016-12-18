package po;

import java.io.Serializable;
/**
 * 酒店评论
 * @author CYF
 * @version 1.0
 */
public class RemarkPO implements Serializable{
	//酒店id
	private String hotelID;
	//用户id
	private String customerID;
	//给酒店的打分
	private double score;
	//酒店的评论
	private String remark;
	//空方法
	public RemarkPO(){
		
	}
	// 酒店评价
	public RemarkPO(String hotelID,String customerID,double score,String remark){
		this.setHotelID(hotelID);
		this.setCustomerID(customerID);
		this.setScore(score);
		this.setRemark(remark);	
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
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

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

}
