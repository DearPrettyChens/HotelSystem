package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.sun.javafx.beans.IDProperty;

/**
 * 酒店评论
 * 
 * @author CYF
 * @version 1.0
 */
@Entity
@Table(name = "t_order2")
public class RemarkPO implements Serializable {
	// 酒店id
	@Column(name = "hotel_id")
	private String hotelID;
	// 用户id
	@Column(name = "customer_id")
	private String customerID;
	// 订单号
	@Id
	@Column(name = "order_id")
	private String orderID;
	// 给酒店的打分
	@Column(name = "score")
	private double score;
	// 酒店的评论
	@Column(name = "remark")
	private String remark;
	@Version
	@Column(name = "version")
	private int version;
	// 空方法
	public RemarkPO() {

	}

	// 酒店评价
	public RemarkPO(String hotelID, String orderId, String customerID, double score, String remark) {
		this.setHotelID(hotelID);
		this.setCustomerID(customerID);
		this.setScore(score);
		this.setRemark(remark);
		this.orderID = orderId;
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

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

}
