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
	private static WebGradeRule webGradeRule;
	private WebGradeRule(){
		
	}
	public static WebGradeRule getInstance() {
		if(webGradeRule==null){
			webGradeRule=new WebGradeRule();
		}
		return webGradeRule;
	}
    /**
     * 获取信用值
     * @return GradeRuleVO
     */
	public GradeRuleVO getGradeRule() {
		return null;
	}
    /**
     * 设置信用值
     * @param vo
     * @return ResultMessage
     */
	public ResultMessage setGradeRule(GradeRuleVO vo) {
		return null;
	}
}
