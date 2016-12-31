package businesslogic.bl.userbl;
import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Before;
import org.junit.Test;

import util.CustomerType;
import util.ResultMessage;
import util.Telephone;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.uservo.BasicInfoVO;

/**
 * 维护个人信息的测试类
 * @author csy
 * @version 1.0
 */
public class MaintainPersonInfoTest {
    PersonDetailVO personDetailVO;
    Customer customer=Customer.getInstance();
	@Before
	public void setUp() throws Exception {
		personDetailVO=new PersonDetailVO("000022", "小菲菲", "feifei", null, "12345678901",100 , new Date(1997, 4, 14), null, CustomerType.INDIVIDUAL, null, UserType.Customer);
	}

	@Test
	public void test1() {
        BasicInfoVO basicInfoVO=customer.getBasicInfo("000022");
        assertEquals("小菲菲", basicInfoVO.getUserName());
	}
	@Test
	public void test2() {
        BasicInfoVO basicInfoVO=customer.getBasicInfo("000022");
		assertEquals(ResultMessage.FAIL,customer.checkTel(new Telephone("123456")));
	}
	@Test
	public void test3() {
        BasicInfoVO basicInfoVO=customer.getBasicInfo("000022");
		assertEquals(ResultMessage.SUCCESS,customer.modifyDetailInfo(personDetailVO));
	}
	@Test
	public void test4() {
        BasicInfoVO basicInfoVO=customer.getBasicInfo("000022");
		assertEquals(1, customer.getGrade("000022"));		
	}
	
}
