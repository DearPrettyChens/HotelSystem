package businesslogic.blservice.creditblservice;

import vo.creditvo.CreditInfoVO;

/**
 * 查看顾客的信用记录接口
 * @author CLL
 * @version 1.0
 */
public interface CreditInfoService {
	/**
	 * 获取顾客的信用记录
	 * @param customerID String型，传递顾客编号
	 * @return CreditInfoVO，将信用记录信息返回给界面
	 * @throws 未定
	 *
	 */
	public CreditInfoVO getCreditInfo (String customerID);
}
