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
//	 private Map<TradingArea, Double> tradingAreaStrategy;
	// vip折扣映射
	private Map<Integer, Double> specialTimeOrTradingAreaStrategy;
	// 日期
	private long[] dateStamps;
	// 时期折扣值
	private double discount;
	private WebStrategyType type;

	public WebStrPO() {
	}

	public WebStrPO( Map<Integer, Double> specialTimeOrTradingAreaStrategy,
			Date[] date, double discount, WebStrategyType type) {
		super();

		this.setSpecialTimeOrTradingAreaStrategy(specialTimeOrTradingAreaStrategy);
		this.setDate(date);;
		this.setDiscount(discount);
		this.setType(type);
	}

	public WebStrPO(Map<Integer, Double> specialTimeOrTradingAreaStrategy, double discount, WebStrategyType type) {
		this.setSpecialTimeOrTradingAreaStrategy(specialTimeOrTradingAreaStrategy);
		this.setDiscount(discount);
		this.setType(type);
	}

	public WebStrPO(Date[] date, double discount) {
		this.setDate(date);
		this.setDiscount(discount);
		this.setType(WebStrategyType.SPECIALTIME);
	}

	public Date[] getDate() {
		Date[] dates = new Date[dateStamps.length];
		for(int i=0;i<dates.length;i++){
			dates[i]=new Date(dateStamps[i]);
		}
		return dates;
	}

	public void setDate(Date[] date) {
		dateStamps=new long[date.length];
		for(int i=0;i<dateStamps.length;i++){
			dateStamps[i]=date[i].getTime();
		}
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
