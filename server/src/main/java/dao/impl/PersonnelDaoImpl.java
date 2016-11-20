package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.personneldao.PersonnelDao;
import po.PersonDetailPO;
import po.PersonListPO;
import util.ResultMessage;
import util.UserType;

/**
 * PersonnelDao的实现
 * @author csy
 *
 */
public class PersonnelDaoImpl extends UnicastRemoteObject implements PersonnelDao{
	
	private static final long serialVersionUID = -2906427570970508819L;
	private static PersonnelDao personnelDao;
		
	    public static PersonnelDao getInstance() throws RemoteException {
			if(personnelDao==null){
				personnelDao=new PersonnelDaoImpl();
			}
			return personnelDao;
		}
	    private PersonnelDaoImpl() throws RemoteException {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public ResultMessage addPerson(PersonDetailPO personDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<PersonListPO> getPersonList(UserType userType, String userName, int userID)
				throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public PersonDetailPO getPersonDetail(int userID) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setPerson(PersonDetailPO personDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage checkUserName(String userName) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		

		
}
