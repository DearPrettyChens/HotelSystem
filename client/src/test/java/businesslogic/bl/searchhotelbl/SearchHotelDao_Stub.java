package businesslogic.bl.searchhotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.searchhoteldao.SearchHotelDao;
import po.HotelListPO;
import util.HotelSortType;

/**
 * 
 * 模拟SearchHotelDao的实现
 * @author CSY
 *
 */
public class SearchHotelDao_Stub implements SearchHotelDao {
	
    ArrayList<HotelListPO> hotelListPOs= new ArrayList<HotelListPO>();
	HotelListPO hotelListPO=new HotelListPO("锦江之星大酒店", "nanjing", null, 222, 5, 1, 5.0, "12121212121");
	@Override
	public ArrayList<HotelListPO> getHotelList() throws RemoteException {
		hotelListPOs.add(hotelListPO);
		return hotelListPOs;
	}

	@Override
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type) throws RemoteException {
		hotelListPOs.add(hotelListPO);
		return hotelListPOs;
	}

}
