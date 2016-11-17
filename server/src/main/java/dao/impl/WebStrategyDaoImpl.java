package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.webstrategydao.WebStrategyDao;
import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
import util.WebStrategyType;

/**
 * WebStrategyDao的实现
 * @author csy
 *
 */
public class WebStrategyDaoImpl extends UnicastRemoteObject implements WebStrategyDao {

	private static final long serialVersionUID = 3741314626971097134L;
	private static WebStrategyDao webStrategyDao;
		
	    public static WebStrategyDao getInstance() throws RemoteException {
			if(webStrategyDao==null){
				webStrategyDao=new WebStrategyDaoImpl();
			}
			return webStrategyDao;
		}
	    
	    private WebStrategyDaoImpl() throws RemoteException {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public GradeRulePO getGradeRule() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WebStrPO getWebStrategy(WebStrategyType type) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ResultMessage setGradeRule(GradeRulePO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ResultMessage setWebStrategy(WebStrPO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		
}
