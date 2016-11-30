package businesslogic.bl.webstrategybl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.TradingArea;
import vo.webstrategyvo.WebProvidedVO;
import vo.webstrategyvo.WebStrVO;
/**
 * 获取网站最佳策略的测试类
 * @author Csy
 * @version 1.0
 */
public class GetBestStrategyTest {
	WebStrategy webStrategy;
	WebStrVO vo1;
	WebStrVO vo2;
	@Before
	public void setUp() throws Exception {
		webStrategy=webStrategy.getInstance();
		vo1=new WebStrVO();
		vo2=new WebStrVO();
	}

	@Test
	public void test() {
		WebProvidedVO webProvidedVO=new WebProvidedVO("1", TradingArea.XINJIEKOU, new Date(1997,4,14));
		assertEquals(0.5,webStrategy.getWebBestStrategy(webProvidedVO).getDiscount(),0.01);
	}

}
