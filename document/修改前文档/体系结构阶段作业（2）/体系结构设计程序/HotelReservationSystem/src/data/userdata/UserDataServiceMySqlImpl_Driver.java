package data.userdata;

import dataservice.userdataservice.UserDataService;
import po.CilentPO;

/**
 * 模拟user模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class UserDataServiceMySqlImpl_Driver {

	public void drive(UserDataService stub) {
 
		CilentPO cilentPO=stub.getUserPassword("csy");
		System.out.println(stub.setPassword(cilentPO));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new UserDataServiceMySqlImpl_Driver().drive(new UserDataServiceMySqlImpl_Stub());
	}
}
