package businesslogic.bl.webstrategybl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import util.TradingArea;
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
	}

	@Test
	public void test1() {
		Date[] date=new Date[]{
				new Date(2016, 5, 20),new Date(2016, 11, 30)
		};
		vo1=new WebStrVO(date, 0.5, WebStrategyType.SPECIALTIME);
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALTIME);
	    assertEquals(0.5, webStrVO.getDiscount(),0.01);
	}
	
	@Test
	public void test2() {
		Date[] date=null;
		vo1=new WebStrVO(date, 0.5, WebStrategyType.SPECIALTIME);
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALTIME);
	    assertEquals(0.5, webStrVO.getDiscount(),0.01);
	}
	
	@Test
	public void test3() {
		Map<Integer,Double> tradingAreaStrategy =new HashMap<Integer, Double>();
		vo1=new WebStrVO(tradingAreaStrategy,0.7, WebStrategyType.SPECIALAREA);
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALAREA);
	    assertEquals(0.7, webStrVO.getDiscount(),0.01);
	}
	
	@Test
	public void test4() {
		Map<Integer,Double> tradingAreaStrategy =new HashMap<Integer, Double>();
		vo1=new WebStrVO(tradingAreaStrategy,0.7, WebStrategyType.SPECIALAREA);
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALAREA);
	    assertEquals(0.7, webStrVO.getDiscount(),0.01);
	}
	
	@Test
	public void test5() {
		Map<Integer,Double> tradingAreaStrategy =new HashMap<Integer, Double>();
		vo1=new WebStrVO(tradingAreaStrategy,0.7, WebStrategyType.SPECIALAREA);
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALAREA);
	    assertEquals(0.7, webStrVO.getDiscount(),0.01);
	}
	
	@Test
	public void test6() {
		Map<Integer,Double> tradingAreaStrategy =new HashMap<Integer, Double>();
		vo1=new WebStrVO(tradingAreaStrategy,0.7, WebStrategyType.SPECIALAREA);
		assertEquals(ResultMessage.SUCCESS,webStrategy.confirmWebStrategy(vo1));
		WebStrVO webStrVO=webStrategy.getWebStrategy(WebStrategyType.SPECIALAREA);
	    assertEquals(0.7, webStrVO.getDiscount(),0.01);
	}

}
