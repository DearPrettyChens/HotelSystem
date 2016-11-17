package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.hotelstrategydao.HotelStrategyDao;
import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;

/**
 * CheckinDao的实现
 * @author csy
 *
 */
public class HotelStrategyDaoImpl extends UnicastRemoteObject implements HotelStrategyDao{
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 9114882706262722192L;
	private static HotelStrategyDao hotelStrategyDao;
		
	    public static HotelStrategyDao getInstance() throws RemoteException {
			if(hotelStrategyDao==null){
				hotelStrategyDao=new HotelStrategyDaoImpl();
			}
			return hotelStrategyDao;
		}
	    private HotelStrategyDaoImpl() throws RemoteException {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}


		
}
