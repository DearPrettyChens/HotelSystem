package businesslogic.bl.orderbl;

import java.util.Date;

import businesslogic.bl.hotelbl.Hotel;
import businesslogic.blservice.orderblservice.GenerateOrderService;
import exception.NotFoundHotelException;
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
	private static GenerateOrderController controller=null;
	private GenerateOrderController() {
		order = new Order(new Hotel());
	}
	public static GenerateOrderController getInstance(){
		if(controller==null){
			controller=new GenerateOrderController();
		}
		return controller;
	}
	@Override
	public ResultMessage checkUserCredit(String customerID) {
		return order.checkUserCredit(customerID);
	}

	@Override
	public ResultMessage checkTelephone(String telNum) {
		return order.checkTel(new Telephone(telNum));
	}

	@Override
	public ResultMessage checkTime(Date time) {
		return order.checkTime(time);
	}

	@Override
	public ResultMessage confirmAddOrder(OrderInfoVO orderInfoVO) {
		return order.confirmAddOrder(orderInfoVO);
	}

	@Override
	public StrategyVO next(OrderInfoVO orderinfovo) {
		return order.next(orderinfovo);
	}

	@Override
	public HotelDetailInfoVO getHotelDetailInfo(String hotelID) throws NotFoundHotelException {
		return order.getHotelDetailInfo(hotelID);
	}

	@Override
	public ResultMessage checkAvailableRoomNumber(AvailableRoomNumberVO vo) {
		return order.checkAvailableRoomNumber(vo);
	}

}
