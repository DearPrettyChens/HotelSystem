package businesslogic.creditbl;

import blservice.creditblservice.CreditBLService;
import common.ResultMessage;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
/**
 * 模拟管理信用模块界面层与逻辑层交互的实现
 * @author CLL
 *
 */
public class CreditBL_Stub implements CreditBLService{

	@Override
	public CreditInfoVO getCreditInfo(String customerID) {
		// TODO Auto-generated method stub
		return new CreditInfoVO();
	}

	@Override
	public ResultMessage addCredit(CreditVO creditVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage cutCredit(CreditVO creditVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmCreditDeposit(double money,String customerName) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
