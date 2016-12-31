package businesslogic.bl.orderbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.BedType;
import util.Children;
import util.OrderState;
import util.ResultMessage;
import vo.ordervo.OrderInfoVO;
/**
 * 生成订单的测试类
 * @author CLL
 *
 */
public class GenerateOrderTest {
	Order order;
	SingleOrder singleOrder;
	@Before
	public void setUp() throws Exception {
		singleOrder=new SingleOrder();
	}

	@Test
	public void test1() {
		assertEquals(order.confirmAddOrder(new OrderInfoVO("20161119000002000001","000002","AAAAA","000001","00000",
				"chen","chen","12345678999",new Date(),new Date(),new Date(),new Date(),"",BedType.BIGBED,
				1,1,Children.EXIST,680,OrderState.NOTEXECUTED)),ResultMessage.SUCCESS);
//		assertEquals(singleOrder.getOrderInfo("20161119000002000001").getState(),OrderState.NOTEXECUTED);
	}

	@Test
	public void test2() {
		assertEquals(order.confirmAddOrder(new OrderInfoVO("201611190003000001","000003","AAA","000001","00000",
				"chen","chen","12345678999",new Date(),new Date(),new Date(),new Date(),"",BedType.BIGBED,
				1,1,Children.EXIST,450,OrderState.NOTEXECUTED)),ResultMessage.SUCCESS);
//		assertEquals(singleOrder.getOrderInfo("20161119000002000001").getState(),OrderState.NOTEXECUTED);
	}
	
	@Test
	public void test3() {
		assertEquals(order.confirmAddOrder(new OrderInfoVO("201611190004000001","000004","AAAA","000001","00000",
				"chen","chen","12345678999",new Date(),new Date(),new Date(),new Date(),"",BedType.BIGBED,
				1,1,Children.EXIST,500,OrderState.NOTEXECUTED)),ResultMessage.SUCCESS);
//		assertEquals(singleOrder.getOrderInfo("20161119000002000001").getState(),OrderState.NOTEXECUTED);
	}
}
