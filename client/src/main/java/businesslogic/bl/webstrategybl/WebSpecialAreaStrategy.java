package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;
import java.util.Map;

import dao.webstrategydao.WebStrategyDao;
import exception.NotIntException;
import init.RMIHelper;
import po.WebStrPO;
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
//    	webStrategyDao=new WebStrategyDao_Stub();
    	RMIHelper.init();
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
	public double getDiscount(String info)  {
		getWebStrategy();
		if(info==null){
			return 1;//即没有折扣
		}
//		String regex= "[0-9]+";//正则表达式匹配1个以上的数字
//		if(!info.matches(regex)){
//			throw new NotIntException("传入的商圈信息不是数值类型");
//		}
		
		int tradingArea=TransHelper.stringToArea(info);//如果不是int型怎么办，此处考虑exception
		return strategy.get(tradingArea);
	}

	


}
