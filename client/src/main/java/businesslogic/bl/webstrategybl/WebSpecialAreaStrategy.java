package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;
import java.util.Map;

import dao.webstrategydao.WebStrategyDao;
import init.RMIHelper;
import po.WebStrPO;
import util.ResultMessage;
import util.TransHelper;
import util.WebStrategyType;
import vo.webstrategyvo.WebStrVO;
/**
 * 酒店特定商圈策略类
 * @author CYF
 * @version 1.0
 */
public class WebSpecialAreaStrategy implements WebStrategyInterface {
    //酒店特定商圈策略映射
	private Map<Integer,Double> strategy; 
	private WebStrategyDao webStrategyDao;
	private WebStrPO webStrPO;
	private static WebStrategyInterface webSpecialAreaStrategy;
	
    private  WebSpecialAreaStrategy(){
         webStrategyDao=RMIHelper.getWebStrategyDao();
    }
    
    public static WebStrategyInterface getInstance() {
		if (webSpecialAreaStrategy==null){
			webSpecialAreaStrategy=new WebSpecialAreaStrategy();
		}
		return webSpecialAreaStrategy;
	}

	@Override
	public WebStrVO getWebStrategy() {
		try {
			webStrPO = webStrategyDao.getWebStrategy(WebStrategyType.SPECIALAREA);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		strategy=webStrPO.getVIPOrTradingAreaStrategy();
		return new WebStrVO(webStrPO);
	}

	@Override
	public ResultMessage setWebStrategy(WebStrVO vo) {	
		webStrPO=vo.toPO();
		try {
			return webStrategyDao.setWebStrategy(webStrPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		strategy=vo.getVIPOrTradingAreaStrategy();
		return ResultMessage.FAIL;
	}

	@Override
	public double getDiscout(String info) {
		getWebStrategy();
		int tradingArea=TransHelper.stringToArea(info);//如果不是int型怎么办，此处考虑exception
		return strategy.get(tradingArea);
	}

	


}
