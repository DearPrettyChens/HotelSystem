package businesslogic.blservice.creditblservice;

import util.ResultMessage;
import vo.creditvo.CreditVO;

/**
 * 信用值变化的接口
 * @author CLL
 * @version 1.0
 */
public interface CreditChangeService {
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
	public ResultMessage confirmCreditDeposit (double money,String customerId);

}
