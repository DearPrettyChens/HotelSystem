package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;

import dao.webstrategydao.WebStrategyDao;
import exception.NotIntException;
import init.RMIHelper;
import po.WebStrPO;
import util.ResultMessage;
import util.WebStrategyType;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebProvidedVO;
import vo.webstrategyvo.WebStrVO;
/**
 * 网站策略类
 * @author CYF
 * @version 1.0
 */
public class WebStrategy {
	private WebStrategyMap webStrategyMap;
	private WebStrategyInterface webStrategyInterface;
	private static WebStrategy webStrategy;
	private WebStrategyDao webStrategyDao;
	private  WebStrategy() {
		webStrategyDao=new WebStrategyDao_Stub();
//		RMIHelper.init();
//		webStrategyDao=RMIHelper.getWebStrategyDao();
		webStrategyMap=WebStrategyMap.getInstance();
	}
	
	public static WebStrategy getInstance() {
		if(webStrategy==null){
			webStrategy=new WebStrategy();
		}
		return webStrategy;
	}
	
	/**
     * 获取网站最佳策略
     * @param webProvidedVO
     * @return WebBestStrVO
     */
	public WebBestStrVO getWebBestStrategy(WebProvidedVO webProvidedVO) {
		//用providedInfoMap来组织传过来用于获得最佳策略的信息
		ProvidedInfoMap providedInfoMap=new ProvidedInfoMap(webProvidedVO);
		double discount=1;//折扣值在0-1之间
		WebStrategyType webStrategyType=WebStrategyType.VIP;//暂时初始化为VIP，因为这个折扣肯定是有的
		
		//遍历各个策略的信息
		while (providedInfoMap.hasNext()) {
			
			//获得策略种类和提供的相关折扣信息
			providedInfoMap.next();
			WebStrategyType type=providedInfoMap.getWebStrategyType();
			String info=providedInfoMap.getInfo();
			
			//委托给每个策略去计算折扣值
			webStrategyInterface=webStrategyMap.get(type);
			double tempDiscount=0;
			try {
				tempDiscount = webStrategyInterface.getDiscount(info);
			} catch (NotIntException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//选取折扣最大的，即折扣值最小的。
			if(tempDiscount<discount){
				discount=tempDiscount;
				webStrategyType=type;
			}
		}
		return new WebBestStrVO(webStrategyType, discount);
	}

    /**
     * 获取网站策略 委托给接口
     * @param type
     * @return WebStrVO
     */
	public WebStrVO getWebStrategy(WebStrategyType type) {
		webStrategyInterface=webStrategyMap.get(type);
		return webStrategyInterface.getWebStrategy();
	}

    /**
     * 修改网站策略 
     * @param webStrVO
     * @return ResultMessage
     */
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO) {
		WebStrPO webStrPO=webStrVO.toPO();
		try {
			return webStrategyDao.setWebStrategy(webStrPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}

}
