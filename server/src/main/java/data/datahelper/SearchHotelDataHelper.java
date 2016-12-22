package data.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelListPO;
import util.HotelSortType;

public interface SearchHotelDataHelper {
	/**
	 * 获得酒店列表信息数据
	 * 
	 * @param 无
	 * @return ArrayList<HotelListPO>，将酒店列表信息返回给逻辑层
	 * @throws 未定
	 * 
	 */
	public ArrayList<HotelListPO> getHotelList();

	/**
	 * 获得排序后的酒店列表信息数据
	 * 
	 * @param 无
	 * @return ArrayList<HotelListPO>，将排序后的酒店列表信息返回给逻辑层
	 * @throws 未定
	 */
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type);
}
