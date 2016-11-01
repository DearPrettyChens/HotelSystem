package dataservice.checkindataservice;

import po.CheckinInfoPO;
import util.ResultMessage;


/**
 * 负责保存酒店住房信息
 * @author csy
 * @version 1.0
 * 
 */

public interface CheckinDataService {
	public void initial();
	
	/**
	 * 新增顾客住房信息
	 * @param  po CheckinInfoPO型，传递顾客住房信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage addCheckinInfo (CheckinInfoPO po);
	
	/**
	 * 获取顾客住房信息
	 * @param  orderID String型， 传递订单编号
	 * @return CheckinInfoPO 返回顾客住房信息
	 * @throws 无
	 *
	 */
	public CheckinInfoPO getCheckinInfo (String orderID);
	
	/**
	 * 修改顾客住房信息
	 * @param  po CheckinInfoPO型，传递顾客住房信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage modifyCheckinInfo (CheckinInfoPO po);
}
