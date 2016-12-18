package blservice.creditblservice;

import common.ResultMessage;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
/**
 * CreditBLService提供接口，用来对顾客信用值的管理
 * @author csy
 * @version 1.0
 * 
 */
public interface CreditBLService {
	/**
	 * 获取顾客的信用记录
	 * @param customerID String型，传递顾客编号
	 * @return CreditInfoVO，将信用记录信息返回给界面
	 * @throws 未定
	 *
	 */
	public CreditInfoVO getCreditInfo (String customerID);
	
	/**
	 * 增加顾客信用值
	 * 新增一条顾客的信用记录并更改顾客的信用值
	 * @param creditVO CreditVO型，界面传递过来的一条信用记录信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage addCredit (CreditVO creditVO);
	
	/**
	 * 减少顾客信用值
	 * 新增一条顾客的信用记录并更改顾客的信用值
	 * @param creditVO CreditVO型，界面传递过来的一条信用记录信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage cutCredit (CreditVO creditVO);
	
	/**
	 * 充值后增加顾客信用值
	 * 新增一条顾客的信用记录并更改顾客的信用值
	 * @param money double型,customerName String型，界面传递顾客姓名和充值金额
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmCreditDeposit (double money,String customerName);

}
