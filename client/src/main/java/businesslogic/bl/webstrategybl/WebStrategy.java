package businesslogic.bl.webstrategybl;

import java.util.Date;

import util.ResultMessage;
import util.TradingArea;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebStrVO;
/**
 * 网站策略类
 * @author CYF
 * @version 1.0
 */
public class WebStrategy {
    /**
     * 获取网站最佳策略
     * @param credit
     * @param area
     * @param time
     * @return WebBestStrVO
     */
	public WebBestStrVO getWebBestStrategy(String credit, TradingArea area, Date time) {
		return null;
	}
    /**
     * 获取网站等级策略 委托给WebGradeRule
     * @param webGradeRule
     * @return GradeRuleVO
     */
	public GradeRuleVO getGradeRule(WebGradeRule webGradeRule) {
		return webGradeRule.getCredit();
	}
    /**
     * 获取网站策略 委托给接口
     * @param webStrategyInterface
     * @return WebStrVO
     */
	public WebStrVO getWebStrategy(WebStrategyInterface webStrategyInterface) {
		return webStrategyInterface.getWebStrategy();
	}
    /**
     * 修改网站等级规则 委托给webGradeRule
     * @param webGradeRule
     * @param vo
     * @return ResultMessage
     */
	public ResultMessage confirmGradeRule(WebGradeRule webGradeRule,GradeRuleVO vo) {
		return webGradeRule.setCredit(vo);
	}
    /**
     * 修改网站策略 委托给接口
     * @param webStrategyInterface
     * @param vo
     * @return ResultMessage
     */
	public ResultMessage confirmWebStrategy(WebStrategyInterface webStrategyInterface,WebStrVO vo) {
		return webStrategyInterface.setWebStrategy(vo);
	}

}
