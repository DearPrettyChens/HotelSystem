package data.checkindata;

import dataservice.checkindataservice.CheckinDataService;
import po.CheckinInfoPO;

/**
 * 模拟办理入住信息模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class CheckinDataServiceMySqlImpl_Driver {

	public void drive(CheckinDataService stub) {
		CheckinInfoPO checkinInfoPO = stub.getCheckinInfo("201610120001000001");
		System.out.println(stub.addCheckinInfo(checkinInfoPO));
		System.out.println(stub.modifyCheckinInfo(checkinInfoPO));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CheckinDataServiceMySqlImpl_Driver().drive(new CheckinDataServiceMySqlImpl_Stub());
	}

}
