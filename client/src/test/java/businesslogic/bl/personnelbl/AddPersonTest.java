package businesslogic.bl.personnelbl;
import static org.junit.Assert.assertEquals;

import java.util.Date;

/**
 * 增加人员的测试类
 * @author csy
 * @version 1.0
 */
import org.junit.Before;
import org.junit.Test;

import util.CustomerType;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;

public class AddPersonTest {
	PersonDetailVO personDetailVO1;
	PersonDetailVO personDetailVO2;
	PersonDetailVO personDetailVO3;
	Personnel personnel=Personnel.getInstance();
	@Before
	public void setUp() throws Exception {
		
		personDetailVO1=new PersonDetailVO(null, "小菲菲", "feifei", null, "12345678901",100 , new Date(1997, 4, 14), null, CustomerType.INDIVIDUAL, null, UserType.Customer);
		personDetailVO2=new PersonDetailVO(null, "小俐俐",   "xiaolili", null, "12345678901",0 , null, null, null, "锦江之星大酒店", UserType.HotelWorker);
		personDetailVO3=new PersonDetailVO(null, "XX网站营销人员", "hhhhhhh", null, "12345678901", 0, null, null, null, null,UserType.WebMarketMan);
	}

	@Test
	public void test() {
		assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO1));
		assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO2));
		assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO3));
	}

}
