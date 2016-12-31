package businesslogic.bl.creditbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import util.ResultMessage;
/**
 * 充值信用的测试类
 * @author CLL
 * @version 1.0
 */
public class DepositCreditTest {
	Credit credit;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test1() {
		credit=new Credit("000003");
		int preCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(ResultMessage.SUCCESS, credit.confirmCreditDeposit(20, "000003"));
		int nowCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(preCredit+10*100,nowCredit);
	}

	@Test
	public void test2() {
		credit=new Credit("000002");
		int preCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(ResultMessage.SUCCESS, credit.confirmCreditDeposit(10, "000002"));
		int nowCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(preCredit+10*100,nowCredit);
	}
	
	@Test
	public void test3() {
		credit=new Credit("000004");
		int preCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(ResultMessage.SUCCESS, credit.confirmCreditDeposit(50, "000004"));
		int nowCredit=credit.getUserCreditInfoList().getCredit();
		assertEquals(preCredit+10*100,nowCredit);
	}
}
