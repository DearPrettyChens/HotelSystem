package data.orderdata;

import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import po.CheckTimePO;
import po.OrderInfoPO;
import po.OrderListPO;
import po.OrderStatePO;
import po.RemarkPO;

/**
 * 模拟order模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class OrderDataServiceMySqlImpl_Driver {

	public void drive(OrderDataService stub) {
         OrderInfoPO orderInfoPO=stub.getOrderInfo("201610120001000001");
         ArrayList<OrderListPO> orderListPOs=stub.getOrderList("");
         System.out.println(stub.addOrderState(new OrderStatePO()));
         System.out.println(stub.addOrder(orderInfoPO));
         System.out.println(stub.setOrderRemark(new RemarkPO()));
         System.out.println(stub.setCheckintime(new CheckTimePO()));
         System.out.println(stub.setCheckouttime(new CheckTimePO()));
       
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new OrderDataServiceMySqlImpl_Driver().drive(new OrderDataServiceMySqlImpl_Stub());
	}

}
