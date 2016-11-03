package businesslogic.bl.hotelbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
import vo.hotelvo.HotelBasicInfoVO;
/**
 * 酒店工作人员修改酒店信息的测试类
 * @author csy
 * @version 1.0
 */
public class ModifyHotelInfo {
    HotelBasicInfoVO hotelBasicInfoVO;
	
	@Before
	public void setUp() throws Exception {
		hotelBasicInfoVO=null;
	}

	@Test
	public void test() {
		Hotel hotel=new Hotel();
		assertEquals(hotel.getHotelBasicInfo("0001"),hotelBasicInfoVO);
		assertEquals(hotel.confirmModifyInfo(hotelBasicInfoVO),ResultMessage.SUCCESS);
	}

}
