package po;

import java.io.Serializable;
import java.util.Date;
/**
 * 入住与退房时间po
 * @author CYF
 * @version 1.0
 */
public class CheckTimePO implements Serializable{
	//订单编号
	private String orderNumber;
	//入住或退房时间，因为调用方法不同，可以只用一个time表示
	private Date checkTime;
	//表示是checkin还是out("checkin" or "checkout")
	private String type;
	//空方法
	public CheckTimePO(){
		
	}
	//入住时间与退房时间
	public CheckTimePO(String orderNumber,Date checkTime,String type){
		this.setOrderNumber(orderNumber);
		this.setCheckTime(checkTime);
		this.type=type;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
