package businesslogic.bl.webstrategybl;

import java.util.Map;

import dao.webstrategydao.WebStrategyDao;
import util.ResultMessage;
import util.TradingArea;
import vo.webstrategyvo.WebStrVO;
/**
 * 酒店特定商圈策略类
 * @author CYF
 * @version 1.0
 */
public class WebSpecialAreaStrategy implements WebStrategyInterface {
    //酒店特定商圈策略映射
	private Map<TradingArea,Double> strategy; 
	private WebStrategyDao webStrategyDao;
    public WebSpecialAreaStrategy(){
    
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

	public Map<TradingArea, Double> getStrategy() {
		return strategy;
	}



}
