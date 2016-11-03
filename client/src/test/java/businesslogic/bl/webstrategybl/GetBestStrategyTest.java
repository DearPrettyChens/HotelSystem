package businesslogic.bl.webstrategybl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vo.webstrategyvo.WebStrVO;
/**
 * 获取网站最佳策略的测试类
 * @author CLL
 * @version 1.0
 */
public class GetBestStrategyTest {
	WebStrategyInterface webStrategyInterface;
	WebStrVO vo1;
	WebStrVO vo2;
	@Before
	public void setUp() throws Exception {
		webStrategyInterface=new WebSpecialAreaStrategy();
		vo1=new WebStrVO();
		vo2=new WebStrVO();
	}

	@Test
	public void test() {
		WebStrategy webStrategy=new WebStrategy();
		assertEquals(webStrategy.confirmWebStrategy(webStrategyInterface, vo1),null);
		assertEquals(webStrategy.confirmWebStrategy(webStrategyInterface, vo2),null);
		assertEquals(webStrategy.getWebBestStrategy("0", null, null),null);
	}

}
