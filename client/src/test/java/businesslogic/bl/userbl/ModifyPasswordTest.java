package businesslogic.bl.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import util.Password;
import util.ResultMessage;
import vo.uservo.PasswordVO;

/**
 * 修改密码的测试类
 * @author csy
 * @version 1.0
 */
public class ModifyPasswordTest {
	User user;
    PasswordVO passwordVO;
	@Before
	public void setUp() throws Exception {
		user =User.getInstance();
	     
	}

	@Test
	public void test1() {
		passwordVO=new PasswordVO("000022", "feifei","小菲菲");
		assertEquals(ResultMessage.Customer, user.login("小菲菲", "feifei"));
	    passwordVO.setPassword("feifei");
	    assertEquals(ResultMessage.SUCCESS, user.confirmPassword(passwordVO));
	}
	@Test
	public void test2() {
		passwordVO=new PasswordVO("000022", "feifei","小菲菲");
		assertEquals(ResultMessage.Customer, user.login("小菲菲", "feifei"));
		assertEquals(ResultMessage.SUCCESS,user.checkOldPassword( "feifei"));

	}
	@Test
	public void test3() {
		passwordVO=new PasswordVO("000022", "feifei","小菲菲");
		assertEquals(ResultMessage.Customer, user.login("小菲菲", "feifei"));
	}
	@Test
	public void test4() {
		passwordVO=new PasswordVO("000022", "feifei","小菲菲");
		assertEquals(ResultMessage.Customer, user.login("小菲菲", "feifei"));
		passwordVO.setPassword("123456");
	    assertEquals(ResultMessage.SUCCESS,user.confirmPassword(passwordVO) );
	    assertEquals(ResultMessage.SUCCESS, user.checkNewPassword(new Password("feifei")));
	}
}
