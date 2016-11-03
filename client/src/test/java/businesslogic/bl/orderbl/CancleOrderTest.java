package businesslogic.bl.orderbl;


import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import vo.ordervo.RemarkVO;
import businesslogic.blservice.orderblservice.CancleOrderService;;

/**
 * 撤销订单的测试类
 * @author cy
 * @version 1.0
 * 
 */
public class CancleOrderTest {
	CancleOrderService CancleOrderService;
	 
	
	 RemarkVO remarkVO;
	 Date time;
	 
	 @Before 
	 public void setUp(){
		 
		 CancleOrderService=new CancleOrderController();
		 
		 
		 
		 
	 }
	 
	 @Test
	 public void test(){
	 
	 
	   assertEquals(CancleOrderService.cancelOrderConfirm("123"),null);
	   assertEquals(CancleOrderService.setReturnCredit(0),null);
	   
	   
	
	   
	 
	  

	 }


}
