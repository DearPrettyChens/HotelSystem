package businesslogic.bl.checkinbl;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.checkinvo.CheckinInfoVO;

public class MockAvailableRoomTest {

	@Test
	public void testConfirmCheckoutInfo() {
		Checkin ci = new Checkin();
		assertEquals(ci.confirmCheckoutInfo(new CheckinInfoVO()),null);
	}

}
