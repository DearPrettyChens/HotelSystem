package vo.webstrategyvo;

import java.util.Date;

import util.TradingArea;

/**
 * 
 * 界面或订单提供的用户信息，来获取相应的最佳网站策略
 * @author CSY
 *
 */
public class WebProvidedVO {
	private String credit;//信用值
	private TradingArea area;//商圈
	private Date time;//时期
	
	
	public WebProvidedVO(String credit, TradingArea area, Date time) {
		super();
		this.credit = credit;
		this.area = area;
		this.time = time;
		
		
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String  credit) {
		this.credit = credit;
	}
	public TradingArea getArea() {
		return area;
	}
	public void setArea(TradingArea area) {
		this.area = area;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
