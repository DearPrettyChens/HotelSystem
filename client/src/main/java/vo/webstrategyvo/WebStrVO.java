package vo.webstrategyvo;

import java.util.Date;
import java.util.Map;

import po.WebStrPO;
import util.WebStrategyType;

/**
 * 网站所有的营销策略
 * 
 * @author CYF 
 * @version
 */
public class WebStrVO {

	//商圈折扣映射????????
	//private Map<TradingArea, Double> tradingAreaStrategy;
	//vip折扣映射
	private Map<Integer,Double> specialTimeOrTradingAreaStrategy;
	//日期
	private Date[] date;
	//时期折扣值
	private double discount;
	private WebStrategyType type;

	public WebStrVO() {
	}

	 /**
     * po to vo
     * @param webStrPO
     */
	public WebStrVO(WebStrPO webStrPO) {
		this.setDate(webStrPO.getDate());
		this.setDiscount(webStrPO.getDiscount());
		this.setSpecialTimeOrTradingAreaStrategy(webStrPO.getSpecialTimeOrTradingAreaStrategy());
		this.setType(webStrPO.getType());
		
	}
	
	/**
	 * vo to po
	 * @return WebStrPO
	 */
	public WebStrPO toPO() {
		return new WebStrPO( specialTimeOrTradingAreaStrategy, date, discount, type);
	}
	public WebStrVO(Map<Integer,Double> specialTimeOrTradingAreaStrategy,double discount,WebStrategyType type) {
		this.setSpecialTimeOrTradingAreaStrategy(specialTimeOrTradingAreaStrategy);
		this.setDiscount(discount);
		this.setType(type);
	}
	public WebStrVO(Date[] date,double discount) {
        this.setDate(date);
		this.setDiscount(discount);
		this.setType(WebStrategyType.SPECIALTIME);
	}

	public Date[] getDate() {
		return date;
	}

	public void setDate(Date[] date) {
		this.date = date;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public WebStrategyType getType() {
		return type;
	}
	public void setType(WebStrategyType type) {
		this.type = type;
	}

	public Map<Integer, Double> getSpecialTimeOrTradingAreaStrategy() {
		return specialTimeOrTradingAreaStrategy;
	}

	public void setSpecialTimeOrTradingAreaStrategy(Map<Integer, Double> specialTimeOrTradingAreaStrategy) {
		this.specialTimeOrTradingAreaStrategy = specialTimeOrTradingAreaStrategy;
	}

	

}
