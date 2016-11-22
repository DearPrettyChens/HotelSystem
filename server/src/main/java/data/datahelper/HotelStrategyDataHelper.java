package data.datahelper;

import java.rmi.RemoteException;

import po.HotelStrPO;
import util.HotelStrategyType;
import util.ResultMessage;

public interface HotelStrategyDataHelper {
	public HotelStrPO getHotelStrategy(String hotelID, HotelStrategyType type) throws RemoteException;

	public ResultMessage setHotelStrategy(HotelStrPO po) throws RemoteException;
}
