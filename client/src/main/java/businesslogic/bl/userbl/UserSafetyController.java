package businesslogic.bl.userbl;

import businesslogic.blservice.userblservice.UserSafetyService;
import util.Password;
import util.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;

/**
 * 
 * 负责登录的控制部分
 * @author csy
 *
 */
public class UserSafetyController implements UserSafetyService{  
	private User user;
	private static UserSafetyService userSafetyController;
	
	private UserSafetyController(){
		user = User.getInstance();
	}
	
	public static UserSafetyService getInstance() {
		if(userSafetyController==null){
			userSafetyController= new UserSafetyController();
		}
		return userSafetyController;
	}
	
	@Override
	public ResultMessage login(String name, String password) {
		return user.login(name, password);
	}

	@Override
	public ResultMessage checkOldPassword(String password) {
		return user.checkOldPassword(password);
	}

	@Override
	public ResultMessage checkNewPassword(String password) {
		return user.checkNewPassword(new Password(password));
	}

	@Override
	public ResultMessage confirmPassword(PasswordVO passwordVO) {
		return user.confirmPassword(passwordVO);
	}

	@Override
	public String getUserID(String name) {
		return user.getUserID();
	}
	@Override
	public BasicInfoVO getBasicInfo() {
		return user.getBasicInfo();
	}

	@Override
	public ResultMessage logout() {
		userSafetyController=null;
		return user.logout();
	}


}
