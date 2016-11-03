package businesslogic.bl.personnelbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.WebMarketManDetailVO;

public class AddPersonTest {
	PersonDetailVO personDetailVO1;
	PersonDetailVO personDetailVO2;
	PersonDetailVO personDetailVO3;
	@Before
	public void setUp() throws Exception {
		personDetailVO1=new WebMarketManDetailVO(null,"chen",null,null,"000001");
		personDetailVO2=new WebMarketManDetailVO(null,"wang",null,null,"000002");
		personDetailVO3=new WebMarketManDetailVO(null,"chen",null,null,"000003");
	}

	@Test
	public void test() {
		Personnel personnel=new Personnel();
		assertEquals(personnel.addPerson(personDetailVO1),null);
		assertEquals(personnel.addPerson(personDetailVO2),null);
		//等实现了check方法再测
		//assertEquals(personnel.addPerson(personDetailVO3),ResultMessage.FAIL);
	}

}
