package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dao.personneldao.PersonnelDao;
import po.CustomerDetailPO;
import po.CustomerListPO;
import po.HotelWorkerDetailPO;
import po.HotelWorkerListPO;
import po.WebMarketManDetailPO;
import po.WebMarketManListPO;
import util.ResultMessage;

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
		public ResultMessage addCustomer(CustomerDetailPO customerDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage addHotelworker(HotelWorkerDetailPO hotelWorkerDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage addWebMarketMan(WebMarketManDetailPO webMarketManDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<HotelWorkerListPO> getHotelWorkerList() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<WebMarketManListPO> getWebMarketManList() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ArrayList<CustomerListPO> getCustomerList() throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public HotelWorkerDetailPO getHotelWorkerDetail(String hotelID) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public WebMarketManDetailPO getWebMarketManDetail(String webMarketManID) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public CustomerDetailPO getCustomerDetail(String customerID) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setHotelWorker(HotelWorkerDetailPO hotelWorkerDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setWebMarketMan(WebMarketManDetailPO webMarketManDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setCustomer(CustomerDetailPO customerDetailPO) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

		
}
