package data.datahelper;

import java.rmi.RemoteException;

import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;

public interface HotelDataHelper {
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException;

	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException;

	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException;

	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException;

	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException;
}
