package data.checkindata;

import common.ResultMessage;
import dataservice.checkindataservice.CheckinDataService;
import po.CheckinInfoPO;

/**
 * 模拟办理入住信息模块逻辑层和数据层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class CheckinDataServiceMySqlImpl_Stub implements CheckinDataService{

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage addCheckinInfo(CheckinInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public CheckinInfoPO getCheckinInfo(String orderID) {
		// TODO Auto-generated method stub
		return new CheckinInfoPO();
	}

	@Override
	public ResultMessage modifyCheckinInfo(CheckinInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	

}
