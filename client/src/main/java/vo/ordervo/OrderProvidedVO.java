package vo.ordervo;

/**
 * 订单提供给酒店策略来获得最佳策略的vo类
 * 
 * @author Csy 
 * @version 1.0
 */
public class OrderProvidedVO {
    private String customerID;//顾客编号
    private int amount;//预定房间数量
    private String enterpriceName;//企业名称
	
    public String getCustomerID() {
		return customerID;
	}
	public OrderProvidedVO(String customerID, int amount, String enterpriceName) {
		
		this.customerID = customerID;
		this.amount = amount;
		this.enterpriceName = enterpriceName;
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
}
