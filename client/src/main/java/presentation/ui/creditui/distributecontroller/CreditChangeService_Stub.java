package presentation.ui.creditui.distributecontroller;

import businesslogic.blservice.creditblservice.CreditChangeService;
import util.ResultMessage;
import vo.creditvo.CreditVO;

public class CreditChangeService_Stub implements CreditChangeService{

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
	public ResultMessage confirmCreditDeposit(double money, String customerId) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
