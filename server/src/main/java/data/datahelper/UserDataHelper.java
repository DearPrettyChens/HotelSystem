package data.datahelper;

import po.ClientPO;
import util.ResultMessage;

public interface UserDataHelper {
	public ClientPO getUserPassword(String name);

	public ResultMessage setUserPassword(ClientPO po);
}
