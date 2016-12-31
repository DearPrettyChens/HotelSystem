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
	public void test1() {
		assertEquals(order.addRemarkInfo(new RemarkVO("201612010001000001","000001",5,"好")),ResultMessage.SUCCESS);
	}

	@Test
	public void test2() {
		assertEquals(order.addRemarkInfo(new RemarkVO("201612010002000001","000002",4,"好")),ResultMessage.SUCCESS);
	}
	
	@Test
	public void test3() {
		assertEquals(order.addRemarkInfo(new RemarkVO("201612010003000001","000003",3,"好")),ResultMessage.SUCCESS);
	}
}
