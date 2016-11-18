package data.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelListPO;
import util.HotelSortType;

public interface SearchHotelDataHelper {
	public ArrayList<HotelListPO> getHotelList();

	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type);
}
