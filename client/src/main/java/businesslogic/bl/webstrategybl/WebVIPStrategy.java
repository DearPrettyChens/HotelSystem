package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

import dao.webstrategydao.WebStrategyDao;
import init.RMIHelper;
import po.WebStrPO;
import util.WebStrategyType;
import vo.webstrategyvo.WebStrVO;

/**
 * 网站vip折扣策略
 * 
 * @author CYF
 * @version 1.0
 */
public class WebVIPStrategy implements WebStrategyInterface {
	// 网站vip折扣策略映射
	private Map<Integer, Double> strategy;
	private WebStrategyDao webStrategyDao;
	private WebStrPO webStrPO;
	private static WebStrategyInterface webVIPStrategy;

	private WebVIPStrategy() {
		webStrategyDao = RMIHelper.getWebStrategyDao();
	}

	public static WebStrategyInterface getInstance() {
		if (webVIPStrategy == null) {
			webVIPStrategy = new WebVIPStrategy();
		}
		return webVIPStrategy;
	}

	@Override
	public WebStrVO getWebStrategy() {
		try {
			webStrPO = webStrategyDao.getWebStrategy(WebStrategyType.VIP);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		strategy=webStrPO.getVIPOrTradingAreaStrategy();
		return new WebStrVO(webStrPO);
	}


	@Override
	public double getDiscount(String info) {
		getWebStrategy();
		double discount=1;//即没有折扣
		int credit=0;
		if(info!=null){
			credit=Integer.parseInt(info);//如果不是int型怎么办，此处考虑exception
		}
		
		//获得用户等级
		WebGradeRule webGradeRule=WebGradeRule.getInstance();
		int grade=webGradeRule.getGrade(credit);
		
		
		//对不同等级进行倒序遍历
		ListIterator<Map.Entry<Integer, Double>> iterator=new ArrayList<Map.Entry<Integer, Double>>(strategy.entrySet()).listIterator(strategy.size()); 
		int pre=0;//等级的下界
		
		while(iterator.hasPrevious()){
			Map.Entry<Integer, Double> entry=iterator.next();
			pre=entry.getKey();
			
			//判断是否在对应的等级范围内,从最大的比较到最小的
			if(grade>=pre){
				discount=strategy.get(pre);
				return discount;
			}
		}
		
		return discount;
	}

}
