package businesslogic.bl.personnelbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.CustomerType;
import util.ResultMessage;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.personnelvo.PersonListVO;
/**
 * 获得用户信息的测试类
 * @author CLL
 * @version 1.0
 */
public class GetPersonInfoTest {
	Personnel personnel=Personnel.getInstance();
	PersonList personList = PersonList.getInstance();
	PersonDetailVO personDetailVO1;//用于检测获取的列表信息
	PersonDetailVO personDetailVO2;//用于检测获取的详细信息
	@Before
	public void setUp() throws Exception {
		personDetailVO1=new PersonDetailVO(null, "小俐俐",   "xiaolili", null, "12345678901",0 , null, null, null, "锦江之星大酒店", UserType.HotelWorker);
		personDetailVO2=new PersonDetailVO(null, "小菲菲", "feifei", null, "12345678901",100 , new Date(1997, 4, 14), null, CustomerType.INDIVIDUAL, null, UserType.Customer);
	}

	@Test
	public void test() {
		assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO1));
		assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO2));
		PersonListVO vo1=personList.getPersonList(UserType.HotelWorker, "小俐俐").get(0);
		PersonDetailVO vo2= personnel.getPersonDetail("000002");
		assertEquals("锦江之星大酒店", vo1.getHotelName());
		assertEquals("小菲菲",vo2.getName());
	}

}
