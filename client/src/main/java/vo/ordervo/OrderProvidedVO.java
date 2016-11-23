package vo.ordervo;

import java.util.Date;

/**
 * 订单提供给酒店策略来获得最佳策略的vo类
 * 
 * @author Csy 
 * @version 1.0
 */
public class OrderProvidedVO {
    private String customerID;//顾客编号(通过编号去取生日)
    private int amount;//预定房间数量
    private String enterpriceName;//企业名称
    private Date time;//下订单时的时间
    private String hotelID;//所选酒店编号
	
    public String getCustomerID() {
		return customerID;
	}



	public OrderProvidedVO(String customerID, int amount, String enterpriceName, Date time, String hotelID) {
		super();
		this.customerID = customerID;
		this.amount = amount;
		this.enterpriceName = enterpriceName;
		this.time = time;
		this.hotelID = hotelID;
	}



	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getEnterpriceName() {
		return enterpriceName;
	}
	public void setEnterpriceName(String enterpriceName) {
		this.enterpriceName = enterpriceName;
	}
	public String getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
