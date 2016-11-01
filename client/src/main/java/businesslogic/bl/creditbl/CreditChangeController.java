package businesslogic.bl.creditbl;

import businesslogic.blservice.creditblservice.CreditChangeService;
import util.ResultMessage;
import vo.creditvo.CreditVO;

/**
 * credit模块的控制类
 * @author CLL
 * @version 1.0
 */
public class CreditChangeController implements CreditChangeService{
	//持有credit的引用
	private Credit credit;
	public CreditChangeController(){
		credit=new Credit();
	}
	@Override
	public ResultMessage addCredit(CreditVO creditVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cutCredit(CreditVO creditVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage confirmCreditDeposit(double money, String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
