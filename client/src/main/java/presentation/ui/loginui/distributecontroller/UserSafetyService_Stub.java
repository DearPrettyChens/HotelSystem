package presentation.ui.loginui.distributecontroller;



import businesslogic.blservice.userblservice.UserSafetyService;
import util.ResultMessage;
import util.UserType;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;

public class UserSafetyService_Stub implements UserSafetyService{

	private int i = 0;
	@Override
	public ResultMessage login(String name, String password) {
		// TODO Auto-generated method stub
		if(i==0){
			i++;
			return ResultMessage.USERNOTEXIST;
		}else if(i==1){
			i++;
			return ResultMessage.PASSWORDERROR;
		}else if(i==2){
			i++;
			return ResultMessage.USERHASLOGGEDIN;
		}else{
			return ResultMessage.WebMarketMan;
		}
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
		BasicInfoVO VO=new BasicInfoVO("chen",null,"000001",UserType.Customer);
		return VO;
	}

	@Override
	public ResultMessage logout() {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
