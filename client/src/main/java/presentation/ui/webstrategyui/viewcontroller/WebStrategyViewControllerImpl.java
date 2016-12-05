package presentation.ui.webstrategyui.viewcontroller;

import javax.swing.JPanel;

import presentation.ui.webstrategyui.distributecontroller.WebstrategyDistributionController;
import presentation.ui.webstrategyui.view.ChooseStrategy_JPanel;
import presentation.ui.webstrategyui.view.Clientlevelrule_JPanel;
import presentation.ui.webstrategyui.view.Makewebstr_JPanel;
import presentation.ui.webstrategyui.view.WebSpecialAreaStr_JPanel;
import presentation.ui.webstrategyui.view.Webclientlevelstr_Jpanel;
import presentation.ui.webstrategyui.view.Webspecialtimestr_JPanel;
import util.WebStrategyType;
/**
 * 制定网站营销策略界面的控制器
 * @author CLL
 *
 */
public class WebStrategyViewControllerImpl{
	private JPanel view;//发起界面跳转的界面对象
	public WebStrategyViewControllerImpl() {
	}
	public WebStrategyViewControllerImpl(JPanel view){
		this.view=view;
	}
	

	public void addStrategySuccess(WebStrategyType type) {
		view.removeAll();
		switch(type){
		case SPECIALAREA:
			view.add(new WebSpecialAreaStr_JPanel());
			break;
		case SPECIALTIME:
			view.add(new Webspecialtimestr_JPanel());
			break;
		case VIP:
			view.add(new Webclientlevelstr_Jpanel());
			break;
		default:
			break;
		}
	}

	public void modifyVIPRuleSuccess() {
		view.removeAll();
		view=new Clientlevelrule_JPanel();
	}

	public void jumpToMainFrame() {
		view=null;
		
	}

	
	public void selectStrategyType(WebStrategyType type,ChooseStrategy_JPanel chooseStrategy_JPanel) {
		switch(type){
		case SPECIALAREA:
			chooseStrategy_JPanel.changeToAreaStr();
			break;
		case SPECIALTIME:
			chooseStrategy_JPanel.changeToTimeStr();
			break;
		case VIP:
			chooseStrategy_JPanel.changeToLevelStr();
			break;
		default:
			break;
		
		}
		
	}

	
	public void backToselectStrategy() {
		view.removeAll();
	}

}
