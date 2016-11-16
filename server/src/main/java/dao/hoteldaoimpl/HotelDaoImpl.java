package dao.hoteldaoimpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dao.hoteldao.HotelDao;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;

/**
 * HotelDao的实现
 * 
 * @author csy
 *
 */
public class HotelDaoImpl extends UnicastRemoteObject implements HotelDao {

	private static final long serialVersionUID = 2276917735276620811L;
	private static HotelDao hotelDao;

	public static HotelDao getInstance() throws RemoteException {
		if (hotelDao == null) {
			hotelDao = new HotelDaoImpl();
		}
		return hotelDao;
	}

	private HotelDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
