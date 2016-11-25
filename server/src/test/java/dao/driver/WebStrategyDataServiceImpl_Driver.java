package dao.driver;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import dao.impl.WebStrategyDaoImpl;
import dao.webstrategydao.WebStrategyDao;
import javafx.util.converter.DateStringConverter;
import po.GradeRulePO;
import po.WebStrPO;
import util.TradingArea;
import util.WebStrategyType;

public class WebStrategyDataServiceImpl_Driver {
	public void drive(WebStrategyDao dao) throws RemoteException {
		GradeRulePO po = new GradeRulePO(5);
		System.out.println(dao.setGradeRule(po));

		System.out.println(dao.getGradeRule().getCredit());

		Date[] date = new Date[2];
		date[0] = new Date();
		date[1] = new Date();
		WebStrPO strPO = new WebStrPO(date, 0.5);
		System.out.println(dao.setWebStrategy(strPO));

		Map<Integer, Double> map = new HashMap<Integer, Double>();
		map.put(TradingArea.HUNANLU.ordinal(), 0.8);
		map.put(TradingArea.XINJIEKOU.ordinal(), 0.5);
		strPO = new WebStrPO(map, -1, WebStrategyType.SPECIALAREA);
		System.out.println(dao.setWebStrategy(strPO));
		strPO.setType(WebStrategyType.VIP);
		System.out.println(dao.setWebStrategy(strPO));

		strPO = dao.getWebStrategy(WebStrategyType.SPECIALAREA);
		System.out.println(strPO.getVIPOrTradingAreaStrategy().get(0)+" "+strPO.getVIPOrTradingAreaStrategy().size());
		strPO = dao.getWebStrategy(WebStrategyType.VIP);
		System.out.println(strPO.getVIPOrTradingAreaStrategy().get(0)+" "+strPO.getVIPOrTradingAreaStrategy().size());
		strPO = dao.getWebStrategy(WebStrategyType.SPECIALTIME);
		System.out.println(strPO.getDate().length+" "+strPO.getDiscount());

	}

	public static void main(String[] args) throws RemoteException {
		new WebStrategyDataServiceImpl_Driver().drive(WebStrategyDaoImpl.getInstance());
	}
}
