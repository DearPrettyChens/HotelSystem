package businesslogic.bl.userbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import util.Password;
import util.ResultMessage;
/**
 * 修改密码的测试类
 * @author csy
 * @version 1.0
 */
import vo.uservo.PasswordVO;
public class ModifyPassword {
   /* PasswordVO passwordVO;
	@Before
	public void setUp() throws Exception {
	      passwordVO=new PasswordVO("000001", "123456","小豆");
	}

	@Test
	public void test() {
		User user =User.getInstance();
		assertEquals(user.checkOldPassword( "123456"),ResultMessage.SUCCESS);
		assertEquals(user.checkNewPassword(new Password("123")),ResultMessage.PASSWORDFORMATERROR);
	    assertEquals(user.confirmPassword(passwordVO), ResultMessage.SUCCESS);
	}*/

}
