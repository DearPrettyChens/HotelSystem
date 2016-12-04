package presentation.ui.availableroomui.distributecontroller;

import businesslogic.blservice.availableroomblservice.RoomPriceService;
import util.BedType;
import util.ResultMessage;

public class RoomPriceService_Stub implements RoomPriceService{

	@Override
	public ResultMessage setBestPrice(String hotelID, double discount) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public double getRoomPrice(String hotelID, BedType bedType) {
		// TODO Auto-generated method stub
		return 500;
	}

}
