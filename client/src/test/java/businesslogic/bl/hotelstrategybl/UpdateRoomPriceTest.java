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
 * @author CLL
 * @version
 */
public class UpdateRoomPriceTest {
	HotelStrategyInterface hotelStrategyInterface;
	HotelStrategy hotelStrategy;
	HotelStrVO vo1;
	@Before
	public void setUp() throws Exception {
		hotelStrategy=HotelStrategy.getInstance();
		hotelStrategyInterface= HotelBirthStrategy.getInstance();
		vo1=new HotelStrVO("000005", 0.5);
	}

	/**
	 * 在hotel strategy的confirmHotelStrategy里面用了mock，如果要测试两个模块之间是否正确，把那边注释即可
	 */
	@Test
	public void test() {
		assertEquals(ResultMessage.SUCCESS,hotelStrategy.confirmHotelStrategy(vo1));
	}

}
