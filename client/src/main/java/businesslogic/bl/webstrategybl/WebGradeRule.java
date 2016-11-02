package businesslogic.bl.webstrategybl;

import dao.webstrategydao.WebStrategyDao;
import util.ResultMessage;
import vo.webstrategyvo.GradeRuleVO;
/**
 * 网站等级规则类
 * @author CYF
 * @version 1.0
 */
public class WebGradeRule {
	//每升一级的信用值
	private int credit;
	private WebStrategyDao webStrategyDao;
	public WebGradeRule(){
		
	}
    /**
     * 获取信用值
     * @return GradeRuleVO
     */
	public GradeRuleVO getCredit() {
		return null;
	}
    /**
     * 设置信用值
     * @param vo
     * @return ResultMessage
     */
	public ResultMessage setCredit(GradeRuleVO vo) {
		return null;
	}
}
