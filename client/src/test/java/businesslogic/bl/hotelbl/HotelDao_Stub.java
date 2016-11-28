package businesslogic.bl.hotelbl;

import java.rmi.RemoteException;

import dao.hoteldao.HotelDao;
import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;
/**
 * 模拟hoteldao的实现
 * @author CLL
 *
 */
public class HotelDao_Stub implements HotelDao{

	@Override
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException {
		// TODO Auto-generated method stub
		return new HotelBasicInfoPO();
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
