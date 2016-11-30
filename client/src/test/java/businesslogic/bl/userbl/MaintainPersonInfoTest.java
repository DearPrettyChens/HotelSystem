package businesslogic.bl.userbl;
import java.util.Date;

/**
 * 维护个人信息的测试类
 * @author csy
 * @version 1.0
 */
import org.junit.Before;
import org.junit.Test;

import util.CustomerType;
import util.UserType;
import vo.uservo.DetailInfoVO;
public class MaintainPersonInfoTest {
    DetailInfoVO detailInfoVO;
    Customer customer=Customer.getInstance();
	@Before
	public void setUp() throws Exception {
	      detailInfoVO=new DetailInfoVO( "小菲菲", "12345678901",null ,UserType.Customer, new Date(1997, 4, 14), "000001", CustomerType.INDIVIDUAL);
	}

	@Test
	public void test() {
//		Personnel customer=Personnel.getInstance();
//		assertEquals(customer.checkTel(new Telephone("123456")),ResultMessage.FAIL);
//		assertEquals(customer.modifyDetailInfo(detailInfoVO),ResultMessage.SUCCESS);
				
	}

}
