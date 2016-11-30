package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import dao.webstrategydao.WebStrategyDao;
import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
import util.TradingArea;
import util.TransHelper;
import util.WebStrategyType;

/**
 * 
 * 模拟WebStrategyDao的实现
 * @author CSY
 *
 */
public class WebStrategyDao_Stub implements WebStrategyDao {

	@Override
	public GradeRulePO getGradeRule() throws RemoteException {
		// TODO Auto-generated method stub
		return new GradeRulePO(100);
	}

	@Override
	public WebStrPO getWebStrategy(WebStrategyType type) throws RemoteException {
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		Map<Integer, Double> area=new HashMap<Integer, Double>();
		area.put(TradingArea.XINJIEKOU.ordinal(), 0.5);
		Map<Integer, Double> vip=new HashMap<Integer, Double>();
		area.put(1, 0.5);
		switch (type) {
		case SPECIALTIME:
			return new WebStrPO(date, 0.5);
		case SPECIALAREA:
			return new WebStrPO(area , 0, WebStrategyType.SPECIALAREA);
		case VIP:
			return new WebStrPO(vip, 0, type);
		}
		return null;
		
		
	}

	@Override
	public ResultMessage setGradeRule(GradeRulePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setWebStrategy(WebStrPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
