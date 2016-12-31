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
	public void test1() {
		assertEquals(checkin.getCheckinInfo("123456789123456789").getCostumername(),"chen");
		assertEquals(checkin.getCheckinInfo("123456789123456789").getBedtype(),BedType.BIGBED);
	}

	@Test
	public void test2() {
		assertEquals(checkin.getCheckinInfo("123456789123456777").getCostumername(),"chen");
		assertEquals(checkin.getCheckinInfo("123456789123456777").getBedtype(),BedType.FAMILYBED);
	}
	
	@Test
	public void test3() {
		assertEquals(checkin.getCheckinInfo("123456789123456888").getCostumername(),"wang");
		assertEquals(checkin.getCheckinInfo("123456789123456888").getBedtype(),BedType.TWOBEDS);
	}
}
