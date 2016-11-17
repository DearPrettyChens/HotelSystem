package businesslogic.bl.orderbl;



import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.blservice.orderblservice.ExecuteOrderService;
import vo.ordervo.RemarkVO;

/**
 * 执行订单的测试类
 * @author cy
 * @version 1.0
 * 
 */
public class ExcuteOrderTest {
	ExecuteOrderService ExcuteOrderService;
	 
	
	 RemarkVO remarkVO;
	 Date time;
	 
	 @Before 
	 public void setUp(){
		 
		 ExcuteOrderService=ExecuteOrderController.getInstance();
		 
		 
		 
		 
	 }
	 
	 @Test
	 public void test(){
	 
	 
	   assertEquals(ExcuteOrderService.remarkOrder(remarkVO),null);
	   assertEquals(ExcuteOrderService.setCheckinTime(time, "123"),null);
	   assertEquals(ExcuteOrderService.setCheckoutTime(time, "123"),null);
	   
	
	   
	 
	  

	 }

}
