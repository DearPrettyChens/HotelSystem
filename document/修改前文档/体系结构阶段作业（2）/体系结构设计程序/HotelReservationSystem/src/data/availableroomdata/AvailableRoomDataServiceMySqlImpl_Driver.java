package data.availableroomdata;

import common.BedType;
import dataservice.availableroomdataservice.AvailableRoomDataService;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;

/**
 * 模拟可用客房模块逻辑层和数据层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class AvailableRoomDataServiceMySqlImpl_Driver {
    
	public void drive(AvailableRoomDataService stub) {
		AvailableRoomInfoPO availableRoomInfoPO=stub.getAvailableRoomInfo("0001");
		System.out.println(stub.addAvailableRoomInfo(availableRoomInfoPO));
		System.out.println(stub.modifyAvailableRoomInfo(availableRoomInfoPO));
		System.out.println(stub.setAvailableRoomNumber(new AvailableRoomNumberPO()));
		System.out.println(stub.getRoomPrice("0001", BedType.BIGBED));
		System.out.println(stub.setBestPrice(availableRoomInfoPO));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new AvailableRoomDataServiceMySqlImpl_Driver().drive(new AvailableRoomDataServiceMySqlImpl_Stub());
	}

}
