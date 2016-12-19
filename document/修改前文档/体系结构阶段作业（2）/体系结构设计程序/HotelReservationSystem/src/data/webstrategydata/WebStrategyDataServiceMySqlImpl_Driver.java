package data.webstrategydata;

import common.WebStrategyType;
import dataservice.webstrategydataservice.WebStrategyDataService;
import po.GradeRulePO;
import po.WebStrPO;

/**
 * 模拟webstrategy模块逻辑层和数据层交互的实现
 * 
 * @author csy
 * @version 1.0
 * 
 */
public class WebStrategyDataServiceMySqlImpl_Driver {

	public void drive(WebStrategyDataService stub) {
           GradeRulePO gradeRulePO=stub.getGradeRule();
           WebStrPO webStrPO=stub.getWebStrategy(WebStrategyType.SPECIALAREA);
	       System.out.println(stub.setGradeRule(gradeRulePO));
	       System.out.println(stub.setWebStrategy(webStrPO));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new WebStrategyDataServiceMySqlImpl_Driver().drive(new WebStrategyDataServiceMySqlImpl_Stub());
	}

}
