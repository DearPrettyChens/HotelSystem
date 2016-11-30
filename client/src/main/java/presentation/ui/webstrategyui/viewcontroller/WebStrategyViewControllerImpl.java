package presentation.ui.webstrategyui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
/**
 * 制定网站营销策略界面的控制器
 * @author CLL
 *
 */
public class WebStrategyViewControllerImpl implements  WebStrategyViewControllerService{
	private JPanel view;//发起界面跳转的界面对象
	public WebStrategyViewControllerImpl(JPanel view){
		this.view=view;
	}
	@Override
	public void addStrategySuccess() {
		view.removeAll();
		view.add(new Makewebstr_JPanel());
	}

	@Override
	public void modifyVIPRuleSuccess() {
		view.removeAll();
		view.add(new Clientlevelrule_JPanel());
	}

}
