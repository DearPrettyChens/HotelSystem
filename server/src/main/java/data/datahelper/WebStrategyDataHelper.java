package data.datahelper;

import java.rmi.RemoteException;

import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
import util.WebStrategyType;

public interface WebStrategyDataHelper {
	public GradeRulePO getGradeRule() throws RemoteException;

	public WebStrPO getWebStrategy(WebStrategyType type) throws RemoteException;

	public ResultMessage setGradeRule(GradeRulePO po) throws RemoteException;

	public ResultMessage setWebStrategy(WebStrPO po) throws RemoteException;

}
