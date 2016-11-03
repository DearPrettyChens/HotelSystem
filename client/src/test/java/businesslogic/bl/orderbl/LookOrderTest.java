package businesslogic.bl.orderbl;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import businesslogic.blservice.orderblservice.LookOrderService;


import vo.ordervo.TypeInfoVO;
/**
 * 查找订单的测试类
 * @author cy
 * @version 1.0
 * 
 */
public class LookOrderTest {
	 LookOrderService LookOrderService;
	 TypeInfoVO vo;
	 @Before 
	 public void setUp(){
		 
		 LookOrderService=new LookOrderController();
		 
		 
		 
	 }
	 
	 @Test
	 public void test(){
	 
	 
	   assertEquals(LookOrderService.getOrderInfo("123"),null);
	   
	   assertEquals(LookOrderService.getOrderList(vo),null);
	 
	  

	 }
}
