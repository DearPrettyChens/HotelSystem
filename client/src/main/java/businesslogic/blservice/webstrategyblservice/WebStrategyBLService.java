package businesslogic.blservice.webstrategyblservice;



import util.ResultMessage;
import util.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
import vo.webstrategyvo.WebProvidedVO;
import vo.webstrategyvo.WebStrVO;
/**
 * WebStrategyBLService提供接口，用来对网站营销策略以及会员等级的制定和修改
 * @author csy
 * @version 1.0
 * 
 */
public interface WebStrategyBLService {
	/**
	 * 获取最佳网站策略
	 * @param WebProvidedVO，传递策略所需的信息
	 * @return WebBestStrVO ，将最佳网站策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public WebBestStrVO getWebBestStrategy(WebProvidedVO webProvidedVO);
	
	/**
	 * 获取会员等级规则
	 * @param 无
	 * @return GradeRuleVO，将会员等级规则返回给界面
	 * @throws 未定
	 *
	 */
	public GradeRuleVO getGradeRule();
	
	/**
	 * 获取网站策略
	 * @param type WebStrategyType型，传递策略类型
	 * @return WebStrVO ，将网站策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public WebStrVO getWebStrategy(WebStrategyType type);
	
	
	/**
	 * 保存网站会员等级规则信息
	 * @param gradeRuleVO GradeRuleVO型，界面传递过来的会员等级规则信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 *注意点：方法里面要有检测：checkDiscountRank：（折扣范围）
	 *checkTime：（保证从小到大）checkPositiveNum：（保证输入正数）
	 */
	public ResultMessage confirmGradeRule(GradeRuleVO gradeRuleVO);
	
	/**
	 * 保存网站策略信息
	 * @param webStrVO WebStrVO型，界面传递过来的网站策略信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage confirmWebStrategy(WebStrVO webStrVO);
	
}
