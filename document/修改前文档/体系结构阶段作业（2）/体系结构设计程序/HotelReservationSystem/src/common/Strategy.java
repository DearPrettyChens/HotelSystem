package common;
/**
 * 所有策略的父类
 * @author CLL
 *
 */
public class Strategy {
	private double discount;
	
	public Strategy(){
		
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
