package vo.webstrategyvo;

import util.WebStrategyType;

/** 
 * 网站最优策略,（不涉及和PO的直接交互）
 * @author CYF
 * @version 1.0
 */
public class WebBestStrVO {
	//最优策略类型
	private WebStrategyType webStrategyType;
	//折扣值
	private double discount;
	
	public WebBestStrVO(){
	}
	public WebBestStrVO(WebStrategyType webStrategyType,double discount){
		this.setWebStrategyType(webStrategyType);
		this.setDiscount(discount);
	}
	public WebStrategyType getWebStrategyType() {
		return webStrategyType;
	}
	public void setWebStrategyType(WebStrategyType webStrategyType) {
		this.webStrategyType = webStrategyType;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
