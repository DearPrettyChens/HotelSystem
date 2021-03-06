package businesslogic.bl.availableroombl;

import businesslogic.blservice.availableroomblservice.RoomPriceService;
import util.BedType;
import util.ResultMessage;
/**
 * RoomPrice的控制类
 * 
 * @author CLL
 * @version 1.0
 */
public class RoomPriceController implements RoomPriceService{
	//持有AvailableRoom引用
	private AvailableRoom availableRoom;
	private static RoomPriceController controller=null;
	private RoomPriceController(){
		availableRoom=new AvailableRoom();
	}
	//实现单件模式
	public static RoomPriceController getInstance(){
		if(controller==null){
			return controller=new RoomPriceController();
		}
		else{
			return controller;
		}
	}
	@Override
	public double getRoomPrice(String hotelID, BedType bedType) {
		return availableRoom.getRoomPrice(hotelID, bedType);
	}

	@Override
	public ResultMessage setBestPrice(String hotelID, double discount) {
		return availableRoom.setBestPrice(hotelID, discount);
	}
	
}
