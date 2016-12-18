package businesslogic.userbl;

import blservice.userblservice.UserBLService;
import common.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.DetailInfoVO;
import vo.uservo.PasswordVO;

/**
 * 模拟用户模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class UserBL_Stub implements UserBLService {

	@Override
	public ResultMessage login(String name, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public DetailInfoVO getDetailInfo(String name) {
		// TODO Auto-generated method stub
		return new DetailInfoVO();
	}

	@Override
	public ResultMessage checkTel(String tel) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmUserInfo(DetailInfoVO detailInfoVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkOldPassword(String name, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkNewPassword(String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage confirmPassword(PasswordVO passwordVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public BasicInfoVO getBasicInfo(String name) {
		// TODO Auto-generated method stub
		return new BasicInfoVO();
	}

	@Override
	public String getUserID(String name) {
		// TODO Auto-generated method stub
		return "000001";
	}

	@Override
	public int getGrade(String name) {
		// TODO Auto-generated method stub
		return 100;
	}

}
