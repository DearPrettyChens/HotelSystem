package businesslogic.bl.webstrategybl;

import static org.junit.Assert.*;

import java.util.Calendar;
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
	
	@Before
	public void setUp() throws Exception {
		webStrategy=webStrategy.getInstance();
		}

	@Test
	public void test1() {
		WebProvidedVO vo1=new WebProvidedVO("1", TradingArea.XINJIEKOU, new Date(1997,4,14));
		assertEquals(0.5,webStrategy.getWebBestStrategy(vo1).getDiscount(),0.01);
	}
	@Test
	public void test2() {
		WebProvidedVO vo1=new WebProvidedVO("100", TradingArea.HUNANLU, new Date(1997,4,14));
		assertEquals(0.4,webStrategy.getWebBestStrategy(vo1).getDiscount(),0.01);
	}
	@Test
	public void test3() {
		WebProvidedVO vo1=new WebProvidedVO("0", TradingArea.XINJIEKOU, new Date(1997,5,14));
		assertEquals(0.8,webStrategy.getWebBestStrategy(vo1).getDiscount(),0.01);
	}
	@Test
	public void test4() {
		WebProvidedVO vo1=new WebProvidedVO("50", TradingArea.XINJIEKOU, new Date(1997,3,7));
		assertEquals(0.9,webStrategy.getWebBestStrategy(vo1).getDiscount(),0.01);
	}
	@Test
	public void test5() {
		WebProvidedVO vo1=new WebProvidedVO("0", TradingArea.XINJIEKOU, new Date(1997,4,14));
		assertEquals(0.6,webStrategy.getWebBestStrategy(vo1).getDiscount(),0.01);
	}
	@Test
	public void test6() {
		WebProvidedVO vo1=new WebProvidedVO("1", TradingArea.XINJIEKOU, new Date(1997,4,14));
		assertEquals(0.5,webStrategy.getWebBestStrategy(vo1).getDiscount(),0.01);
	}
}
