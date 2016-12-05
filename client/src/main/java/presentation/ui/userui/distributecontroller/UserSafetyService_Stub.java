package presentation.ui.userui.distributecontroller;

import businesslogic.blservice.userblservice.UserSafetyService;
import util.ResultMessage;
import util.UserType;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;

public class UserSafetyService_Stub implements UserSafetyService{

	@Override
	public ResultMessage login(String name, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkOldPassword(String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkNewPassword(String Password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmPassword(PasswordVO passwordVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public String getUserID(String name) {
		// TODO Auto-generated method stub
		return "000001";
	}

	@Override
	public BasicInfoVO getBasicInfo() {
		// TODO Auto-generated method stub
		BasicInfoVO vo=new BasicInfoVO("chen",null,"000001",UserType.Customer);
		return vo;
	}

	@Override
	public ResultMessage logout() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
