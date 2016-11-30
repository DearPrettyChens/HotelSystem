package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;
import java.sql.Date;

import dao.webstrategydao.WebStrategyDao;
import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
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
		// TODO Auto-generated method stub
		return new WebStrPO(date, 0.5);
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
