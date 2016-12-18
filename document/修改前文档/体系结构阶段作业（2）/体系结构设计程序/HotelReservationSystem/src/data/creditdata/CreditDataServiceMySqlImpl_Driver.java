package data.creditdata;

import dataservice.creditdataservice.CreditDataService;
import po.CreditInfoPO;
import po.CreditPO;

/**
 * 模拟credit模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class CreditDataServiceMySqlImpl_Driver {
	public void drive(CreditDataService stub) {
        CreditInfoPO creditInfoPO=stub.getCreditInfo("000001");
        System.out.println(stub.setCredit(new CreditPO()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new CreditDataServiceMySqlImpl_Driver().drive(new CreditDataServiceMySqlImpl_Stub());
	}
}
