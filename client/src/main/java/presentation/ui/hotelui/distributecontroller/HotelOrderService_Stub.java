package presentation.ui.hotelui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.blservice.hotelblservice.HotelOrderService;
import util.BedType;
import util.Children;
import util.OrderState;
import vo.hotelvo.HotelOrderInfoVO;
import vo.hotelvo.HotelOrderVO;

public class HotelOrderService_Stub implements HotelOrderService{

	@Override
	public ArrayList<HotelOrderVO> getHotelOrderList(String hotelID) {
		// TODO Auto-generated method stub
		ArrayList<HotelOrderVO> orderList=new ArrayList<HotelOrderVO>();
		HotelOrderVO vo1=new HotelOrderVO("201611030001000001","chen",new Date(),OrderState.HASCANCELED);
		HotelOrderVO vo2=new HotelOrderVO("201611030001000002","chen",new Date(),OrderState.NOTEXECUTED);
		HotelOrderVO vo3=new HotelOrderVO("201611030001000003","chen",new Date(),OrderState.UNUSUAL);
		HotelOrderVO vo4=new HotelOrderVO("201611030001000004","chen",new Date(),OrderState.HASREMARKED);
		HotelOrderVO vo5=new HotelOrderVO("201611030001000005","chen",new Date(),OrderState.NOTREMARKED);
		orderList.add(vo1);
		orderList.add(vo2);
		orderList.add(vo3);
		orderList.add(vo4);
		orderList.add(vo5);
		return orderList;
	}

	@Override
	public HotelOrderInfoVO getHotelOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		HotelOrderInfoVO info=new HotelOrderInfoVO("201611030001000005", "chen", 680, "chen","12345678999", new Date(),
				new Date(),  "商务间",BedType.BIGBED, 1,1,Children.EXIST,null,null, new Date(), 
				 OrderState.NOTEXECUTED, "南京绿地洲际酒店","12345678999",new Date());
		return info;
	}

}
