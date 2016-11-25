package po;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import util.WebStrategyType;

/**
 * 传递所有的网站营销策略
 * 
 * @author CLL
 * @version 1.0
 */
public class WebStrPO implements Serializable {
	// 商圈折扣映射
	// private Map<TradingArea, Double> tradingAreaStrategy;
	// vip折扣映射
	private Map<Integer, Double> VIPOrTradingAreaStrategy;
	// 日期
	private Date[] dateStamps;
	// 时期折扣值
	private double discount;
	private WebStrategyType type;

	public WebStrPO() {
	}

	public WebStrPO(Map<Integer, Double> VIPOrTradingAreaStrategy, Date[] date, double discount, WebStrategyType type) {
		super();

		this.setVIPOrTradingAreaStrategy(VIPOrTradingAreaStrategy);
		this.setDate(date);
		;
		this.setDiscount(discount);
		this.setType(type);
	}

	public WebStrPO(Map<Integer, Double> VIPOrTradingAreaStrategy, double discount, WebStrategyType type) {
		this.setVIPOrTradingAreaStrategy(VIPOrTradingAreaStrategy);
		this.setDiscount(discount);
		this.setType(type);
	}

	public WebStrPO(Date[] date, double discount) {
		this.setDate(date);
		this.setDiscount(discount);
		this.setType(WebStrategyType.SPECIALTIME);
	}

	public Date[] getDate() {
		if (dateStamps == null)
			return null;
		return dateStamps;
	}

	public void setDate(Date[] date) {
		dateStamps = date;
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

	public Map<Integer, Double> getVIPOrTradingAreaStrategy() {
		return VIPOrTradingAreaStrategy;
	}

	public void setVIPOrTradingAreaStrategy(Map<Integer, Double> VIPOrTradingAreaStrategy) {
		this.VIPOrTradingAreaStrategy = VIPOrTradingAreaStrategy;
	}

}
