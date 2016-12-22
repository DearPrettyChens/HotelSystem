package data.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;

public interface AvailableRoomDataHelper {
	/**
	 * 获取可用客房信息
	 * 
	 * @param hotelID
	 *            String型，传递酒店编号
	 * @return AvailableRoomInfoPO 返回可用客房信息
	 * @throws 无
	 *
	 */
	public ArrayList<AvailableRoomInfoPO> getAvailableRoomInfo(String hotelID) throws RemoteException;

	/**
	 * 新增可用客房信息
	 * 
	 * @param po
	 *            AvailableRoomInfoPO型，传递可用客房信息
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException;

	/**
	 * 修改可用客房信息
	 * 
	 * @param po
	 *            AvailableRoomInfoPO型，传递可用客房信息
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) throws RemoteException;

	/**
	 * 设置可用客房数量信息 @param po AvailableRoomNumberPO型，传递可用客房数量信息 @return
	 * ResultMessage ，保存成功返回SUCCESS,失败返回FAIL @throws
	 *
	 */
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) throws RemoteException;

	/**
	 * 获取房间价格
	 * 
	 * @param hotelID
	 *            String型， bedType BedType型，传递酒店编号和床型
	 * @return double 返回房间价格
	 * @throws 无
	 *
	 */
	public double getRoomPrice(String hotelID, BedType bedType) throws RemoteException;

	/**
	 * 获取可用客房数量信息
	 * 
	 * @param hotelID
	 *            String ，传递酒店编号;date Date,传递日期；type BedType ,传递床型
	 * @return AvailableRoomNumberPO 返回可用客房数量信息
	 * @throws 无
	 *
	 */
	public AvailableRoomNumberPO getAvailableRoomNumber(String hotelID, Date date, BedType type) throws RemoteException;

	/**
	 * 设置房间最低价格信息
	 * 
	 * @param po
	 *            AvailableRoomInfoPO型，传递可用客房信息，其中包含了房间的最低价格
	 * @return ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage setBestPrice(ArrayList<AvailableRoomInfoPO> po) throws RemoteException;

}
