package data.creditdata;

import common.ResultMessage;
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
public class CreditDataServiceMySqlImpl_Stub implements CreditDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage setCredit(CreditPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public CreditInfoPO getCreditInfo(String customerID) {
		// TODO Auto-generated method stub
		return new CreditInfoPO();
	}

	
}
