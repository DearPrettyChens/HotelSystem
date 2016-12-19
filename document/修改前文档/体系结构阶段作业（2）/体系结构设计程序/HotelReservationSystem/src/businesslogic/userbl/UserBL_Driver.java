package businesslogic.userbl;

import blservice.userblservice.UserBLService;
import vo.uservo.BasicInfoVO;
import vo.uservo.DetailInfoVO;

/**
 * 模拟用户模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class UserBL_Driver {

	public void drive(UserBLService stub) {
		DetailInfoVO detailInfoVO=stub.getDetailInfo("csy");
		BasicInfoVO basicInfoVO=stub.getBasicInfo("csy");
		System.out.println(stub.login("csy", "123456"));
		System.out.println(stub.checkTel("12345678900"));
	    System.out.println(stub.confirmUserInfo(detailInfoVO));
	    System.out.println(stub.checkOldPassword("csy", "123456"));
	    System.out.println(stub.checkNewPassword("123456"));
	    System.out.println(stub.checkNewPassword("123456"));
	    System.out.println(stub.getUserID("csy"));
	    System.out.println(stub.getGrade("csy"));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new UserBL_Driver().drive(new UserBL_Stub());
	}

}
