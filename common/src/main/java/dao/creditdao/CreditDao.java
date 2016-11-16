package dao.creditdao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;


/**
 * 负责保存信用记录
 * @author csy
 * @version 1.0
 * 
 */

public interface CreditDao extends Remote{
	
	

	/**
	 * 新增一条信用记录
	 * @param  po CreditPO型，传递一条信用记录信息
	 * @return  ResultMessage ，保存成功返回SUCCESS,失败返回FAIL
	 * @throws 无
	 *
	 */
	public ResultMessage setCredit (CreditPO po)throws RemoteException;
	
	
	/**
	 * 获取所有信用记录信息
	 * @param customerID String型，传递所有信用记录信息
	 * @return  CreditInfoPO 返回顾客所有信用记录
	 * @throws 无
	 *
	 */
	public CreditInfoPO getCreditInfo(String customerID)throws RemoteException;
}
