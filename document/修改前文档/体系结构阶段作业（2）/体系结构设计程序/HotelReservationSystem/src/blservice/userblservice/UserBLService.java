package blservice.userblservice;



import common.ResultMessage;
import vo.uservo.BasicInfoVO;
import vo.uservo.DetailInfoVO;
import vo.uservo.PasswordVO;
/**
 * UserBLService提供接口，用来提供登录与用户账户信息修改的服务，存储当前登录用户身份
 * @author csy
 * @version 1.0
 * 
 */
public interface UserBLService {
	
	/**
	 * 验证账号密码是否正确
	 * @param name String型,password String型，传递用户名和密码
	 * @return ResultMessage，账号密码正确返回SUCCESS,密码错误返回PASSWORDERROR，用户名不存在返回USERNOTEXIST
	 * @throws 未定
	 *
	 */
	public ResultMessage login(String name ,String password);
	
	/**
	 * 获取用户详细信息
	 * @param name String型，传递用户名
	 * @return DetailInfoVO ，将用户详细信息返回给界面
	 * @throws 未定
	 *
	 */
	public DetailInfoVO getDetailInfo(String name);
	
	/**
	 * 检查电话格式
	 * @param tel String型，传递联系方式
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回USERTELFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkTel(String tel);
	
	/**
	 * 保存用户详细信息
	 * @param detailInfoVO DetailInfoVO型，界面传递过来的用户详细信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmUserInfo(DetailInfoVO detailInfoVO);
	
	/**
	 * 检查密码是否正确
	 * @param name String型,password String型，传递用户名和密码
	 * @return ResultMessage，账号密码正确返回SUCCESS,密码错误返回PASSWORDERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkOldPassword(String name,String password);
	
	/**
	 * 检查新密码格式
	 * @param password String型，传递新密码
	 * @return ResultMessage，格式正确返回SUCCESS,格式错误返回PASSWORDFORMATERROR
	 * @throws 未定
	 *
	 */
	public ResultMessage checkNewPassword(String password);
	
	/**
	 * 保存用户修改后的密码
	 * @param passwordVO PasswordVO 型，界面传递过来的用户密码信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，密码不一致返回PASSWORDNOTSAME
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmPassword(PasswordVO passwordVO);
	
	/**
	 * 获取用户基本信息（用户名和头像）
	 * @param name String型，传递用户名
	 * @return BasicInfoVO ，将用户基本信息返回给界面
	 * @throws 未定
	 *
	 */
	public BasicInfoVO getBasicInfo(String name);
	
	/**
	 * 获取用户编号（注：酒店工作人员返回酒店编号）
	 * @param name String型，传递用户名
	 * @return String ，将用户编号返回给界面
	 * @throws 未定
	 *
	 */
	public String getUserID (String name);
	
	/**
	 * 获取顾客会员等级
	 * @param name String型，传递用户名
	 * @return int，将顾客会员等级返回给界面
	 * @throws 未定
	 *
	 */
	public int getGrade(String name);
}
