package data.availableroomdata;

import common.BedType;
import common.ResultMessage;
import dataservice.availableroomdataservice.AvailableRoomDataService;
import po.AvailableRoomInfoPO;
import po.AvailableRoomNumberPO;
/**
 * 模拟可用客房模块逻辑层和数据层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class AvailableRoomDataServiceMySqlImpl_Stub implements AvailableRoomDataService{


	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AvailableRoomInfoPO getAvailableRoomInfo(String hotelID) {
		// TODO Auto-generated method stub
		return new AvailableRoomInfoPO();
	}

	@Override
	public ResultMessage addAvailableRoomInfo(AvailableRoomInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage modifyAvailableRoomInfo(AvailableRoomInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setAvailableRoomNumber(AvailableRoomNumberPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getRoomPrice(String hotelID,BedType bedType) {
		// TODO Auto-generated method stub
		return 100.00;
	}

	@Override
	public ResultMessage setBestPrice(AvailableRoomInfoPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
