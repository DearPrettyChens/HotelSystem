package businesslogic.bl.orderbl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.BedType;
import util.Children;
import util.OrderState;
import vo.ordervo.OrderInfoVO;

public class GenerateOrderTest {
	Order order;
	SingleOrder singleOrder;
	@Before
	public void setUp() throws Exception {
		order=new Order();
		singleOrder=new SingleOrder();
	}

	@Test
	public void test() {
		order.confirmAddOrder(new OrderInfoVO("20161119000002000001","000002","000001",
				"chen","chen","12345678999",new Date(),new Date(),new Date(),"",BedType.BIGBED,
				1,1,Children.EXIST,680,null));
		assertEquals(singleOrder.getOrderInfo("12345678999").getState(),OrderState.NOTEXECUTED);
	}

}
