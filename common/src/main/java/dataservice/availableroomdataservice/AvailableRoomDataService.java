package dataservice.availableroomdataservice;


import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
import util.BedType;
import util.ResultMessage;


/**
 * 负责保存酒店可用客房信息
 * @author csy
 * @version 1.0
 * 
 */

public interface AvailableRoomDataService {
	public void initial();
	
	/**
	 * 获取可用客房信息
	 * @param  hotelID String型，传递酒店编号
	 * @return AvailableRoomInfoPO 返回可用客房信息
	 * @throws 无
	 *
	 */
	public AvailableRoomInfoPO getAvailableRoomInfo (String hotelID);
	
	/**
	 * 新增可用客房信息
	 * @param  po AvailableRoomInfoPO型，传递可用客房信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addAvailableRoomInfo (AvailableRoomInfoPO po);
	
	/**
	 * 修改可用客房信息
	 * @param  po AvailableRoomInfoPO型，传递可用客房信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage modifyAvailableRoomInfo (AvailableRoomInfoPO po);
	
	/**
	 * 设置可用客房数量信息
	 * @param  po AvailableRoomNumberPO型，传递可用客房数量信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws
	 *
	 */
	public ResultMessage setAvailableRoomNumber (AvailableRoomNumberPO po);
	
	/**
	 * 获取房间价格
	 * @param  hotelID String型， bedType BedType型，传递酒店编号和床型
	 * @return double 返回房间价格
	 * @throws 无
	 *
	 */
	public double getRoomPrice(String hotelID,BedType bedType);
	
	/**
	 * 设置房间最低价格信息
	 * @param  po AvailableRoomInfoPO型，传递可用客房信息，其中包含了房间的最低价格
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage setBestPrice(AvailableRoomInfoPO po);
}
