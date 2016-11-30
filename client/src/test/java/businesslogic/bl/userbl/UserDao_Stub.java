package businesslogic.bl.userbl;

import java.rmi.RemoteException;

import dao.userdao.UserDao;
import po.ClientPO;
import util.ResultMessage;
import util.UserType;

/**
 * 
 * 模拟userdao的实现
 * @author CSY
 *
 */
public class UserDao_Stub implements UserDao{

	@Override
	public ClientPO getUserPassword(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return new ClientPO("小豆", "123456", 1, UserType.Customer);
	}

	@Override
	public ResultMessage setPassword(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
