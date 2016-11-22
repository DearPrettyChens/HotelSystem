package businesslogic.bl.creditbl;

import businesslogic.blservice.creditblservice.CreditInfoService;
import vo.creditvo.CreditInfoVO;
/**
 * credit模块的控制类
 * @author CLL
 * @version 1.0
 */
public class CreditInfoController implements CreditInfoService{
	//持有credit的引用
	private Credit credit;
	private static CreditInfoController controller=null;
	public CreditInfoController(String customerID){
		credit=new Credit(customerID);
	}
	//实现单例模式
	public static CreditInfoController getInstance(String customerID){
		if(controller==null||controller.credit.getCustomerID()!=customerID){
			controller=new CreditInfoController(customerID);
		}
		return controller;
	}
	@Override
	public CreditInfoVO getCreditInfo() {
		return credit.getUserCreditInfoList();
	}

}
