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

	public HotelOrderController() {
			hotel=new Hotel();
	}

	@Override
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelOrderInfoVO getHotelOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
