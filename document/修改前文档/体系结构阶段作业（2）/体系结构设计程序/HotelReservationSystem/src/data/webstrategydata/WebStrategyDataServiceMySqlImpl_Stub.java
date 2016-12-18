package data.webstrategydata;

import java.util.ArrayList;

import common.ResultMessage;
import common.Strategy;
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
public class WebStrategyDataServiceMySqlImpl_Stub implements WebStrategyDataService {

	@Override
	public void initial() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GradeRulePO getGradeRule() {
		// TODO Auto-generated method stub
		return new GradeRulePO(100);
	}

	@Override
	public WebStrPO getWebStrategy(WebStrategyType type) {
		// TODO Auto-generated method stub
		return new WebStrPO(new ArrayList<Strategy>());
	}

	@Override
	public ResultMessage setGradeRule(GradeRulePO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setWebStrategy(WebStrPO po) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	

}
