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
		}

	@Test
	public void test1() {
		orderProvidedVO=new OrderProvidedVO("000002", 5, null, new Date(1997, 12, 2), "000001");
		assertEquals(0.5,hotelStrategy.getBestHotelStrategy(orderProvidedVO).getDiscount(),0.01);
	}
	@Test
	public void test2() {
		orderProvidedVO=new OrderProvidedVO("000012", 5, null, new Date(), "000001");
		assertEquals(0.6,hotelStrategy.getBestHotelStrategy(orderProvidedVO).getDiscount(),0.01);
	}
	@Test
	public void test3() {
		orderProvidedVO=new OrderProvidedVO("000025", 0, null, null,null);
		assertEquals(1,hotelStrategy.getBestHotelStrategy(orderProvidedVO).getDiscount(),0.01);
	}
	@Test
	public void test4() {
		orderProvidedVO=new OrderProvidedVO("000032", 5, null,null, "000002");
		assertEquals(1,hotelStrategy.getBestHotelStrategy(orderProvidedVO).getDiscount(),0.01);
	}
	@Test
	public void test5() {
		orderProvidedVO=new OrderProvidedVO("000011", 5, "nju", null, "000002");
		assertEquals(0.3,hotelStrategy.getBestHotelStrategy(orderProvidedVO).getDiscount(),0.01);
	}

}
