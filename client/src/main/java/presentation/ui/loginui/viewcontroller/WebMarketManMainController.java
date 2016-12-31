package presentation.ui.loginui.viewcontroller;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.ui.creditui.view.Clientdeposite_JPanel;
import presentation.ui.orderui.view.Searchorder_JPanel;
import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
import presentation.ui.webstrategyui.view.WebSpecialAreaStr_JPanel;
import presentation.ui.webstrategyui.view.Webspecialtimestr_JPanel;
import util.UserType;
import util.WebStrategyType;

/**
 * 控制网站营销人员界面的跳转
 * @author CLL
 *
 */
public class WebMarketManMainController {
	private JFrame frame;//发起界面跳转的界面对象
	private JPanel view;
	public WebMarketManMainController(JFrame frame){
		this.frame=frame;
	}

	
	public void jumpToCreditDepositView(){
		frame.remove(view);

		frame.add(view);
	}
	
	public void jumpToMakeVIPRulesView(){
		frame.remove(view);
		view=new Clientlevelrule_JPanel();
		frame.add(view);
	}
	
	public void jumpToMakeStrategyView(){
		frame.remove(view);
		view=new Makewebstr_JPanel();
		frame.add(view);
	}
}
