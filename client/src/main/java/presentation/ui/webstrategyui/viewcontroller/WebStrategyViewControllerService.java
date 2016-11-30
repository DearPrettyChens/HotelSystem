package presentation.ui.webstrategyui.viewcontroller;
/**
 * 控制网站营销策略界面的接口
 * @author CLL
 *
 */
public interface WebStrategyViewControllerService {
	/**
	 * 制定策略成功后更新策略列表
	 */
	public void addStrategySuccess();
	/**
	 * 制定会员等级规则成功后更新策略列表
	 */
	public void modifyVIPRuleSuccess();
}
