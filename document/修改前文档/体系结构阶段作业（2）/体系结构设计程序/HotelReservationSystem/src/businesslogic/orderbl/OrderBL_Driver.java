package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;

import blservice.orderblservice.OrderBLService;
import vo.ordervo.OrderInfoVO;
import vo.ordervo.OrderVO;
import vo.ordervo.RemarkVO;
import vo.ordervo.TypeInfoVO;

/**
 * 模拟订单策略模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class OrderBL_Driver {
    public void drive(OrderBLService stub) {
		OrderInfoVO orderInfoVO=stub.getOrderInfo("201610120001000001");
		ArrayList<OrderVO> orderVOs=stub.getOrderList(new TypeInfoVO());
		System.out.println(stub.checkUserCredit("000001"));
	    System.out.println(stub.checkTelephone("12345678900"));
        System.out.println(stub.checkTime(new Date()));   
        System.out.println(stub.confirmAddOrder(orderInfoVO));
        System.out.println(stub.cancelOrderConfirm("201610120001000001"));
        System.out.println(stub.remarkOrder(new RemarkVO()));
        System.out.println(stub.getPrice("201610120001000001"));
        System.out.println(stub.setCheckinTime(new Date()));
        System.out.println(stub.setCheckoutTime(new Date()));
        System.out.println(stub.setReturnCredit(100));
    }
	public static void main(String[] args) {
		new OrderBL_Driver().drive(new OrderBL_Stub());

	}

}
