package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;
import java.util.Date;

import dao.webstrategydao.WebStrategyDao;
import init.RMIHelper;
import po.WebStrPO;
import util.ResultMessage;
import util.TransHelper;
import util.WebStrategyType;
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
    private  WebStrPO webStrPO;
    private static WebStrategyInterface webSpecialAreaStrategy;
	private WebSpecialTimeStrategy(){
		webStrategyDao=RMIHelper.getWebStrategyDao();
	
	}
	public static WebStrategyInterface getInstance() {
		if (webSpecialAreaStrategy==null){
			webSpecialAreaStrategy=new WebSpecialTimeStrategy();
		}
		return webSpecialAreaStrategy;
	}

	@Override
	public WebStrVO getWebStrategy() {
		try {
			webStrPO = webStrategyDao.getWebStrategy(WebStrategyType.SPECIALTIME);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		date=webStrPO.getDate();
		discount=webStrPO.getDiscount();
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
		date=vo.getDate();
		discount=vo.getDiscount();
		return ResultMessage.FAIL;
	}
	@Override
	public double getDiscout(String info) {
		getWebStrategy();
		long dateInfo=TransHelper.stringToDate(info);		
		long startTime=date[0].getTime();
		long endTime=date[1].getTime();
         
		//如果在特惠时间内，就返回折扣值
		if((dateInfo>=startTime)&&(dateInfo<=endTime)){
			return discount;
		}
		return 0;
	}



}
