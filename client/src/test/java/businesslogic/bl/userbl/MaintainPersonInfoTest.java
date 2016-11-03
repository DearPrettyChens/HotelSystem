package businesslogic.bl.userbl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import util.Telephone;
import util.UserType;
/**
 * 维护个人信息的测试类
 * @author csy
 * @version 1.0
 */
import vo.uservo.DetailInfoVO;
public class MaintainPersonInfoTest {
    DetailInfoVO detailInfoVO;
	@Before
	public void setUp() throws Exception {
	      detailInfoVO=new DetailInfoVO("小豆", "12121212121", new ImageIcon(), UserType.Customer, new Date());
	}

	@Test
	public void test() {
		Customer customer=new Customer();
		assertEquals(customer.checkTel(new Telephone("123456")),ResultMessage.FAIL);
		assertEquals(customer.modifyDetailInfo(detailInfoVO),ResultMessage.SUCCESS);
				
	}

}
