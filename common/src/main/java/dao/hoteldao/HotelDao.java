package dao.hoteldao;

import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;


/**
 * 负责保存酒店信息
 * @author csy
 * @version 1.0
 * 
 */
public interface HotelDao {

	public void initial();
	
	/**
	 * 获取酒店基本信息
	 * @param hotelID String型，传递酒店编号
	 * @return  HotelBasicInfoPO 返回酒店基本信息
	 * @throws 无
	 *
	 */
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID);
	
	/**
	 * 新增评价信息，包括评分评论
	 * @param  po RemarkPO型，传递评价信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addRemarkInfo(RemarkPO po);
	
	/**
	 * 新增酒店基本信息
	 * @param  po HotelBasicInfoPO型，传递酒店基本信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po);
	
	/**
	 * 修改酒店基本信息
	 * @param  po HotelBasicInfoPO型，传递酒店基本信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *HotelBasicInfoPO
	 */
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po);
	
	/**
	 * 设置酒店最低价格
	 * @param  po HotelBestPricePO型，传递酒店最低价格信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage setBestPrice(HotelBestPricePO po);
}
