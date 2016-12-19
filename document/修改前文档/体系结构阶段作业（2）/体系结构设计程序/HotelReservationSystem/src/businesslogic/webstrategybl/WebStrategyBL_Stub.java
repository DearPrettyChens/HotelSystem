package businesslogic.webstrategybl;

import java.util.Date;

import blservice.webstrategyblservice.WebStrategyBLService;
import common.ResultMessage;
import common.TradingArea;
import common.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebStrVO;

/**
 * 模拟网站营销策略模块界面层和逻辑层交互的实现
 * @author csy
 * @version 1.0
 * 
 */
public class WebStrategyBL_Stub implements WebStrategyBLService{

	@Override
	public WebBestStrVO getWebBestStrategy(String credit, TradingArea area, Date time) {
		// TODO Auto-generated method stub
		return new WebBestStrVO();
	}

	@Override
	public GradeRuleVO getGradeRule() {
		// TODO Auto-generated method stub
		return new GradeRuleVO();
	}

	@Override
	public WebStrVO getWebStrategy(WebStrategyType type) {
		// TODO Auto-generated method stub
		return new WebStrVO();
	}

	@Override
	public ResultMessage comfirmGradeRule(GradeRuleVO gradeRuleVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage comfirmWebStrategy(WebStrVO webStrVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
