package dao.userdao;


import po.ClientPO;
import util.ResultMessage;
/**
 * UserDao提供用户数据层接口，用来得到用户密码与设置用户密码
 * @author CYF
 * @version 1.0
 */
public interface UserDao {
	/**
	 * 
	 */
	public void initial();
	/**
	 * 获取用户密码
	 * @param name String型，传递用户密码
	 * @return ClientPO ，将用户密码传递给逻辑层
	 * @throws 未定
	 */
	public ClientPO getUserPassword(String name);
	/**
	 * 设置用户密码
	 * @param po ClientPO型，传递账户与密码信息
	 * @return ResultMessage，设置成功则返回SUCCESS，设置失败显示FAIL
	 * @throws 未定
	 */
	public ResultMessage setPassword(ClientPO po);
}
