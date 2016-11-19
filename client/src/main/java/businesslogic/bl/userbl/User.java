package businesslogic.bl.userbl;

import java.rmi.RemoteException;

import dao.userdao.UserDao;
import init.RMIHelper;
import po.ClientPO;
import util.Password;
import util.ResultMessage;
import util.TransHelper;
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
	private ClientPO clientPO;
	public User(){
		userDao=RMIHelper.getUserDao();
	}
	/**
	 * 登录方法
	 * @param name
	 * @param password
	 * @return ResultMessage
	 */
	public ResultMessage login(String name, String password) {
		try {
			clientPO=userDao.getUserPassword(name);
	       
			//用户不存在
			if(clientPO==null){
				return ResultMessage.USERNOTEXIST;
		    }
			
			//密码错误
			if(password!=clientPO.getPassword()){
				return ResultMessage.PASSWORDERROR;
			}
			
			//登录成功
			userID=TransHelper.idToString(clientPO.getUserID(), 6);		
			password=this.password;
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
   
	private ResultMessage checkUser(ClientPO clientPO){
		
		return ResultMessage.SUCCESS;
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
	public String getUserID() {
		return null;
	}

}
