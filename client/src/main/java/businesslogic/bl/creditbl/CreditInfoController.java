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
	public CreditInfoController(){
		credit=new Credit();
	}
	@Override
	public CreditInfoVO getCreditInfo(String customerID) {
		// TODO Auto-generated method stub
		return null;
	}

}
