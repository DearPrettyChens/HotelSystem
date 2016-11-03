package businesslogic.bl.userbl;

import dao.userdao.UserDao;
import util.Password;
import util.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;
/**
 * User类
 * @author CYF
 * @version 1.0
 */
public class User {
	//不变的属性 ID
	private String userID;
	//密码
	private String password;
	private UserDao userDao;
	public User(){
		
	}
	/**
	 * 登录方法
	 * @param name
	 * @param password
	 * @return ResultMessage
	 */
	public ResultMessage login(String name, String password) {
		return null;
	}
   
	public ResultMessage checkOldPassword(String name, String password) {
		return ResultMessage.SUCCESS;
	}
    /**
     * 检查新密码格式 委托给password
     * @param password
     * @return ResultMessage
     */
	public ResultMessage checkNewPassword(Password password) {
		return password.checkValid();
	}
    /**
     * 确认修改密码
     * @param passwordVO
     * @return ResultMessage
     */
	public ResultMessage confirmPassword(PasswordVO passwordVO) {
		return ResultMessage.SUCCESS;
	}
    /**
     * 获得基本信息
     * @param name
     * @return BasicInfoVO
     */
	public BasicInfoVO getBasicInfo(String name) {
		return null;
	}
    /**
     * 获得用户ID 
     * 实现的时候先判断ID是否为空
     * @param name
     * @return String
     */
	public String getUserID(String name) {
		return null;
	}

}
