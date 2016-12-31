package businesslogic.bl.checkinbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import businesslogic.bl.orderbl.SingleOrder;
import util.BedType;
/**
 * 获得酒店住房信息的测试类
 * @author CLL
 *
 */
public class GetCheckinInfoTest {
	Checkin checkin;
	SingleOrder order;
	@Before
	public void setUp() throws Exception {
		checkin=new Checkin();
	}		

	@Test
	public void test() {
		assertEquals(checkin.getCheckinInfo("123456789123456789").getCostumername(),"chen");
		assertEquals(checkin.getCheckinInfo("123456789123456789").getBedtype(),BedType.BIGBED);
	}

}
