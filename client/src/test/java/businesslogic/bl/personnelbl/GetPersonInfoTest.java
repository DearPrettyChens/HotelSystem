package businesslogic.bl.personnelbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.WebMarketManDetailVO;
/**
 * 获得用户信息的测试类
 * @author CLL
 * @version 1.0
 */
public class GetPersonInfoTest {
	PersonDetailVO personDetailVO;
	@Before
	public void setUp() throws Exception {
		personDetailVO=new WebMarketManDetailVO(null,"chen",null,null,"000001");
		
	}

	@Test
	public void test() {
		Personnel personnel=new Personnel();
		assertEquals(personnel.addPerson(personDetailVO),null);
		WebMarketManDetailVO vo=(WebMarketManDetailVO) personnel.getPersonDetail("000001");
		//assertEquals(vo.getName(),"chen");
	}

}
