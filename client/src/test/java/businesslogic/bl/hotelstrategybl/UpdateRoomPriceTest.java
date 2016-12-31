package businesslogic.bl.hotelstrategybl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.hotelstrategybl.mock.MockAvailableRoom;
import businesslogic.bl.hotelstrategybl.mock.MockUser;
import util.ResultMessage;
import vo.hotelstrategyvo.HotelStrVO;

/**
 * 更新酒店房间价格的测试类
 * 
 * @author CLL
 * @version
 */
public class UpdateRoomPriceTest {
	HotelStrategyInterface hotelStrategyInterface;
	HotelStrategy hotelStrategy;
	HotelStrVO vo;

	@Before
	public void setUp() throws Exception {
		hotelStrategy = HotelStrategy.getInstance();

	}

	/**
	 * 在hotel strategy的confirmHotelStrategy里面用了mock，如果要测试两个模块之间是否正确，把那边注释即可
	 */
	@Test
	public void test1() {
		hotelStrategyInterface = HotelBirthStrategy.getInstance();
		vo = new HotelStrVO("000005", 0.5);
		assertEquals(ResultMessage.SUCCESS, hotelStrategy.confirmHotelStrategy(vo));
	}

	@Test
	public void test2() {
		hotelStrategyInterface = HotelAmountStrategy.getInstance();
		vo = new HotelStrVO("000005", 0.7);
		assertEquals(ResultMessage.SUCCESS, hotelStrategy.confirmHotelStrategy(vo));
	}

	@Test
	public void test3() {
		hotelStrategyInterface = HotelEnterpriseStrategy.getInstance();
		vo = new HotelStrVO("000005", 0.9);
		assertEquals(ResultMessage.SUCCESS, hotelStrategy.confirmHotelStrategy(vo));
	}

	@Test
	public void test4() {
		hotelStrategyInterface = HotelSpecialTimeStrategy.getInstance();
		vo = new HotelStrVO("000005", -1);
		assertEquals(ResultMessage.FAIL, hotelStrategy.confirmHotelStrategy(vo));
	}

}
