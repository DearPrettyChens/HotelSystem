package businesslogic.bl.orderbl;

import static org.junit.Assert.assertEquals;


import java.util.Date;
import vo.ordervo.OrderInfoVO;

import org.junit.Before;
import org.junit.Test;


import vo.ordervo.TypeInfoVO;
import businesslogic.blservice.orderblservice.GenerateOrderService;
/**
 * 
 * GenerateOrder的测试类
 * @author cy
 * @version 1.0
 * 
 */
public class GenerateOrderTest {
	GenerateOrderService genereteOrderService;
	Date time;
	OrderInfoVO orderInfoVO;
	
	
	
	 TypeInfoVO vo;
	 @Before 
	 public void setUp(){
		 
		 genereteOrderService=new GenerateOrderController();
		 
		 
		 
		 
	 }
	 
	 @Test
	 public void test(){
	 
	 
	   assertEquals(genereteOrderService.checkAvailableRoomNumber(null),null);
	   
	   assertEquals(genereteOrderService.checkTelephone("123"),null);
	   assertEquals(genereteOrderService.checkTime(time),null);
	   assertEquals(genereteOrderService.checkUserCredit("123"),null);
	   assertEquals(genereteOrderService.confirmAddOrder(orderInfoVO),null);
	   assertEquals(genereteOrderService.getHotelDetailInfo("123"),null);
	   assertEquals(genereteOrderService.next(orderInfoVO),null);
	   
	  
	  

	 }
}
