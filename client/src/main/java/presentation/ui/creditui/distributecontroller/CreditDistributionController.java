package presentation.ui.creditui.distributecontroller;

import businesslogic.bl.creditbl.CreditChangeController;
import businesslogic.bl.creditbl.CreditInfoController;
import businesslogic.blservice.creditblservice.CreditChangeService;
import businesslogic.blservice.creditblservice.CreditInfoService;
import util.ResultMessage;
import vo.creditvo.CreditInfoVO;
import vo.creditvo.CreditVO;
/**
 * credit界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class CreditDistributionController {
	private static CreditDistributionController controller=null;
	private CreditChangeService creditChangeService;
	private CreditInfoService creditInfoService;
	private static String customer;
	private CreditDistributionController(String customerID){
		creditChangeService=CreditChangeController.getInstance(customerID);
		creditInfoService=CreditInfoController.getInstance(customerID);
		customer=customerID;
	}
	public static CreditDistributionController getInstance(String customerID){
		if(controller==null||customer!=customerID){
			controller=new CreditDistributionController(customerID);
		}
		return controller;
	}
	
	/**
	 * 增加顾客信用值
	 * 新增一条顾客的信用记录并更改顾客的信用值
	 * @param creditVO CreditVO型，界面传递过来的一条信用记录信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage addCredit (CreditVO creditVO){
		return creditChangeService.addCredit(creditVO);
	}
	
	/**
	 * 减少顾客信用值
	 * 新增一条顾客的信用记录并更改顾客的信用值
	 * @param creditVO CreditVO型，界面传递过来的一条信用记录信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage cutCredit (CreditVO creditVO){
		return creditChangeService.cutCredit(creditVO);
	}
	
	/**
	 * 充值后增加顾客信用值
	 * 新增一条顾客的信用记录并更改顾客的信用值
	 * @param money double型,customerName String型，界面传递顾客姓名和充值金额
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmCreditDeposit (double money,String customerId){
		return creditChangeService.confirmCreditDeposit(money, customerId);
	}
	
	/**
	 * 获取顾客的信用记录
	 * @return CreditInfoVO，将信用记录信息返回给界面
	 * @throws 未定
	 *
	 */
	public CreditInfoVO getCreditInfo (){
		return creditInfoService.getCreditInfo();
	}
}
