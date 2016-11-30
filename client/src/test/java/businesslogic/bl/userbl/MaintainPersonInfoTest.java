package businesslogic.bl.userbl;
import static org.junit.Assert.*;

import java.util.Date;

/**
 * 维护个人信息的测试类
 * @author csy
 * @version 1.0
 */
import org.junit.Before;
import org.junit.Test;

import util.CustomerType;
import util.ResultMessage;
import util.Telephone;
import util.UserType;
import vo.personnelvo.PersonDetailVO;
import vo.uservo.BasicInfoVO;
public class MaintainPersonInfoTest {
    PersonDetailVO personDetailVO;
    Customer customer=Customer.getInstance();
	@Before
	public void setUp() throws Exception {
		personDetailVO=new PersonDetailVO(null, "小菲菲", "feifei", null, "12345678901",100 , new Date(1997, 4, 14), null, CustomerType.INDIVIDUAL, null, UserType.Customer);
	}

	@Test
	public void test() {
        BasicInfoVO basicInfoVO=customer.getBasicInfo("000001");
        assertEquals("小菲菲", basicInfoVO.getUserName());
		assertEquals(ResultMessage.FAIL,customer.checkTel(new Telephone("123456")));
		assertEquals(ResultMessage.SUCCESS,customer.modifyDetailInfo(personDetailVO));
		assertEquals(1, customer.getGrade("000002"));		
	}

}
