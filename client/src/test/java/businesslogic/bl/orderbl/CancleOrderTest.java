package businesslogic.bl.orderbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import vo.ordervo.RemarkVO;
import businesslogic.blservice.orderblservice.CancleOrderService;
import util.ResultMessage;;

/**
 * 撤销订单的测试类
 * 
 * @author cy
 * @version 1.0
 * 
 */
public class CancleOrderTest {
	CancleOrderService cancleOrderService;

	RemarkVO remarkVO;
	Date time;

	@Before
	public void setUp() {

		cancleOrderService = CancleOrderController.getInstance();
	}

	@Test
	public void test() {
		assertEquals(cancleOrderService.cancelOrderConfirm(123), ResultMessage.SUCCESS);
		assertEquals(cancleOrderService.setReturnCredit("0"), ResultMessage.SUCCESS);

	}

}
