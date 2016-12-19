package data.userdata;

import common.ResultMessage;
import dataservice.userdataservice.UserDataService;
import po.CilentPO;

/**
 * 模拟user模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class UserDataServiceMySqlImpl_Stub implements UserDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CilentPO getUserPassword(String name) {
		// TODO Auto-generated method stub
		return new CilentPO("csy", "123344");
	}

	@Override
	public ResultMessage setPassword(CilentPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
 
	

}
