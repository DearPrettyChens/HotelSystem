package presentation.ui.webstrategyui.viewcontroller;

import util.WebStrategyType;

/**
 * 控制网站营销策略界面的接口
 * @author CLL
 *
 */
public interface WebStrategyViewControllerService {
	public void selectStrategyType(WebStrategyType type);
	/**
	 * 制定策略成功后更新策略列表
	 */
	public void addStrategySuccess(WebStrategyType type);
	/**
	 * 制定会员等级规则成功后更新策略列表
	 */
	public void modifyVIPRuleSuccess();
	/**
	 * 返回主界面
	 */
	public void jumpToMainFrame();
}
