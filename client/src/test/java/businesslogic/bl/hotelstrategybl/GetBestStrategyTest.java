package businesslogic.bl.hotelstrategybl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import vo.hotelstrategyvo.HotelStrVO;
import vo.ordervo.OrderProvidedVO;

/**
 * 获取酒店最佳策略的测试类
 * @author CLL
 * @version 1.0
 */
public class GetBestStrategyTest {
	HotelStrategy hotelStrategy;
	OrderProvidedVO orderProvidedVO;
	
	@Before
	public void setUp() throws Exception {
		hotelStrategy=HotelStrategy.getInstance();
		orderProvidedVO=new OrderProvidedVO("000002", 5, null, new Date(1997, 12, 2), "000005");
	}

	@Test
	public void test() {
		assertEquals(0.5,hotelStrategy.getBestHotelStrategy(orderProvidedVO).getDiscount(),0.01);
	}

}
