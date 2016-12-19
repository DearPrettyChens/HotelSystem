package common;

import java.util.Date;
import java.util.Map;
/**
 * 网站特定日期策略
 * @author CLL
 *
 */
public class WebSpecialTimeStrategy extends Strategy{
	private Map<Date,Double> allDiscount;
	private WebStrategyType type=WebStrategyType.SPECIALTIME;
	/**
	 * 初始化该特定日期的折扣值
	 * @param specialTime
	 * @param discount
	 */
	public WebSpecialTimeStrategy(Date specialTime,double discount){
		allDiscount.put(specialTime, discount);
	}
	/**
	 * 获取该日期的折扣值
	 * @param specialTime
	 * @return double
	 */
	public double getDiscount(Date specialTime) {
		return allDiscount.get(specialTime);
	}
	/**
	 * 重新设置该日期的折扣值
	 * @param specialTime
	 * @param discount
	 */
	public void setDiscount(Date specialTime,double discount) {
		allDiscount.remove(specialTime);
		allDiscount.put(specialTime, discount);
	}
	/**
	 * 返回所有特定日期及其折扣值
	 * @return Map<Date,Double>
	 */
	public Map<Date,Double> getAllDiscount(){
		return allDiscount;
	}
	
	public WebStrategyType getType() {
		return type;
	}


}
