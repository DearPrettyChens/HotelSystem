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


	@Test
	public void test1() {
		PersonDetailVO personDetailVO1=new PersonDetailVO(null, "小俐俐",   "xiaolili", null, "12345678901",0 , null, null, null, "锦江之星大酒店", UserType.HotelWorker);
	   	assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO1));
		
	}
	@Test
	public void test2() {
		PersonDetailVO personDetailVO2=new PersonDetailVO(null, "小菲菲", "feifei", null, "12345678901",0 , new Date(1997, 4, 14), null, CustomerType.INDIVIDUAL, null, UserType.Customer);
			assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO2));
	}
	@Test
	public void test3() {
		PersonDetailVO personDetailVO3=new PersonDetailVO(null, "南京大学", "nju", null, "02588888888",100 , null, "南京大学", CustomerType.ENTERPRISE, null, UserType.Customer);
		assertEquals(ResultMessage.SUCCESS,personnel.addPerson(personDetailVO3));
	}
	@Test
	public void test4() {
		PersonListVO personListVO=personList.getPersonList(UserType.HotelWorker, "小俐俐").get(0);
		PersonDetailVO personDetailVO= personnel.getPersonDetail("000014");
		assertEquals("锦江之星大酒店", personListVO.getHotelName());
		assertEquals("小俐俐",personDetailVO.getName());
	}
	@Test
	public void test5() {
		PersonListVO personListVO=personList.getPersonList(UserType.HotelWorker, "小菲菲").get(0);
		PersonDetailVO personDetailVO= personnel.getPersonDetail("000025");
		assertEquals("小菲菲",personDetailVO.getName());
	}
}
