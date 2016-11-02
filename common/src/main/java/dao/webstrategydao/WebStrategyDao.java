package dao.webstrategydao;


import po.GradeRulePO;
import po.WebStrPO;
import util.ResultMessage;
import util.WebStrategyType;
/**
 * WebStrategyDao,用来对网站策略的数据进行操作
 * @author CYF
 * @version 1.0
 * 
 */
public interface WebStrategyDao {
	/**
	 * 
	 */
	public void initial();
	/**
	 * 获得等级规则
	 * @return GradeRulePO型，返回网站的等级策略信息
	 * @throws 未定
	 */
	public GradeRulePO getGradeRule();
	/**
	 * 获取网站的营销策略
	 * @param type WebStrategyType型，传递网站营销策略信息
	 * @return WebStrPO型，返回网站营销策略信息
	 * @throws 未定
	 */
	public WebStrPO getWebStrategy(WebStrategyType type);
	/**
	 * 设置网站的等级策略
	 * @param po GradeRulePO型，传递网站等级规则信息
	 * @return ResultMessage型，如果设置成功则返回SUCCESS,如果失败返回FAIL
	 * @throws 未定
	 */
	public ResultMessage setGradeRule(GradeRulePO po);
	/**
	 * 设置网站的营销策略
	 * @param po WebStrPO型，如果设置成功则返回SUCCESS,如果失败返回FAIL
	 * @return 未定
	 */
	public ResultMessage setWebStrategy(WebStrPO po);
}
