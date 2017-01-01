package businesslogic.bl.orderbl.MockOrder;

import businesslogic.bl.creditbl.*;
import util.ResultMessage;
import vo.creditvo.CreditVO;

/**
 * Credit的mock类
 * @author cy
 * @version 1.0
 * 
 */
public class MockCredit{



	public int mockcredit=0;
	
	
	public ResultMessage addCredit(CreditVO creditVO) {
        mockcredit ++;
        
		return null;
	}

	
	public ResultMessage cutCredit(CreditVO creditVO) {
		mockcredit--;
		
		return null;
	}

	
	

}
