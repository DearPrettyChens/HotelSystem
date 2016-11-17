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
	private static CreditChangeController controller=null;
	public CreditChangeController(String customerID){
		credit=new Credit(customerID);
	}
	//实现单例模式
	public static CreditChangeController getInstance(String customerID){
		if(controller==null||controller.credit.getCustomerID()!=customerID){
			return controller=new CreditChangeController(customerID);
		}
		else{
			return controller;
		}
	}
	@Override
	public ResultMessage addCredit(CreditVO creditVO) {
		return credit.addCredit(creditVO);
	}

	@Override
	public ResultMessage cutCredit(CreditVO creditVO) {
		return credit.cutCredit(creditVO);
	}

	@Override
	public ResultMessage confirmCreditDeposit(double money, String customerName) {
		return credit.confirmCreditDeposit(money, customerName);
	}

}
