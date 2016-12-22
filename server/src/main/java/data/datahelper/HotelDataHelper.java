package data.datahelper;

import java.rmi.RemoteException;

import po.HotelBasicInfoPO;
import po.HotelBestPricePO;
import po.RemarkPO;
import util.ResultMessage;

public interface HotelDataHelper {

	/**
	 * 获取酒店基本信息
	 * 
	 * @param hotelID
	 *            String型，传递酒店编号
	 * @return HotelBasicInfoPO 返回酒店基本信息
	 * @throws 无
	 *
	 */
	public HotelBasicInfoPO getHotelBasicInfo(String hotelID) throws RemoteException;

	/**
	 * 新增评价信息，包括评分评论
	 * 
	 * @param po
	 *            RemarkPO型，传递评价信息
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addRemarkInfo(RemarkPO po) throws RemoteException;

	/**
	 * 新增酒店基本信息
	 * 
	 * @param po
	 *            HotelBasicInfoPO型，传递酒店基本信息
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException;

	/**
	 * 修改酒店基本信息
	 * 
	 * @param po
	 *            HotelBasicInfoPO型，传递酒店基本信息
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *             HotelBasicInfoPO
	 */
	public ResultMessage setHotelBasicInfo(HotelBasicInfoPO po) throws RemoteException;

	/**
	 * 设置酒店最低价格
	 * 
	 * @param po
	 *            HotelBestPricePO型，传递酒店最低价格信息
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage setBestPrice(HotelBestPricePO po) throws RemoteException;
}
