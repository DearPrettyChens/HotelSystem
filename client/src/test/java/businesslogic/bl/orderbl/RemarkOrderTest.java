package businesslogic.bl.orderbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.hotelbl.Hotel;
import util.ResultMessage;
import vo.ordervo.RemarkVO;
/**
 * 评价订单的测试类
 * @author CLL
 *
 */
public class RemarkOrderTest {
	HotelInfoOrderService order;
	@Before
	public void setUp() throws Exception {
		order=new Hotel();
	}

	@Test
	public void test() {
		assertEquals(order.addRemarkInfo(new RemarkVO()),ResultMessage.SUCCESS);
	}

}
