package presentation.ui.loginui.distributecontroller;

import java.rmi.RemoteException;

import businesslogic.bl.userbl.UserSafetyController;
import businesslogic.blservice.userblservice.UserSafetyService;
import util.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;

/**
 * login界面调用逻辑层的控制类
 * @author CLL
 *
 */
public class LoginDistributionController {
	private static LoginDistributionController controller=null;
	private UserSafetyService userSafetyService;
	private LoginDistributionController(){
		userSafetyService=UserSafetyController.getInstance();
	}
	public static LoginDistributionController getInstance(){
		if(controller==null){
			controller=new LoginDistributionController();
		}
		return controller;
	}
	
	/**
	 * 验证账号密码是否正确
	 * @param name String型,password String型，传递用户名和密码
	 * @return ResultMessage，账号密码正确返回SUCCESS,密码错误返回PASSWORDERROR，用户名不存在返回USERNOTEXIST
	 * @throws 未定
	 *
	 */
	public ResultMessage login(String name ,String password){
		return userSafetyService.login(name, password);
	}

	
	/**
	 * 检查密码是否正确
	 * 
	 * @param password String型，传递用户名和密码
	 * @return ResultMessage，账号密码正确返回SUCCESS,密码错误返回PASSWORDERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkOldPassword( String password){
		return userSafetyService.checkOldPassword(password);
	}

	/**
	 * 检查新密码格式
	 * 
	 * @param password String型，传递新密码
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回PASSWORDFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkNewPassword(String Password){
		return userSafetyService.checkNewPassword(Password);
	}
	
	/**
	 * 保存用户修改后的密码
	 * 
	 * @param passwordVO
	 *            PasswordVO 型，界面传递过来的用户密码信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，密码不一致返回PASSWORDNOTSAME
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmPassword(PasswordVO passwordVO){
		return userSafetyService.confirmPassword(passwordVO);
	}
	/**
	 * 获取用户编号（注：酒店工作人员返回酒店编号）
	 * 
	 * @param name
	 *            String型，传递用户名
	 * @return String ，将用户编号返回给界面
	 * @throws 未定
	 *
	 */
	public String getUserID(String name){
		return userSafetyService.getUserID(name);
	}

	/**
	 * 获取用户基本信息（用户名和头像）
	 * 
	 * @param name
	 *            String型，传递用户名
	 * @return BasicInfoVO ，将用户基本信息返回给界面
	 * @throws 未定
	 *
	 */
	public BasicInfoVO getBasicInfo(){
		return userSafetyService.getBasicInfo();
	}
	
	/**
	 * 登出操作，将用户一切进行原始化
	 * @return resultMessage
	 */
	public ResultMessage logout(){
		try {
			return userSafetyService.logout();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
}
