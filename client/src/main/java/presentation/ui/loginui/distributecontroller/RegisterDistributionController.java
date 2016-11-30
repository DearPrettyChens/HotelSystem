package presentation.ui.loginui.distributecontroller;

import businesslogic.bl.personnelbl.PersonnelController;
import businesslogic.blservice.personnelblservice.PersonnelBLService;
import util.ResultMessage;
import vo.personnelvo.PersonDetailVO;

/**
 * 用户注册界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class RegisterDistributionController {
	private static RegisterDistributionController controller=null;
	private PersonnelBLService personnelBLService;
	private RegisterDistributionController(){
		personnelBLService=PersonnelController.getInstance();
	}
	public static RegisterDistributionController getInstance(){
		if(controller==null){
			controller=new RegisterDistributionController();
		}
		return controller;
	}
	
	/**判断该用户名是否合法及是否被注册
	 * @param userName
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkUserName(String userName){
		return personnelBLService.checkUserName(userName);
	}
	

	/**判断该电话是否符合格式正确
	 * @param userTel
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkTel(String userTel){
		return personnelBLService.checkTel(userTel);
	}

	

	/**判断密码是否符合格式
	 * @param password
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage checkPassword(String password){
		return personnelBLService.checkPassword(password);
	}

	/**
	 * 增加用户
	 * @param personDetailVO
	 * @return ResultMessage
	 * @throws 未定
	 */
	public ResultMessage addPerson(PersonDetailVO personDetailVO){
		return personnelBLService.addPerson(personDetailVO);
	}
}
