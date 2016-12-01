package businesslogic.bl.userbl;

import java.rmi.RemoteException;

import dao.userdao.UserDao;
import init.RMIHelper;
import po.ClientPO;
import util.Password;
import util.ResultMessage;
import util.TransHelper;
import util.UserType;
import vo.uservo.BasicInfoVO;
import vo.uservo.PasswordVO;

/**
 * User类
 * @author CYF
 * @version 1.0
 */
public class User {
	private static User user;
	private String userName;
	private String userID;
	private String password;
	private String firstPassword;
	private UserType userType;
	private PersonMap personMap;//对应的人种类表
	private UserDao userDao;
	private ClientPO clientPO;
	
	private User(){
//		userDao=new UserDao_Stub();
		RMIHelper.init();
		userDao=RMIHelper.getUserDao();
		personMap=PersonMap.getInstance();
	}
	
	/**
	 * 单例模式，整个软件只有一个用户进行操作
	 */
	public static User getInstance() {
		if(user==null){
			user=new User();
		}
		return user;
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
			userName=name;
			userID=TransHelper.idToString(clientPO.getUserID(), 6);		
			this.password=password;
			userType=clientPO.getType();
			return personMap.get(userType);//返回是哪种人登录成功了。
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
		
	}
   
	/**
     * 检查旧密码是否输入正确
     * @param name
     * @param password
     * @return ResultMessage
     */
	public ResultMessage checkOldPassword( String password) {
	
		if(password.equals(this.password)){
			
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.PASSWORDERROR;
	}
    
	/**
     * 检查新密码格式 委托给password
     * @param password
     * @return ResultMessage
     */
	public ResultMessage checkNewPassword(Password password) {
		this.firstPassword=password.getPassword();
		return password.checkValid();
	}
	
    /**
     * 确认修改密码
     * @param passwordVO
     * @return ResultMessage
     */
	public ResultMessage confirmPassword(PasswordVO passwordVO) {
		
		//判断两次输入的密码一致
		if((firstPassword!=null)&&(passwordVO.getPassword().equals(firstPassword))){
			password=firstPassword;
			try {
				userDao.setPassword(new ClientPO(userName, password, TransHelper.idToInt(userID)));
			    firstPassword=null;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return ResultMessage.SUCCESS;
		}
		
		return ResultMessage.PASSWORDNOTSAME;
		
	}
   
	/**
     * 获得基本信息
     * @param name
     * @return BasicInfoVO
     * 每种人的主界面上显示用户名，编号，和头像
     * 但是只有顾客头像是从数据库拿的，其他人头像都是界面固定的
     */
	public BasicInfoVO getBasicInfo() {
		if(userType==UserType.Customer){
			return Customer.getInstance().getBasicInfo(userName);
		}
		return new BasicInfoVO(userName,userID,userType);
	}
	
    /**
     * 获得用户ID 
     * 实现的时候先判断ID是否为空
     * @param name
     * @return String
     */
	public String getUserID() {
		return userID;
	}

	/**
	 * 登出操作
	 * @return
	 */
	public ResultMessage logout() {
		user=null;
		return ResultMessage.SUCCESS;
	}
}
