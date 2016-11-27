package businesslogic.bl.checkinbl;

import org.junit.Before;

import businesslogic.bl.orderbl.SingleOrder;
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

//	@Test
//	public void test() {
//		CheckinInfoVO info=new CheckinInfoVO("chen","123456789123456789","12345678999","201","商务房",
//				BedType.BIGBED,new Date(),null,"000002","20161119000002000001");
//		checkin.confirmCheckinInfo(info);
//		order=new SingleOrder();
//		assertEquals(OrderState.NOTREMARKED,order.getOrderInfo("20161119000002000001").
//				getState());
//	}

}
