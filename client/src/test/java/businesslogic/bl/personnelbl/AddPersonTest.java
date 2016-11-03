package businesslogic.bl.personnelbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vo.personnelvo.PersonDetailVO;

public class AddPersonTest {
	PersonDetailVO personDetailVO1;
	PersonDetailVO personDetailVO2;
	PersonDetailVO personDetailVO3;
	@Before
	public void setUp() throws Exception {
		personDetailVO1=new PersonDetailVO(null,"chen",null,null,0, null, 0, "000001", null);
		personDetailVO2=new PersonDetailVO(null,"wang",null,null,0, null, 0, "000002", null);
		personDetailVO3=new PersonDetailVO(null,"chen",null,null,0, null, 0, "000003", null);
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
