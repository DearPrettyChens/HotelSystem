package businesslogic.bl.availableroombl;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.availableroombl.mock.MockUser;
public class AvailableRoomGetUserIDTest {

	@Test
	public void testConfirmAvailableRoomInfo(){
		AvailableRoom ar = new AvailableRoom();
		MockUser mu = new MockUser();
		assertEquals(ar.getAvailableRoomInfo(mu.getUserID()),null);
	}
	
}
