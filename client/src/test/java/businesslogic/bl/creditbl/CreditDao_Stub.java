package businesslogic.bl.creditbl;

import java.rmi.RemoteException;

import dao.creditdao.CreditDao;
import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 模拟creditdao的实现
 * @author CLL
 *
 */
public class CreditDao_Stub implements CreditDao{
	int credit=100;
	@Override
	public ResultMessage setCredit(CreditPO po) throws RemoteException {
		// TODO Auto-generated method stub
		credit=(int) po.getCredit();
		return ResultMessage.SUCCESS;
	}

	@Override
	public CreditInfoPO getCreditInfo(String customerID) throws RemoteException {
		// TODO Auto-generated method stub
		List<CreditPO> pos=new ArrayList<CreditPO>();
		pos.add(new CreditPO("chen",000001,credit,0,null,new Date()));
		CreditInfoPO po=new CreditInfoPO(pos);
		return po;
	}

}
