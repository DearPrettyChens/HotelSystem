package dao.searchhoteldao;
import java.util.ArrayList;
import po.HotelListPO;
import util.HotelSortType;

/**
 * SearchHotelDao提供搜索酒店数据接口，用来得到浏览时的酒店列表信息
 * @author CYF
 * @version 1.0
 * 
 */


public interface SearchHotelDao {
	/**
	 * 
	 */
	public void initial();
	/**
	 * 获得酒店列表信息数据
	 * @param 无
	 * @return ArrayList<HotelListPO>，将酒店列表信息返回给逻辑层
	 * @throws 未定
	 * 
	 */
	public ArrayList<HotelListPO> getHotelList();
	/**
	 * 获得排序后的酒店列表信息数据
	 * @param 无
	 * @return ArrayList<HotelListPO>，将排序后的酒店列表信息返回给逻辑层
	 * @throws 未定
	 */
	public ArrayList<HotelListPO> getSortedHotelList(HotelSortType type);
}
