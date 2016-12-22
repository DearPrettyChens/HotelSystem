package data.datahelper;

import po.ClientPO;
import util.ResultMessage;

public interface UserDataHelper {
	/**
	 * 获取用户密码
	 * 
	 * @param name
	 *            String型，传递用户密码
	 * @return ClientPO ，将用户密码传递给逻辑层
	 * @throws 未定
	 */
	public ClientPO getUserPassword(String name);

	/**
	 * 设置用户密码
	 * 
	 * @param po
	 *            ClientPO型，传递账户与密码信息
	 * @return ResultMessage，设置成功则返回SUCCESS，设置失败显示FAIL
	 * @throws 未定
	 */
	public ResultMessage setUserPassword(ClientPO po);
}
