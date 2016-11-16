package dao.userdaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.userdao.UserDao;
import po.ClientPO;
import util.ResultMessage;

/**
 * UserDao的实现
 * @author csy
 *
 */
public class UserDaoImpl extends UnicastRemoteObject implements UserDao {
	
	private static final long serialVersionUID = 2151592669947030124L;
	private static UserDao userDao;
		
	    public static UserDao getInstance() throws RemoteException {
			if(userDao==null){
				userDao=new UserDaoImpl();
			}
			return userDao;
		}
	    private UserDaoImpl() throws RemoteException {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public ClientPO getUserPassword(String name) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setPassword(ClientPO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		
}
