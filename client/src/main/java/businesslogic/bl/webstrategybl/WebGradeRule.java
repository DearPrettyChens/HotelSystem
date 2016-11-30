package businesslogic.bl.webstrategybl;

import java.rmi.RemoteException;

import dao.webstrategydao.WebStrategyDao;
import init.RMIHelper;
import po.GradeRulePO;
import util.ResultMessage;
import vo.webstrategyvo.GradeRuleVO;
/**
 * 网站等级规则类
 * @author CYF
 * @version 1.0
 */
public class WebGradeRule {
	private GradeRulePO gradeRulePO;
	private WebStrategyDao webStrategyDao;
	
	private static WebGradeRule webGradeRule;
	private WebGradeRule(){
//		webStrategyDao=RMIHelper.getWebStrategyDao();
	    webStrategyDao=new WebStrategyDao_Stub();
	}
	public static WebGradeRule getInstance() {
		if(webGradeRule==null){
			webGradeRule=new WebGradeRule();
		}
		return webGradeRule;
	}
	
	/**
     * 获取会员等级
     * @return GradeRuleVO
     */
	public int getGrade(int credit){
		getGradeRule();
		int gradeCredit=gradeRulePO.getCredit();
		if(gradeCredit==0){
			return 0;
		}
		int grade=credit/gradeCredit;//计算用户等级
    	return grade;
		
	}
    /**
     * 获取会员等级规则
     * @return GradeRuleVO
     */
	public GradeRuleVO getGradeRule() {
		try {
			gradeRulePO=webStrategyDao.getGradeRule();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new GradeRuleVO(gradeRulePO);
	}
    /**
     * 设置会员等级规则
     * @param vo
     * @return ResultMessage
     */
	public ResultMessage setGradeRule(GradeRuleVO vo) {
		gradeRulePO=vo.toPO();
		try {
			return webStrategyDao.setGradeRule(gradeRulePO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
}
