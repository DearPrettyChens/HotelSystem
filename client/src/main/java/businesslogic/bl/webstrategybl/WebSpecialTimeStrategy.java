package businesslogic.bl.webstrategybl;

import java.util.Date;

import dao.webstrategydao.WebStrategyDao;
import util.ResultMessage;
import vo.webstrategyvo.WebStrVO;
/**
 * 网站特定时期策略
 * @author CYF
 * @version 1.0
 */
public class WebSpecialTimeStrategy implements WebStrategyInterface{
	//网站特定时期策略映射 两个元素记录开始时间和结束时间
    private Date[] date;
    //折扣值
    private double discount;
    private WebStrategyDao webStrategyDao;
	public WebSpecialTimeStrategy(){
	
	}
	public Date[] getDate() {
		return date;
	}


	@Override
	public WebStrVO getWebStrategy() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ResultMessage setWebStrategy(WebStrVO vo) {
		// TODO Auto-generated method stub
		return null;
	}


	public double getDiscount() {
		return discount;
	}
	
}
