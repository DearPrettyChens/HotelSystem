package presentation.ui.userui.distributecontroller;

import businesslogic.bl.userbl.UserSafetyController;
import businesslogic.blservice.userblservice.UserSafetyService;
import util.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;

public class UserSafetyDistributeController{
	public static UserSafetyDistributeController controller=null;
	public static UserSafetyDistributeController getInstance(){
		if(controller==null){
			controller=new UserSafetyDistributeController();
		}
		return controller;
	}
	private UserSafetyService service;
	private UserSafetyDistributeController(){
		service=UserSafetyController.getInstance();
//		service=new UserSafetyService_Stub();
	}
	

	public ResultMessage checkOldPassword(String password) {
		return service.checkOldPassword(password);
	}

	
	public ResultMessage checkNewPassword(String Password) {
		return service.checkNewPassword(Password);
	}

	
	public ResultMessage confirmPassword(PasswordVO passwordVO) {
		return service.confirmPassword(passwordVO);
	}

}
