package businesslogic.bl.searchhotelbl.SearchHotelmock;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.OrderListPO;
import util.OrderState;
import vo.ordervo.OrderListVO;
import vo.ordervo.TypeInfoVO;

public class MockOrderList {
	
	public ArrayList<OrderListVO> getOrderList(TypeInfoVO vo){
		ArrayList<OrderListVO> orderListVOs=new ArrayList<OrderListVO>();
		
		OrderState state=OrderState.HASREMARKED;
		OrderListVO orderListVO=new OrderListVO("20161119000002000001", "000001", "锦江之星大酒店", "xx", new Date(), state, null);
		orderListVOs.add(orderListVO);
		return orderListVOs;
	}	
}
