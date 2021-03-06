package businesslogic.bl.userbl.mock;

import dao.webstrategydao.WebStrategyDao;
import vo.webstrategyvo.GradeRuleVO;
/**
 * WebGradeRule的mock类
 * @author Csy
 * @version 1.0
 */
public class MockWebGradeRule{
	//每升一级的信用值
		private int credit;
		private WebStrategyDao webStrategyDao;
		
	/**
     * 获取信用值
     * @return GradeRuleVO
     */
	public GradeRuleVO getCredit() {
		return new GradeRuleVO( 100);
	}
}
