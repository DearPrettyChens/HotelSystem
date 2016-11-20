package businesslogic.bl.checkinbl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.orderbl.SingleOrder;
import util.BedType;
import util.OrderState;
import vo.checkinvo.CheckinInfoVO;

/*public class CheckinTest {
	Checkin checkin;
	SingleOrder order;
	@Before
	public void setUp() throws Exception {
		checkin=new Checkin("000002");
	}

	@Test
	public void test() {
		CheckinInfoVO info=new CheckinInfoVO("chen","000001","12345678999","201","商务房",
				BedType.BIGBED,new Date(),null,"000002","20161119000002000001");
		checkin.confirmCheckinInfo(info);
		assertEquals(OrderState.NOTREMARKED,order.getOrderInfo("20161119000002000001").
				getState());
	}

}*/
