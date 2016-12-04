package presentation.ui.orderui.distributecontroller;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.blservice.orderblservice.LookOrderService;
import po.OrderInfoPO;
import po.OrderListPO;
import util.BedType;
import util.Children;
import util.OrderState;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

public class LookOrderService_Stub implements LookOrderService{

	@Override
	public OrderInfoVO getOrderInfo(String orderID) {
		// TODO Auto-generated method stub
		OrderInfoPO po=new OrderInfoPO("000001", orderID, "chen", "chen", "12345678999", 
				"南京绿地洲际酒店", "000002", "12345678999", "商务间", BedType.BIGBED, 1,
				new Date(), 1, Children.EXIST, false, new Date(), new Date(), new Date(), new Date(), new Date(), 685, OrderState.HASREMARKED, null);
		return new OrderInfoVO(po);
	}

	@Override
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO typeInfoVO) {
		// TODO Auto-generated method stub
		ArrayList<OrderListVO> vos=new ArrayList<OrderListVO>();
		OrderListPO po1=new OrderListPO("201611030001000001","","南京金鹰国际大酒店","","chen",new Date(),OrderState.NOTEXECUTED);
		vos.add(new OrderListVO(po1));
		OrderListPO po2=new OrderListPO("201611030001000001",null,"南京金鹰国际大酒店",null,"chen",new Date(),OrderState.NOTEXECUTED);
		vos.add(new OrderListVO(po2));
		OrderListPO po3=new OrderListPO("201611030001000001",null,"南京金鹰国际大酒店",null,"chen",new Date(),OrderState.NOTEXECUTED);
		vos.add(new OrderListVO(po3));
		OrderListPO po4=new OrderListPO("201611030001000001",null,"南京金鹰国际大酒店",null,"chen",new Date(),OrderState.NOTEXECUTED);
		vos.add(new OrderListVO(po4));
		OrderListPO po5=new OrderListPO("201611030001000001",null,"南京金鹰国际大酒店",null,"chen",new Date(),OrderState.NOTEXECUTED);
		vos.add(new OrderListVO(po5));
		return vos;
	}

}
