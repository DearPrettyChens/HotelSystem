package businesslogic.bl.webstrategybl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import util.WebStrategyType;
import vo.webstrategyvo.WebStrVO;

/**
 * 修改网站营销策略的测试类
 * @author CLL
 * @version 1.0
 */
public class ModifyStrategyTest {
	WebStrategy webStrategy;
	WebStrVO vo1;

	@Before
	public void setUp() throws Exception {
		webStrategy=WebStrategy.getInstance();
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		vo1=new WebStrVO(date, 0.5, WebStrategyType.SPECIALTIME);
	}

	@Test
	public void test() {
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALTIME);
	    assertEquals(0.5, webStrVO.getDiscount(),0.01);
	}

}
