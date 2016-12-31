package businesslogic.bl.checkinbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.orderbl.SingleOrder;
import util.BedType;
import util.OrderState;
import vo.checkinvo.CheckinInfoVO;
/**
 * 
 * @author CLL
 *
 */
public class CheckinTest {
	Checkin checkin;
	SingleOrder order;
	@Before
	public void setUp() throws Exception {
		checkin=new Checkin();
	}

	@Test
	public void test1() {
		CheckinInfoVO info=new CheckinInfoVO("chen","123456789123456789","12345678999","201","商务房",
				BedType.BIGBED,new Date(),null,"000002","20161119000002000001");
		checkin.confirmCheckinInfo(info);
		order=new SingleOrder();
		assertEquals(OrderState.NOTREMARKED,order.getOrderInfo("20161119000002000001").
				getState());
	}

	@Test
	public void test2() {
		CheckinInfoVO info=new CheckinInfoVO("wang","123456789123456789","12345678999","201","商务房",
				BedType.BIGBED,new Date(),null,"000004","20161119000002000003");
		checkin.confirmCheckinInfo(info);
		order=new SingleOrder();
		assertEquals(OrderState.NOTREMARKED,order.getOrderInfo("20161119000002000003").
				getState());
	}
	
	@Test
	public void test3() {
		CheckinInfoVO info=new CheckinInfoVO("chen","123456789123456789","12345678999","301","商务房",
				BedType.BIGBED,new Date(),null,"000005","20161119000002000002");
		checkin.confirmCheckinInfo(info);
		order=new SingleOrder();
		assertEquals(OrderState.NOTREMARKED,order.getOrderInfo("20161119000002000002").
				getState());
	}
}
