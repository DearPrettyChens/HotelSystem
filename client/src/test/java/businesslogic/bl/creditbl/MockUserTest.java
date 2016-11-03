package businesslogic.bl.creditbl;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.bl.creditbl.mock.MockUser;

public class MockUserTest {
	
	@Test
	public void testGetCreditInfo() {
        Credit ct = new Credit();
        MockUser mu = new MockUser();
        assertEquals(ct.getCreditInfo(mu.getUserID(null)),null);
	}
}
