package data.datahelper;

import po.CreditInfoPO;
import po.CreditPO;
import util.ResultMessage;

public interface CreditDataHelper {
	public ResultMessage setCredit(CreditPO po);

	public CreditInfoPO getCreditInfo(String customerID);
}
