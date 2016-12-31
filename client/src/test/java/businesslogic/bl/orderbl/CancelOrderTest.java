package businesslogic.bl.orderbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import util.OrderState;
/**
 * 撤销订单的测试类
 * @author CLL
 *
 */
public class CancelOrderTest {
	SingleOrder order;
	@Before
	public void setUp() throws Exception {
		order=new SingleOrder();
	}

	@Test
	public void test1() {
		order.cancelOrderConfirm("20161119000002000001");
		assertEquals(order.getOrderInfo("20161119000002000001").getState(),OrderState.HASCANCELED);
	}

	@Test
	public void test2() {
		order.cancelOrderConfirm("20161119000002000002");
		assertEquals(order.getOrderInfo("20161119000002000002").getState(),OrderState.HASCANCELED);
	}
	
	@Test
	public void test3() {
		order.cancelOrderConfirm("20161119000002000003");
		assertEquals(order.getOrderInfo("20161119000002000003").getState(),OrderState.HASCANCELED);
	}
}
