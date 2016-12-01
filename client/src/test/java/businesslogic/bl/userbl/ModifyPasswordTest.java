package businesslogic.bl.userbl;
/**
 * 修改密码的测试类
 * @author csy
 * @version 1.0
 */
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import util.Password;
import util.ResultMessage;
import vo.uservo.PasswordVO;
public class ModifyPasswordTest {
	User user;
    PasswordVO passwordVO;
	@Before
	public void setUp() throws Exception {
		user =User.getInstance();
	      passwordVO=new PasswordVO("000022", "feifei","小菲菲");
	}

	@Test
	public void test() {
		assertEquals(ResultMessage.Customer, user.login("小菲菲", "feifei"));
		assertEquals(ResultMessage.SUCCESS,user.checkOldPassword( "feifei"));
		assertEquals(ResultMessage.PASSWORDFORMATERROR,user.checkNewPassword(new Password("123")));
		assertEquals(ResultMessage.SUCCESS, user.checkNewPassword(new Password("123456")));
		passwordVO.setPassword("123456");
	    assertEquals(ResultMessage.SUCCESS,user.confirmPassword(passwordVO) );
	}

}
