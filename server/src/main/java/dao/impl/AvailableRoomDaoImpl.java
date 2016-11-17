package dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.availableroomdao.AvailableRoomDao;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;
/**
 * AvailableRoomDao的实现
 * @author csy
 *
 */
public class AvailableRoomDaoImpl extends UnicastRemoteObject implements AvailableRoomDao {
  
	private static final long serialVersionUID = -572024053152986904L;
	private static AvailableRoomDao availableRoomDao;
	
    public static AvailableRoomDao getInstance() throws RemoteException {
		if(availableRoomDao==null){
			availableRoomDao= new AvailableRoomDaoImpl();
		}
		return availableRoomDao;
	}
    
    private AvailableRoomDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public AvailableRoomInfoPO getAvailableRoomInfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage setBestPrice(AvailableRoomInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	
}
