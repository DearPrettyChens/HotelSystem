package businesslogic.bl.orderbl;

import java.util.Date;

import businesslogic.blservice.orderblservice.GenerateOrderService;
import util.ResultMessage;
import util.Telephone;
import vo.availableroomvo.AvailableRoomNumberVO;
import vo.hotelvo.HotelDetailInfoVO;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.StrategyVO;
/**
 * Order模块的GenerateOrderController控制类
 * @author csy
 * @version 1.0
 */
public class GenerateOrderController implements GenerateOrderService{
	 private Order order;
	 
		public GenerateOrderController() {
			order = new Order();
		}
	@Override
	public ResultMessage checkUserCredit(String customerID) {
		// TODO Auto-generated method stub
		return order.checkUserCredit(customerID);
	}

	@Override
	public ResultMessage checkTelephone(String telNum) {
		// TODO Auto-generated method stub
		return order.checkTel(new Telephone(telNum));
	}

	@Override
	public ResultMessage checkTime(Date time) {
		// TODO Auto-generated method stub
		return order.checkTime(time);
	}

	@Override
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO) {
		// TODO Auto-generated method stub
		return order.confirmAddOrder(orderInfoVO);
	}

	@Override
	public StrategyVO next(OrderInfoVO orderinfovo) {
		// TODO Auto-generated method stub
		return order.next(orderinfovo);
	}

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID) {
		// TODO Auto-generated method stub
		return order.getHotelDetailInfo(hotelID);
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(AvailableRoomNumberVO vo) {
		// TODO Auto-generated method stub
		return order.checkAvailableRoomNumber(vo);
	}

}
