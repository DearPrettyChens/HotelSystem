package vo.personnelvo;

import javax.swing.ImageIcon;

/**
 * 顾客列表信息的vo类，职责为实现逻辑层和界面层之间顾客列表信息的交互
 * @author CLL
 * @version 1.0
 */
public class CustomerListVO {
	//用户名名称（暂定为真实姓名）
	private String customerName;
	//顾客编号
	private String customerId;
	//头像
	private ImageIcon customerImage;
	//联系方式11位
	private String telephone;
	
	public CustomerListVO(){
		
	}
	
	public CustomerListVO(String customerName,String customerId,ImageIcon customerImage,String telephone){
		this.customerName=customerName;
		this.customerId=customerId;
		this.customerImage=customerImage;
		this.telephone=telephone;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public ImageIcon getCustomerImage() {
		return customerImage;
	}
	
	public void setCustomerImage(ImageIcon customerImage) {
		this.customerImage = customerImage;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
