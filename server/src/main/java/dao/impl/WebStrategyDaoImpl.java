package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.webstrategydao.WebStrategyDao;
import data.datahelper.WebStrategyDataHelper;
import datahelper.datafactory.DataFactory;
import datahelper.datafactory.impl.DataFactoryImpl;
import po.GradeRulePO;
import po.WebStrPO;
import rmi.RMIconfig;
import security.RMISSLClientSocketFactory;
import security.RMISSLServerSocketFactory;
import util.ResultMessage;
import util.WebStrategyType;

/**
 * WebStrategyDao的实现
 * 
 * @author csy
 *
 */
public class WebStrategyDaoImpl extends UnicastRemoteObject implements WebStrategyDao {

	private static final long serialVersionUID = 3741314626971097134L;
	private static WebStrategyDao webStrategyDao;
	private DataFactory dataFactory;
	private WebStrategyDataHelper webStrategyDataHelper;
	static {
		try {
			webStrategyDao = new WebStrategyDaoImpl();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static WebStrategyDao getInstance() throws RemoteException {

		return webStrategyDao;
	}

	private WebStrategyDaoImpl() throws RemoteException, Exception {
		super(RMIconfig.getPort(), new RMISSLClientSocketFactory(), new RMISSLServerSocketFactory());
		dataFactory = new DataFactoryImpl();
		webStrategyDataHelper = dataFactory.getWebStrategyDataHelper();
	}

	@Override
	public GradeRulePO getGradeRule() throws RemoteException {
		return webStrategyDataHelper.getGradeRule();
	}

	@Override
	public WebStrPO getWebStrategy(WebStrategyType type) throws RemoteException {
		return webStrategyDataHelper.getWebStrategy(type);
	}

	@Override
	public ResultMessage setGradeRule(GradeRulePO po) throws RemoteException {
		return webStrategyDataHelper.setGradeRule(po);
	}

	@Override
	public ResultMessage setWebStrategy(WebStrPO po) throws RemoteException {
		return webStrategyDataHelper.setWebStrategy(po);
	}

}
