package businesslogic.bl.checkinbl;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.checkinvo.CheckinInfoVO;

public class MockUserTest {
	@Test
	public void testGetOrderInfo() {
		Checkin ci = new Checkin("0001");
		assertEquals(ci.getOrderInfo("0000"),null);
	}
	@Test
	public void testConfirmCheckinInfo() {
		Checkin ci = new Checkin("0001");
		assertEquals(ci.confirmCheckinInfo(new CheckinInfoVO()),null);
	}
	@Test
	public void testConfirmCheckoutInfo() {
		Checkin ci = new Checkin("00001");
		assertEquals(ci.confirmCheckoutInfo(new CheckinInfoVO()),null);
	}
	
}
