package businesslogic.bl.orderbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
/**
 * 获得订单列表的测试类
 * @author CLL
 *
 */
public class GetOrderListTest {
	OrderList orderList;
	@Before
	public void setUp() throws Exception {
		orderList=new OrderList();
	}

	@Test
	public void test1() {
		assertEquals(orderList.getOrderList("000005").get(0).getCustomerName(),"chen");
	}

	@Test
	public void test2() {
		assertEquals(orderList.getOrderList("000002").get(0).getCustomerName(),"chen");
	}
	
	@Test
	public void test3() {
		assertEquals(orderList.getOrderList("000001").get(0).getCustomerName(),"chen");
	}
}
