package businesslogic.bl.orderbl;

import org.junit.Before;

public class CancelOrderTest {
	SingleOrder order;
	@Before
	public void setUp() throws Exception {
		order=new SingleOrder();
	}

//	@Test
//	public void test() {
//		order.cancelOrderConfirm("20161119000002000001");
//		assertEquals(order.getOrderInfo("20161119000002000001").getState(),OrderState.HASCANCELED);
//	}

}
