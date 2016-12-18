package blservice.webstrategyblservice;



import java.util.Date;

import common.ResultMessage;
import common.TradingArea;
import common.WebStrategyType;
import vo.webstrategyvo.GradeRuleVO;
import vo.webstrategyvo.WebBestStrVO;
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
<<<<<<< HEAD
	 * @param credit String型,area TradingArea型,time Date型，传递策略所需的信用值商圈和时间
=======
	 * @param credit String型,area TradingArea型,time String型，传递策略所需的信用值商圈和时间
>>>>>>> refs/remotes/origin/cyfBranch
	 * @return WebBestStrVO ，将最佳网站策略返回给界面或order模块
	 * @throws 未定
	 *
	 */
	public WebBestStrVO getWebBestStrategy(String credit,TradingArea area,Date time);
	
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
	public ResultMessage comfirmGradeRule(GradeRuleVO gradeRuleVO);
	
	/**
	 * 保存网站策略信息
	 * @param webStrVO WebStrVO型，界面传递过来的网站策略信息
	 * @return ResultMessage，保存成功返回SUCCESS,失败返回FAIL，格式错误返回具体什么格式错误
	 * @throws 未定
	 *
	 */
	public ResultMessage comfirmWebStrategy(WebStrVO webStrVO);
	
}
