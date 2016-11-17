package businesslogic.bl.hotelbl;

import java.util.ArrayList;

import businesslogic.blservice.hotelblservice.HotelOrderService;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;
/**
 * Hotel模块的HotelOrderController控制类
 * @author csy
 * @version 1.0
 */
public class HotelOrderController implements HotelOrderService {
	// 持有hotel的引用
	private Hotel hotel;
	private static HotelOrderController controller=null;

	private HotelOrderController() {
			hotel=new Hotel();
	}

	public HotelOrderController getInstance(){
		if(controller==null){
			controller=new HotelOrderController();
		}
		return controller;
	}
	
	@Override
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID) {
		return hotel.getHotelOrderList(hotelID);
	}

	@Override
	public HotelOrderInfoVO getHotelOrderInfo(String orderID) {
		return hotel.getHotelOrderInfo(orderID);
	}

	
}
