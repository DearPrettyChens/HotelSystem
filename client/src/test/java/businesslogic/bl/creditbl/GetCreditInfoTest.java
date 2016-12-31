package businesslogic.bl.creditbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
/**
 * 查看信用记录的测试类
 * @author CLL
 * @version 1.0
 */
public class GetCreditInfoTest {
	Credit credit;
	@Before
	public void setUp() throws Exception {
		credit=new Credit("000002");
	}

	@Test
	public void test1() {
		int preCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(preCredit,100);
	}

	@Test
	public void test2() {
		int preCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(preCredit,10);
	}
	
	@Test
	public void test3() {
		int preCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(preCredit,1000);
	}
}
